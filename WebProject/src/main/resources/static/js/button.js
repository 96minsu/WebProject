$(function() {
	$.getJSON('http://localhost:8080/jsonData', function( data ) {
		var html='';
		$.each(data,function(key, value) {
			html += '<tr>';
			html += '<td>' + value.listNum + '</td>';
			html += '<td>' + value.listName + '</td>';
			html += '<td>' + '<input type="button" id="updateButton" class="btn btn-success" value="수정"/> <br>' + '<input type="button" id="deleteButton" class="btn btn-danger" value="삭제"/>' + '</td>';			
			html += '</tr>';
		});
		$("#tbody").html(html);
	});;
});

	$("#updateButton").on("click",function(){
		$.ajax({
			type:'post'
			,url:'/updateform'
			,dataType:'html'
			,success:function(data){
				$("#updateDiv").html(data);
			}
		});
	})
 
 
var data = $.ajax({
	    	type: "GET",
	    	async: true,
	    	url: "http://localhost:8080/jsonData",
	    	dataType: "json",
	    	success: function() {
	    		
	    	},
	    	error: function() {
	    	}
	    });
console.log(data)
