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

/*
function chartData(data) {
		$('#container').hightcharts({
			chart: {
				type: 'column'
			},
			ttitle: {
				text: 'HELLO'
			},
			xAxis: {
				type: 'date',
				labels: {
					formatter: function() {
						return Highcharts.dateFormat('%b %e. %y', this.value, 1);
					}
				}
			},
			yAxis: {
				title: {
					text: 'Number'
				}
			},
			series: data
		});
	}
*/
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
	
	$("#detailButton").click(function(){
		$.ajax({
			type:'GET'
			,url:'/detail/#=listNum#'
			,dataType:'html'
			,success:function(data){
				$("#detailDiv").html(data);
				
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
				//console.log('data = ', data.origin[1]);
				jsonData = data;
			}
		});
		
		return jsonData;
	}
	
	var jsonData = jsonDATA();
	console.log("jsonData = ", jsonData);
	
//------------------------------------------------------------------------------------------		
	
	
	function regdate() {
		$.ajax({
			url:"http://localhost:8080/regdate",
			dataType:"json",
			type: "GET",
			async : false,
			success: function(data) {
				regdate = data;
			}
		});
		return regdate;
	}
	var regdate = regdate();
	console.log("regdate  = ", regdate);
	
	// JSON 특정 컬럼값 배열로 추출
	var list1 = new Array();
	$.each(regdate,function(index, item) {

		list1.push(item.listName);
	})
	console.log("list1 = ", list1);
	
	var list2 = new Array();
	$.each(regdate,function(index, item) {

		list2.push(item.dateCnt);
	})
	console.log("list2 = ", list2);
	
	var list3 = new Array();
	$.each(regdate,function(index, item) {

		list3.push(item.test);
	})
	console.log("list3 = ", list3);
	

	
	
	let title={text:'날짜별 등록 게시글 수'};
	let subtitle={text:'날짜별 등록 게시글 수'};
	let xAxis = {
		//날짜별 데이터
		categories: list3
	};
	let yAxis = {
		title: {
			text:'게시글 수'	
		},
		plotLines:[{
			value:0,
			width:1,
			color:'#808080'
		}]
	};
	let legend={
		layout:'vertical',
		align:'right',
		vericalAlign:'middle',
		borderWidh:0
	};
	let series=[{
		name:'10월',
		//게시글 수 데이터
		data:list2	
	}];
	let json={};
	json.title=title;
	json.subtitle=subtitle;
	json.xAxis=xAxis;
	json.yAxis=yAxis
	json.series=series;
	
	$("#container").highcharts(json);



//-----------------------------------------------------------------------------------



	/*// Custom logic start.
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
    // Custom logic end.*/
	
	// dataSource
	var dataSource = new kendo.data.DataSource({
		transport: {
			read: {

				url:"/json", 
				type:"post",
				dataType:"json",
				cache:false
				
			},
				
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
			//서버 응답이 사용되기 전에 실행됩니다. 이를 사용하여 서버 응답을 전처리하거나 구문 분석하십시오.
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
			//데이터 항목 (모델) 구성입니다.
			model: {
				// 모델의 id값 , 이 필드는 ID가 모델 구성에 정의된 경우에만 사용할 수 있다
				id: "listNum",
				// 모델 ID 필드의 이름. 이 필드는 ID가 모델 구성에 정의된 경우에만 사용할 수 있다.
				fields: {
					// editable : 지정된 필드가 편집 가능한지 여부를 결정한다.
					// define : 제공된 옵션을 사용하여 새 모델 유형을 정의하십시오. 반환된 값은 kendo.data에서 상속된다.모델 클래스.
			 		listNum: {nullable:true},
			 		listName: {},		
			 		fileOriName: {validation: {required: false}, editable: false},
			 		//files: {},
			 		//ResumeFileUrl: {validation: {required: true}, type:"string", template:},
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
			/*dataBound: function(e) {
				$("input[type='file']").kendoUpload({
	                async: {
	                    saveUrl: "/save",
	                    removeUrl: "/remove",
	                    autoUpload: true
	                }
	           	});
			},*/
			toolbar: ["create"],
			columns:[{title:"Num", field:"listNum", width:200},
					 {title:"Name", field:"listName", width:200,
					 template:"<a class='k-button' id='detailButton' href='/detail/#=listNum#'>#=listName#</a>"},
					 {title:"File", field:"fileOriName", width:200, 
					  //command:{name:"open",click:function(e) {	},template: "<input type='file' name='files'/>"}
					 },
					  //{command:["edit", "destroy"], title:"Action", width: "200px"}
					  /*{
  command: [{
  name: "edit",
  iconClass:"k-icon k-i-copy",
  text: {
     edit: "Custom edit", //누르면
     cancel: "Custom cancel", //이거하고
     update: "Custom update" // 이게 생김
  }
 }]
},
{
  command: [{
  name: "edit",
  text: {
     edit: "filename", //누르면
     cancel: "upload", //이거하고
     update: "Custom update" // 이게 생
  }
 }]
},*/
					  
					  
					  //{command:{template: "<input type='file' name='files'/>"}},
					 
					 
					 
					 
					 //{title:"File", field:"fileOriName", width:200,
					 //template:"<input type='file' name='files' placeholder='file'>"},
					 //{command:{name:"open",click:function(e) {	},template: "<input type='file' name='files'/>"}, title:"File", width:200},
					 
					 
					//template:"<a class='k-button' id='detailButton' href='/detail/#=listNum#'>#=listName#</a>"},
					 //{title:"File", field:"fileName", width:200, 
					 //template:"<button>Upload</button>"},
					 //template:"<input type='button' class='k-button' name='ㅋㅋㅋ' value='ㅋㅋㅋ'/>"},
					// template:"<input type='button' class='k-button' name='Upload' value='Upload'/>"},
				   //{title:"Resume", field:"ResumeFileUrl", width:"80px",
				   // 	 template:'<button class="k-button" onClick="uploadFiles(#=fileName#)">Upload<br/>Files</button>' },
				   
					 {title:"Date", field:"EventDate", width:200,
						 template:"#= kendo.toString(regDate, 'yyyy/MM/dd HH:mm') #"},
					 {command:["edit", "destroy"], title:"Action", width: "200px"}
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
					//html += '<td class="listtd"><a class="k-button" id="detailButton" href="/detail/'+value.listNum+'>+value.listName+'</a></td>';
					html += '<td class="listtd"><a class="k-button" href="/detail2/'+value.listNum+'">' + value.listName + '</a></td>';
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

    

