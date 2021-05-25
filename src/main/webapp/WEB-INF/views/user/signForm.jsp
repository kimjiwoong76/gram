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
				method="post" action="/user/signFormAction" name="userSign">
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
							<div class="idCheck col-lg-10"></div>
						</div>
						<script>
								$(function(){
									var form = $(".form-horizontal");
									$("input[name=shop_id]").on("keydown, keyup", function(){
										var input = {shop_id : $("input[name=shop_id]").val()};
										if($("input[name=shop_id]").val().length > 0){
											$.ajax({
											 	contentType: "application/x-www-form-urlencoded; charset=UTF-8",
											    url: "/userSelect.do",
											    type: "POST",
											    data: input,
											    success: function(data){
											          $(".idCheck").html("<p>"+data+"</p>");
											          
											    },
											    error: function(data){
											    	alert("에러 입니다.");
											    }
											  });
										}
										
									});
								});
							</script>
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
							<input type="file" name="userEmail" class="normal_text"
								placeholder="">
						</div>
					</div>
				</div>
				<div class="register_page">
					<a href="#!" class="register_page_btn">취소</a>
					<button type="submit" onclick="return form_confirm();"
						class="register_page_submit">다음단계</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
function form_confirm(){
	
	var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
    var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;  // 이메일이 적합한지 검사할 정규식
	
    function check(re, what, message) {
        if(re.test(what.value)) {
            return true;
        }
        alert(message);
        what.value = "";
        what.focus();
        //return false;
    }
    
    /* if(shopMember.provisionYn.value == "n"){
    	alert("회원가입 약관에 동의해 주세요");
    	shopMember.provisionYn.focus();
    	return false;
    }
    
    if(shopMember.memberInfoYn.value == "n"){
    	alert("개인정보취급방침에 동의해 주세요.");
    	shopmember.memberInfoYn.focus();
    	return false;
    } */
    
	if(!check(re,shopMember.shop_id, "아이디는 4~12자의 영문 대소문자와 숫자로만 가능합니다")) {
        shopMember.shop_id.focus();
        return false;
    }
	
    if(shopMember.shop_pwd.value == ""){
    	alert("비밀번호를 입력해 주세요.");
    	shopMember.shop_id.focus();
    	return false;
    }
    if(shopMember.shop_pwd2.value == ""){
    	alert("비밀번호확인을 입력해 주세요.");
    	shopMember.shop_id.focus();
    	return false;
    }
    
    if(shopMember.shop_pwd.value != shopMember.shop_pwd2.value) {
        alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
        shopMember.shop_pwd.value = "";
        shopMember.shop_pwd.focus();
        return false;
    }
    if(shopMember.shop_name.value=="") {
        alert("이름을 입력해 주세요");
        shopMember.shop_name.focus();
        return false;
    }
    if(shopMember.shop_nickname.value=="") {
        alert("별명을 입력해 주세요");
        shopMember.shop_nickname.focus();
        return false;
    }
    if(shopMember.shop_email.value=="") {
        alert("이메일을 입력해 주세요");
        shopMember.shop_email.focus();
        return false;
    }
    if(shopMember.shop_number.value=="") {
        alert("핸드폰 번호를 입력해주세요");
        shopMember.shop_number.focus();
        return false;
    }
    if(!check(re2, shopMember.shop_email, "적합하지 않은 이메일 형식입니다.")) {
        return false;
    }
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />