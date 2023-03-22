

if (document.getElementById("naverIdLogin")) {
	const $naverIdLogin = document.getElementById("naverIdLogin");
	$naverIdLogin.onclick = function() {
		location.href = "/oauth2/authorization/naver";
	}
}	
if (document.getElementById("kakaoIdLogin")) {
	const $kakaoIdLogin = document.getElementById("kakaoIdLogin");
	$kakaoIdLogin.onclick = function() {
		location.href = "/oauth2/authorization/kakao";
	}

}
/* 회원 가입 */
if (document.getElementById("loginRegist")) {
	const $loginRegist = document.getElementById("loginRegist");
	$loginRegist.onclick = function() {
		location.href = "/login/regist";
	}
}

if (document.getElementById("emailId")) {
	const $emailId = document.getElementById("emailId");

	$emailId.onfocus = function() {
		if ($emailId.value == "예) greedy@Thunderbolts.com") {
			$emailId.value = "";
		}
	}
	$emailId.onblur = function() {
		if ($emailId.value == "") {
			console.log($emailId.value);
			$emailId.value = "예) greedy@Thunderbolts.com";
		}
	}

}


/* 이메일 여부 */
const $emailId = document.getElementById("emailId");
const $emailIdtxt = document.getElementById("emailIdtext");



$emailId.oninput = function() {
	var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	console.log($emailId.value);
	if (($emailId.value.match(pattern) != null)) {

		$emailIdtxt.innerHTML = "";
	} else {
		$emailIdtxt.innerHTML = "이메일 주소를 정확히 입력해주세요";
		$emailIdtxt.style.color = 'red';
	}
}

/* 비밀번호 확인 체크 (6~16글자 및 특수문자) */
if (document.getElementById("pw1")) {
	const $pw1 = document.getElementById("pw1")
	const $pw1check = document.getElementById('pw1check');


	$pw1.oninput = function() {
		var pw = $pw1.value;
		var SC = ["!", "@", "#", "$", "%"];
		var check_SC = 0;

		if (pw.length < 6 || pw.length > 16) {
			$pw1check.innerHTML = '비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.';
			$pw1check.style.color = 'red';
			pw = '';
		} else {
			$pw1check.innerHTML = '';
			for (var i = 0; i < SC.length; i++) {
				if (pw.indexOf(SC[i]) != -1) {
					check_SC = 1;
				}
			}
			if (check_SC == 0) {
				$pw1check.innerHTML = '!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.';
				$pw1check.style.color = 'red';
				pw = '';
			} else {
				$pw1check.innerHTML = '';
			}
		}

	}
}


