$('table').on('click', 'button[id="updateButton"]', function(e){
		$.ajax({
			type:'post'
			,url:'/updateform'
			,dataType:'html'
			,success:function(data){
				$("#updateDiv").html(data);
			}
		});
	});
	
$('table').on('click', 'button[id="deleteButton"]', function(e){
		alert("삭제되었습니다.");
	});



//ready function 시작	
$(document).ready(function(){

	getDataTable();

	$("#addButton").click(function(){
		$.ajax({
			type:'post'
			,url:'/addform'
			,dataType:'html'
			,success:function(data){
				$("#addDiv").html(data);
				
			}
		});
	})


	function jsonDATA() {
		var jsonData;
		$.ajax({
			url:"http://localhost:8080/json",
			dataType:"json",
			type: "GET",
			async : false,
			success: function(data) {
				console.log('data = ', data);
				jsonData = data;
			}
		});
		
		return jsonData;
	}
	
	var jsonData = jsonDATA();
	console.log("jsonData = ", jsonData);

	// Custom logic start.
	var jsonDataNextID = jsonData.length + 1;
	function getIndexById(id) {
		var idx,
		l = jsonData.length;
			for (var j=0; j < l; j++) {
				if (jsonData[j].listNum == id) {
               	return j;
            }
        }
		return null;
    }
    // Custom logic end.
	
	// dataSource
	var dataSource = new kendo.data.DataSource({
		transport: {
			read: {
				url:"/json",
				type:"post",
				dataType:"json"
			},
			//function(e) {
			//	e.success(jsonData);
			//},
			/*
			<form action="/add" method="post">
				<input type="number" name="listNum" placeholder="number"> 
				<input type="text" name="listName" placeholder="name">
				<button type="submit" class="btn btn-danger" id="saveButton">추가하기</button>
			</form>
			*/
			create: {
				url:"/add",
				type:"post",
				dataType:"json"
			},
			update: {
				url:"/update",
				type:"post",
				dataType:"json"
			},
			destroy: {
				url:"/delete",
				type:"get",
				dataType:"json"
			}
		},
		error: function(e) {
			console.log("Status: " + e.status + "; Error message: " + e.errorThrown);
		},
		pageSize: 10,
		schema: {
			parse: function(data) {
				var events = [];
		        for (var i = 0; i < data.length; i++) {
		        	var event = data[i];
		            event.EventDate = kendo.toString(new Date(event.regDate), 'yyyy/MM/dd');
		            // console.log("event = ", kendo.toString(new Date(event.regDate), 'yyyy/MM/dd') ); 
		            events.push(event);
		        }
			 	return events;
			},
			model: {
					id: "listNum",
					fields: {
			 		listNum: {nullable:true},
			 		listName: { validation: {required: true}, type:"string"},
			 		regDate: {editable: false, type: "date"},
			 		EventDate: {type: "date"}
			 	}
			}	
		}	
	});	
	$("#editor").kendoEditor({
  		resizable: {
    		content: true,
    		toolbar: true,
  		},
	});	
	
	$("#grid").kendoGrid({
			dataSource: dataSource,
			toolbar: ["create"],
			columns:[{title:"Num", field: "listNum", width: 200},
					 {title:"Name", field: "listName", width: 200},
					 {title:"Date", field: "EventDate", width: 200,
						 template: "#= kendo.toString(regDate, 'yyyy/MM/dd HH:mm') #"},
					 {command: ["edit", "destroy"], title: "&nbsp;", width: "200px"}
	        ],
	        editable: "inline",
			height: 400,
			scrollable: true,
			pageable: {
	             refresh: true,
	             pageSizes: true,
	             buttonCount: 5
	        },
	        //필터
	        filterable: {
                extra: false,
                mode: "row"
            },
            //정렬
			sortable: {
				mode: "multiple"
			},
			//그룹
			groupable: true
		});
		

	function getDataTable() {
		$.ajax({
			type: "GET",
		    async: true,
		    url: "http://localhost:8080/jsonData",
		    dataType: "json",
		    success: function(data) {
		    	var html='';
				$.each(data,function(key, value) {
					
					html += '<tr>';
					html += '<td class="listtd">' + value.listNum + '</td>';
					html += '<td class="listtd">' + value.listName + '</td>';
					html += '<td class="listtd">' + '<button id="updateButton" class="btn btn-success">수정</button>'
					+ '<button id="deleteButton" onclick="location.href=\'/delete?listNum='+value.listNum+'\'" class="btn btn-danger">삭제</button>' + '</td>';		
					html += '</tr>';
				});
				$("#tbody").html(html);
				page();
		    },
		    error: function(data) {
		    	console.log(data);
		    }
	    });
	    
	}

	function page() {
		$('table.paginated').each(function() {
			var reSortColors = function($table) {
		  	$('tbody tr:odd td', $table).removeClass('listtd');
  			$('tbody tr:even td', $table).removeClass('listtd');
 			};
			var pagesu = 10;
			var currentPage = 0;
			var numPerPage = 10;
			var $table = $(this);
			
			var numRows = $table.find('tbody tr').length;

			var numPages = Math.ceil(numRows / numPerPage);
  
  			if (numPages==0) return;
  
  			var $pager = $('<td align="center" id="remo" colspan="10"><div class="pager"></div></td>');
  
  			var nowp = currentPage;
  			var endp = nowp+10;
  
  
 			$table.bind('repaginate', function() {

			$table.find('tbody tr').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
   			$("#remo").html("");
   
   			if (numPages > 1) {     // 한페이지 이상이면
    			if (currentPage < 5 && numPages-currentPage >= 5) {   // 현재 5p 이하이면
     				nowp = 0;     // 1부터 
     				endp = pagesu;    // 10까지
    			} else {
     				nowp = currentPage -5;  // 6넘어가면 2부터 찍고
     				endp = nowp+pagesu;   // 10까지
     				pi = 1;
    			}
    
    			if (numPages < endp) {   // 10페이지가 안되면
     			endp = numPages;   // 마지막페이지를 갯수 만큼
     			nowp = numPages-pagesu;  // 시작페이지를   갯수 -10
    			}
    			if (nowp < 1) {     // 시작이 음수 or 0 이면
     			nowp = 0;     // 1페이지부터 시작
    			}
   			} else {       // 한페이지 이하이면
			    nowp = 0;      // 한번만 페이징 생성
    			endp = numPages;
   			}
   			
   			$('<br /><span class="page-number" cursor: "pointer">[처음]</span>').bind('click', {newPage: page},function(event) {
          		currentPage = 0;   
          		$table.trigger('repaginate');  
          		$($(".page-number")[2]).addClass('active').siblings().removeClass('active');
      		}).appendTo($pager).addClass('clickable');
      		
      		$('<span class="page-number" cursor: "pointer">&nbsp;&nbsp;&nbsp;[이전]&nbsp;</span>').bind('click', {newPage: page},function(event) {
          		if(currentPage == 0) return; 
          		currentPage = currentPage-1;
    			$table.trigger('repaginate'); 
    		$($(".page-number")[(currentPage-nowp)+2]).addClass('active').siblings().removeClass('active');
   			}).appendTo($pager).addClass('clickable');
    														
   			for (var page = nowp ; page < endp; page++) {
    			$('<span class="page-number" cursor: "pointer" style="margin-left: 8px;"></span>').text(page + 1).bind('click', {newPage: page}, function(event) {
     				currentPage = event.data['newPage'];
     				$table.trigger('repaginate');
     				$($(".page-number")[(currentPage-nowp)+2]).addClass('active').siblings().removeClass('active');
     			}).appendTo($pager).addClass('clickable');
   			} 

      		$('<span class="page-number" cursor: "pointer">&nbsp;&nbsp;&nbsp;[다음]&nbsp;</span>').bind('click', {newPage: page},function(event) {
    			if(currentPage == numPages-1) return;
        		currentPage = currentPage+1;
    			$table.trigger('repaginate'); 
     			$($(".page-number")[(currentPage-nowp)+2]).addClass('active').siblings().removeClass('active');
   			}).appendTo($pager).addClass('clickable');

   			$('<span class="page-number" cursor: "pointer">&nbsp;[끝]</span>').bind('click', {newPage: page},function(event) {
           		currentPage = numPages-1;
           		$table.trigger('repaginate');
           		$($(".page-number")[endp-nowp+1]).addClass('active').siblings().removeClass('active');
   			}).appendTo($pager).addClass('clickable');
     
     		$($(".page-number")[2]).addClass('active');
			reSortColors($table);
  		});
   		$pager.insertAfter($table).find('span.page-number:first').next().next().addClass('active');   
   		$pager.appendTo($table);
   		$table.trigger('repaginate');
 		});
	}
});
// ready function 끝

    

