$(function(){
	$("#closeButton").click(function(){
		$.ajax({
			type:'post'
			,url:'/index_ajax'
			,dataType:'html'
			,success:function(data)
		});
	})
})