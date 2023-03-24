

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

/* 회원 가입 */
if (document.getElementById("searchId")) {
	const $searchId = document.getElementById("searchId");
	$searchId.onclick = function() {
		location.href = "/login/searchId";
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
if (document.getElementById("emailId")) {
	const $emailId = document.getElementById("emailId");
	$emailId.oninput = function() {
		const $emailId = document.getElementById("emailId");
		const $emailIdtxt = document.getElementById("emailIdtext");
		const emailPattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;

		if (($emailId.value.match(emailPattern) != null)) {

			$emailIdtxt.innerHTML = "";
			

		} else {
			$emailIdtxt.innerHTML = "이메일 주소를 정확히 입력해주세요";
			$emailIdtxt.style.color = 'red';

		}
	}
}



/* 비밀번호 확인 체크 (6~16글자 및 특수문자) */
if (document.getElementById("pw1")) {

	const pwdPattern = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	const $pw1 = document.getElementById("pw1")
	const $pw1check = document.getElementById('pw1check');

	if (($pw1.value.match(pwdPattern) != null)) {

		$pw1check.innerHTML = "";


	} else {
		$pw1check.innerHTML = "영문,숫자,특수문자를 조합해서 입력해주세요(8~16자)";
		$pw1check.style.color = 'red';


	}

	$pw1.oninput = function() {
		let pw = $pw1.value;
		let SC = ["!", "@", "#", "$", "%"];
		let check_SC = 0;

		if (pw.legnth = 0) {
			$pw1check.innerHTML = '영문,숫자,특수문자를 조합해서 입력해주세요(8~16자)';
		} else {
			if (pw.length < 6 || pw.length > 16) {
				$pw1check.innerHTML = '비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.';
				$pw1check.style.color = 'red';
				pw = '';
			} else {
				$pw1check.innerHTML = '';
				for (let i = 0; i < SC.length; i++) {
					if (pw.indexOf(SC[i]) != -1) {
						check_SC = 1;
					}
				}
				if (check_SC == 0) {
					$pw1check.innerHTML = '!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.';
					$pw1check.style.color = 'red';
					pw = '';
				} else {
					if (($pw1.value.match(pwdPattern) != null)) {
						$pw1check.innerHTML = "";

					} else {
						$pw1check.innerHTML = "영문,숫자,특수문자를 조합해서 입력해주세요(8~16자)";


					}
				}
			}

		}
	}
}



/* 가입하기 버튼 활성화 */
const $loginButton = document.getElementById("loginButton");

const $emailId = document.getElementById("emailId");

const $pw1 = document.getElementById("pw1");


const $pw1check = document.getElementById('pw1check');

const emailPattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;;
const pwdPattern = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;


window.onkeydown = function() {
	
	if (
		($emailId.value.match(emailPattern) != null)
		&& ($pw1.value.match(pwdPattern) != null)
	) {
		
		$loginButton.disabled = false;
		$loginButton.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$loginButton.disabled = true;
		$loginButton.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}

window.onchange = function() {
	
		if (
		($emailId.value.match(emailPattern) != null)
		&& ($pw1.value.match(pwdPattern) != null)
	) {
		
		$loginButton.disabled = false;
		$loginButton.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$loginButton.disabled = true;
		$loginButton.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}

window.onclick = function() {
	
		if (
		($emailId.value.match(emailPattern) != null)
		&& ($pw1.value.match(pwdPattern) != null)
	) {
		
		$loginButton.disabled = false;
		$loginButton.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$loginButton.disabled = true;
		$loginButton.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}

window.oninput = function() {
	
		if (
		($emailId.value.match(emailPattern) != null)
		&& ($pw1.value.match(pwdPattern) != null)
	) {
		
		$loginButton.disabled = false;
		$loginButton.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$loginButton.disabled = true;
		$loginButton.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}
