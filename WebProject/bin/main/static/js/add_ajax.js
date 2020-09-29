$(function(){
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
})
