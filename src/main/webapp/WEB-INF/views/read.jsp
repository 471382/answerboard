  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/template.css" />
<title>Read Page</title>
<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/ex/update");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/ex/delete");
		formObj.submit();
	});
	
	$(".btn-primary").on("click", function(){
		self.location = "/ex/list";
	});
	
});

</script>
</head>
<body>
 <div class="main">
  
<form role="form" method="get">
	<input type='hidden' name='bno' value="${dto.bno}">
</form>
	<h1 class="pageMotif">READ</h1>
	<h2 class="title">
		제목<BR>
		<div style = "border:2px solid blue; width:60%;">
		${dto.title }
		</div></h2>
	
		<h2 class="text">
		내용</h2><div style = "border:2px solid green; width:60%; height:600px;">
		<div class = "content">${dto.content}</div></div>
	
		<h2 class="writer">
		작성자 <BR><div style = "border:2px solid pink; width:30%;">${dto.writer }</div>
		</h2>

<!-- /.box-body -->
<div class="box-footer">
	<button type="submit" class="btn btn-warning">수정</button>
	<button type="submit" class="btn btn-danger">삭제</button>
	<button type="submit" class="btn btn-primary">글 목록</button>
</div>

			



</div>
	
</body>
</html>