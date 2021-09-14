
	function formComfirm(v){
		var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
		var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;  // 이메일이 적합한지 검사할 정규식
		let $_form = v;

		if($_form.userId.value.length > 3){
			$.ajax({
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				url: "/user/userSelect",
				type: "GET",
				data: {userId : $_form.userId.value},
				success: function(data){
					if(data){
						alert("사용할 수 없는 아이디 입니다.");
						return false;
					}
				},
				error: function(data){
					alert("에러 입니다.");
				}
			});
		}

		function check(re, what, message) {
			console.log(re);
			console.log(what);
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
		
		if(!check(re, $_form.userId, "아이디는 4~12자의 영문 대소문자와 숫자로만 가능합니다")) {
			$_form.userId.focus();
			return false;
		}
		
		if($_form.userPassword.value == ""){
			alert("비밀번호를 입력해 주세요.");
			$_form.userPassword.focus();
			return false;
		}
		if($_form.userPassword2.value == ""){
			alert("비밀번호확인을 입력해 주세요.");
			$_form.userPassword2.focus();
			return false;
		}
		
		if($_form.userPassword.value != $_form.userPassword2.value) {
			alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
			$_form.userPassword2.focus();
			return false;
		}
		if($_form.userNick.value=="") {
			alert("닉네임을 입력해 주세요");
			$_form.userNick.focus();
			return false;
		}
		if($_form.userEmail.value=="") {
			alert("이메일을 입력해 주세요");
			$_form.userEmail.focus();
			return false;
		}
		if(!check(re2, $_form.userEmail, "적합하지 않은 이메일 형식입니다.")) {
			return false;
		}
		
		$_form.submit();

	}

	$(function(){
		$("#sb").on("click", function(){
			let test = $("input[name=userEmail]").val();
			console.log(test);
		});
	});
