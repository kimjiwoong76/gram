<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/member/mypage">유저페이지</a>
	<a href="/admin/index">관리자페이지</a>
	 <sec:authorize access="hasRole('ROLE_ADMIN')">
	 	관리자
	 </sec:authorize>
	 <sec:authorize access="isAuthenticated()">
	 <a href="/user/logout">로그아웃</a>
	 </sec:authorize>
</body>
</html>