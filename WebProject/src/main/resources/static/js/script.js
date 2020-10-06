
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


$(document).ready(function(){

	getDataTable();
	
	$('table').on('click', 'button[id="delete"]', function(e){
       var id = $(this).closest('tr').children('td:first').text();
       
       $.ajax({
            type:"DELETE",
            url:"http://localhost:8080/api/users/" + id,
            success: function(data){
                alertUsing("Silindi.", true);
                assignDataToTable();
            },
            error: function(err) {  
                console.log(err);
                alert(err);
            }
        });

    })
	
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
	
	
	$("#saveButton").click(function(){
		$.ajax({
			type:'post'
			,url:'/add'
			,dataType:'html'
			,success:function(data){
				$("#list").html(data);
				
			}
		});
	})
	
	$("#button3").click(function(){
		alert('hi');
	})
	
	
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
					html += '<td>' + value.listNum + '</td>';
					html += '<td>' + value.listName + '</td>';
					html += '<td>' + '<button id="updateButton" class="btn btn-success">수정</button>'
					+ '<button onclick="location.href=\'/delete?listNum='+value.listNum+'\'" class="btn btn-danger">삭제</button>' + '</td>';		
					html += '</tr>';
					
				});

					
				$("#tbody").html(html);
				console.log(data);
		    },
		    error: function(data) {
		    	console.log(data);
		    }
	    });
	}  
})


    

