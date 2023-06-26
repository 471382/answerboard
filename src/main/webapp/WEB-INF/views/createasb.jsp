  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/template.css"/>
<title>Reply Write Page</title>
</head>
<body>
	<form role="form" action="/ex/createasb" method="post">
		<input type="hidden" name="bno" value="${bno }">
		<h1 class = "writeTitle"> 제목 <BR> <input type="text"
				name='title' placeholder="제목을 입력해 주세요" style="width:60%; height:30px" required></h3> 
		<h2 class = "writeText"> 내용 <BR>
			<textarea name="content" rows="8" style="width:60%"
				placeholder="내용을 입력해 주세요." required></textarea></h2>
		
		<h2 class = "writer"> 작성자 <BR>
			<input type="text"
				name="writer"  placeholder="작성자" value="익명" style="width:60%"></h2> 
		<button type="submit" class="btn">새글등록</button>
		
		
		
	</form>
</body>
</html>