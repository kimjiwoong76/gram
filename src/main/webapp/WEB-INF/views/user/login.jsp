<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="form">
	<div class="form_head">
		<p><spring:message code="login.title" /></p>
	</div>
	<div class="login_inner">
		<div class="form_inner">
			<form action="/user/loginProcess" method="POST">
				<div class="login_form clearfix">
					<div class="login_input_area">
						<div class="id_area input_area">
							<input type="text" name="shop_id" placeholder='<spring:message code="form.id" />'>
						</div>
						<div class="pw_area input_area">
							<input type="password" name="shop_pwd" placeholder='<spring:message code="form.pw" />'>
						</div>
						<div class="check_area clearfix">
							<div class="find_info">
								<a href="/find_id.do"><spring:message code="form.id.find" /></a> <a href="/find_pw.do"><spring:message code="form.pw.find" /></a>
							</div>
							<!-- <div class="login_check">
		                            <input type="checkbox" id="auto_login" class="form_chk_btn">
		                            <label for="auto_login">자동로그인</label>
		                        </div> -->
						</div>
					</div>
					<div class="login_form_btn">
						<button class="login_form_submit"><spring:message code="form.login.btn" /></button>
					</div>
				</div>
				<c:if test="${requestScope.loginFailMsg ne null}">
				<div class="login_message">
					<!-- 로그인 실패 시 출력할 메세지 -->
					<em>${requestScope.loginFailMsg}</em>
				</div>
				</c:if>
			</form>
		</div>
		<div class="form_inner">
			<div class="login_member clearfix">
				<p class="login_inner_info"><spring:message code="login.form.message" /></p>
				<a href="/user/signUp" class="member_page"><spring:message code="member.register" /></a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />