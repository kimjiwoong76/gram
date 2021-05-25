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
                <p class="register_head_tit">약관동의<span>* 회원가입약관 및 개인정보처리방침안내의 내용에 동의하셔야 회원가입 하실 수 있습니다.</span></p>
                <ul class="register_seq">
                    <li class="on">
                        01 약관동의
                    </li>
                    <li>
                        02 정보입력
                    </li>
                    <li>
                        03 가입완료
                    </li>
                </ul>
            </div>
            <form name="signUp" action="/user/signForm" method="post">
            <input type="hidden" name="command" value="true" />
            <div class="form_inner">
                <div class="register_section">
                    <div class="register_section_head">
                        <input type="checkbox" id="register_chk1" class="disc_check" name="register_chk1">
                        <label for="register_chk1">(필수)회원가입약관</label>
                    </div>
                    <div class="register_section_area">
                        <textarea name="" id="" cols="30" rows="10" placeholder="">포트폴리오용 약관 입니다</textarea>
                    </div>
                </div>
                <div class="register_section">
                    <div class="register_section_head">
                        <input type="checkbox" id="register_chk2" class="disc_check" name="register_chk2">
                        <label for="register_chk2">(필수) 개인정보처리방침안내</label>
                    </div>
                    <div class="register_section_area">
                        <textarea name="" id="" cols="30" rows="10"></textarea>
                    </div>
                </div>
                <div class="register_section">
                    <div class="align-center">
                        <input type="checkbox" id="register_chk3" class="disc_check" name="register_chk3">
                        <label for="register_chk3">모든 약관을 확인하고 전체 동의합니다.</label>
                    </div>
                </div>
                <div class="register_page">
                    <a href="#!" class="register_page_submit" onclick="form_confirm();">다음단계</a>
                </div>
            </div>
            </form>
        </div>
    </div>

<script type="text/javascript">

	function form_confirm(){
		
	    if($('input:checkbox[name=register_chk1]').is(":checked") != true){
	    	alert("회원가입 약관에 동의해 주세요");
	    	$('#register_chk1').focus();
	    	return false;
	    }
	    
	    if($("input:checkbox[name=register_chk2]").is(":checked") != true){
	    	alert("개인정보취급방침에 동의해 주세요.");
	    	$('#register_chk2').focus();
	    	return false;
	    }

		document.signUp.submit();	    
	    
	}
	
	$("#register_chk3").click(function(){
		$(this).toggleClass("on");
		if($(this).hasClass("on")){
			$("input:checkbox").prop("checked", true);
		} else {
			$("input:checkbox").prop("checked", false);
		}
	});
	$(".disc_check").click(function(){
		if($("input:checkbox[name=register_chk1]").is(":checked") == true && $("input:checkbox[name=register_chk2]").is(":checked") == true){
    		$("input:checkbox[name=register_chk3]").prop("checked", true);
    	} 		
	});
	</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />