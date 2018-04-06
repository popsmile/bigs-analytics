<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table width="500", cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>종목</td>
			<td>설명</td>
			<td>부가설명</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.itemNo}</td>
			<td>${dto.itemName}</td>
			<td>${dto.itemDesc}</td>
			<td>${dto.itemDesc2}</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>