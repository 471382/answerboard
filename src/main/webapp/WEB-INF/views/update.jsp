  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Modify Page</title>
<script>
$(document).ready(function() {
	var fObject=$(".form");
	
	$(".btnCancel").on("click",function(){

		fObject.attr("method","get");
		fObject.attr("action","/ex/list");
		fObject.submit();
		
	})			
	$(".btnSave").on("click",function(){
		fObject.attr("method","post");
		fObject.attr("action","/ex/update");
		fObject.submit();
	})
	
});
</script>
</head>
<body>
	<div class="main">
		<form class="form" method="post">
			<input type='hidden' name='bno' value="${dto.bno }">
			<h1>수정</h1>
			<h2>제목<BR>
				<input type='text' name='title' style="width:40%" value="${dto.title }">
			</h2>
			<h2>내용<BR>
			<textarea style="width:40%;" name='content' rows="5">${dto.content }</textarea>
			</h2>
			<h2>작성자<BR>${dto.writer }
				<input type='hidden' name='writer' value="${dto.writer }">
			</h2>
			<input type='hidden' name='page' value="${pageMaker.page}">
			<input type='hidden' name='perPageNum' value="${pageMaker.perPageNum }">
			<input type='hidden' name='searchType' value="${pageMaker.searchType }">
			<input type='hidden' name='keyword' value="${pageMaker.keyword }">
		</form>
		<button type="submit" class="btnSave">저장</button>
		<button type="submit" class="btnCancel">취소</button>
	</div>
</body>
</html>