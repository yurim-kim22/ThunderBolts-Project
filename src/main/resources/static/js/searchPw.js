
/* 핸드폰 번호 입력시 포커스 여부에 따라 예시 출력 ( 내용 기재시 초기화 하지 않음 ) */
if (document.getElementById("loginPhone")) {
	const $loginPhone = document.getElementById("loginPhone");
	$loginPhone.onfocus = function() {
		if ($loginPhone.value == "휴대폰 번호는 숫자만 입력하세요") {
			$loginPhone.value = "";
		}
	}
	$loginPhone.onblur = function() {
		if ($loginPhone.value == "") {
			$loginPhone.value = "휴대폰 번호는 숫자만 입력하세요";
		}
	}
}
/* 이메일 작성시 포커스 여부에 따라 예시 출력 ( 내용 기재시 초기화 하지 않음 ) */
if (document.getElementById("emailId")) {
	const $emailId = document.getElementById("emailId");

	$emailId.onfocus = function() {
		if ($emailId.value == "예) greedy@Thunderbolts.com") {
			$emailId.value = "";
		}
	}
	$emailId.onblur = function() {
		if ($emailId.value == "") {
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
		const $duplicationCheck = document.getElementById("duplicationCheck");
		const emailPattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;

		if (($emailId.value.match(emailPattern) != null)) {

			$emailIdtxt.innerHTML = "";
			$duplicationCheck.disabled = false;


		} else {
			$emailIdtxt.innerHTML = "이메일 주소를 정확히 입력해주세요";
			$emailIdtxt.style.color = 'red';
			$duplicationCheck.disabled = 'disabled';

		}
	}
}


/* 휴대폰 번호 숫자만 입력 */
if (document.getElementById("loginPhone")) {

	const $loginPhone = document.getElementById("loginPhone");

	$loginPhone.oninput = function() {
		this.value = this.value.replace(/[^0-9.]/g, '')
			.replace(/(\..*)\./g, '$1');
	}

}

/* 휴대폰 번호 유효성 검사 */
if (document.getElementById("loginPhone")) {
	const phonePattern = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	const $loginPhone = document.getElementById("loginPhone");
	const $phonecheck = document.getElementById("phonecheck");

	$loginPhone.addEventListener('input', function() { })

	$loginPhone.addEventListener('input', function() {
		if (($loginPhone.value.match(phonePattern) != null)) {

			$phonecheck.innerHTML = "";



		} else {
			$phonecheck.innerHTML = "휴대폰번호를 정확히 입력해주세요";
			$phonecheck.style.color = 'red';

		}
	});

}




/* 가입하기 버튼 활성화 */
const $registJoin = document.getElementById("registJoin");


const $loginPhone = document.getElementById("loginPhone");

const phonePattern = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;



window.onkeydown = function() {
	
	if (

		 $loginPhone.value.match(phonePattern) != null
	
	) {
		
		$registJoin.disabled = false;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$registJoin.disabled = true;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}

window.onchange = function() {
	
	if (
		($emailId.value.match(emailPattern) != null)
		&& $loginPhone.value.match(phonePattern) != null
	
	) {
	
		$registJoin.disabled = false;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$registJoin.disabled = true;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}

window.onclick = function() {
	
	if (
		
		($emailId.value.match(emailPattern) != null)
		&& $loginPhone.value.match(phonePattern) != null
		
	) {
		
		$registJoin.disabled = false;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$registJoin.disabled = true;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}

window.oninput = function() {
	
	if (
	
		($emailId.value.match(emailPattern) != null)
		&& $loginPhone.value.match(phonePattern) != null
		
	) {
		
		$registJoin.disabled = false;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$registJoin.disabled = true;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}






