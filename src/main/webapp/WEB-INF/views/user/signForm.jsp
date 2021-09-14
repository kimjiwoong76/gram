<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="form">
	<div class="form_head">
		<p>JOIN US</p>
	</div>
	<div class="join_inner">
		<div class="register_head clearfix">
			<p class="register_head_tit">
				가입정보<span>*필수입력항목.</span>
			</p>
			<ul class="register_seq">
				<li>01 약관동의</li>
				<li class="on">02 정보입력</li>
				<li>03 가입완료</li>
			</ul>
		</div>
		<div class="form_inner">
			<form id="memberForm" class="form-horizontal" role="form"
				method="post" action="/user/signFormAction" name="userSign" onsubmit="return formComfirm(this);">
				<input type="hidden" name="command" value="regform">
				<div class="register_form">
					<div class="register_form_area clearfix">
						<div class="register_form_name">
							<p>
								아이디<sup>*</sup>
							</p>
						</div>
						<div class="register_form_input">
							<input type="text" name="userId" class="normal_text" placeholder="공백없이 한글,영문,숫자만 입력 가능(한글2자, 영문4자 이상)">
							<div class="idCheck col-lg-10"></div>
						</div>
					</div>
					<div class="register_form_area clearfix">
						<div class="register_form_name">
							<p>
								비밀번호<sup>*</sup>
							</p>
						</div>
						<div class="register_form_input">
							<input type="password" name="userPassword" class="normal_text">
						</div>
					</div>
					<div class="register_form_area clearfix">
						<div class="register_form_name">
							<p>
								비밀번호확인<sup>*</sup>
							</p>
						</div>
						<div class="register_form_input">
							<input type="password" name="userPassword2" class="normal_text">
						</div>
					</div>
					<div class="register_form_area clearfix">
						<div class="register_form_name">
							<p>
								닉네임<sup>*</sup>
							</p>
						</div>
						<div class="register_form_input">
							<input type="text" name="userNick" class="normal_text"
								placeholder="">
						</div>
					</div>
					<div class="register_form_area clearfix">
						<div class="register_form_name">
							<p>
								이메일<sup>*</sup>
							</p>
						</div>
						<div class="register_form_input">
							<input type="email" name="userEmail" class="normal_text"
								placeholder="공백없이 한글,영문,숫자만 입력 가능(한글2자, 영문4자 이상)">
							<button type="button" id="sb">이메일 체크</button>
						</div>
					</div>
					<div class="register_form_area clearfix">
						<div class="register_form_name">
							<p>
								생년월일<sup>*</sup>
							</p>
						</div>
						<div class="register_form_input">
							<input type="text" name="userBirth" class="normal_text"
								placeholder="영문자, 숫자, _ 만 입력 가능. 최소 3자이상 입력하세요.">
						</div>
					</div>
					<div class="register_form_area clearfix">
						<div class="register_form_name">
							<p>
								성별<sup>*</sup>
							</p>
						</div>
						<div class="register_form_input">
							<select name="userSex" class="form-control" id="gender">
								<option value="F">여</option>
								<option value="M">남</option>
							</select>
						</div>
					</div>
					<div class="register_form_area clearfix">
						<div class="register_form_name">
							<p>
								아이콘<sup>*</sup>
							</p>
						</div>
						<div class="register_form_input">
							<input type="file" name="userIcon" class="normal_text"
								placeholder="">
						</div>
					</div>
				</div>
				<div class="register_page">
					<button type="button" onClick="history.go(-1)" class="register_page_btn">취소</button>
					<button type="submit" class="register_page_submit">다음단계</button>
				</div>
			</form>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />