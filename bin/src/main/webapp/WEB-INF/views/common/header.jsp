<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title" /></title>

<!-- css -->
<link rel="stylesheet" href="<c:url value='/assets/css/reset.css' />" />
<link rel="stylesheet" href="<c:url value='/assets/css/form.css' />" />

<script src="<c:url value='/assets/js/jquery-1.8.3.min.js' />"></script>

</head>
<body>
	<header>
		<c:out value="${userVO.userId}" />
	</header>
	<section>