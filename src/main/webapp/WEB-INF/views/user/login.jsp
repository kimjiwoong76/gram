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
<link rel="stylesheet" href="<c:url value='/assets/css/form.css' />" />

</head>
<body>
	<header>
		<c:out value="${userVO.userId}" />
	</header>
	<section>
		<div class="form_box login_form">
			<div class="form_head">
				<p>LOGIN</p>
			</div>
			<div class="login_inner">
				<div class="form_inner">
					<form action="<c:url value="/user/loginProcess" />" method="POST">
						<div class="login_form clearfix">
							<div class="login_input_area">
								<div class="id_area input_area">
									<input type="text" name="userId" placeholder="아이디">
								</div>
								<div class="pw_area input_area">
									<input type="password" name="userPassword" placeholder="비밀번호">
								</div>
							</div>
						</div>
						<div class="login_form_btn">
							<button type="submit" class="login_form_submit">로그인</button>
						</div>
						<div class="login_member clearfix">
							<a href="#!" class="member_page">회원가입</a>
						</div>
						<!-- csrf 공격을 막기위해서 hidden태그로 보내준다. -->
						<input type='hidden' name='${_csrf.parameterName }' value='${_csrf.token }'>
					</form>
				</div>
				<div class="form_inner">
					<div class="check_area clearfix">
						<div class="find_info">
							<a href="/find_id.do">아이디찾기</a> <a href="/find_pw.do">비밀번호찾기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
</body>
</html>