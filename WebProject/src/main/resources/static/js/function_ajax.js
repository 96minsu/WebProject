$(function(){
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
})