<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<body>
	<div id="result"></div>
	
	<script src="/static/js/jquery-1.11.3.min.js"></script>
	
	<script>
	
		$(function(){
			var maxId = 0;
			
			function liu(){
				
				$.get("/timeline",{"maxId":maxId}).done(function(data){
					if(data.length){
						for(var i=0;i<data.length;i++){
							var item = data[i];
							var html = "<h3>"+item.id+"</h3>";
							
							if(maxId == 0){
								$(html).appendTo($("#result"));
							}else{
								$(html).prependTo($("#result"));
							}
						}
					}
				}).error(function(){
					alert("服务器错误");
					clearInterval(st);
				});
				
			}
			
			liu();
			
			var st = setInterval(liu,5000);
			
			
			
			
		});
	
	</script>
</body>
</html>