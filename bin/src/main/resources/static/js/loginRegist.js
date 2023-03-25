
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

/* 이름 작성시 포커스 여부에 따라 예시 출력 ( 내용 기재시 초기화 하지 않음 ) */
if (document.getElementById("loginName")) {
	const $loginName = document.getElementById("loginName");
	$loginName.onfocus = function() {
		if ($loginName.value == "예) 홍길동") {
			$loginName.value = "";
		}
	}
	$loginName.onblur = function() {
		if ($loginName.value == "") {
			$loginName.value = "예) 홍길동";
		}
	}
}

/* 이름 작성시 포커스 여부에 따라 예시 출력 ( 내용 기재시 초기화 하지 않음 ) */
if (document.getElementById("pw1check")) {
	const $pw1 = document.getElementById("pw1");
	const $pw1check = document.getElementById("pw1check");
	$pw1.onfocus = function() {
		if ($pw1check.value == "영문,숫자,특수문자를 조합해서 입력해주세요(8~16자)") {
			$pw1check.value = "";
		}
	}
	$pw1.onblur = function() {
		if ($pw1check.value == "") {
			console.log($pw1check.value);
			$pw1check.value = "영문,숫자,특수문자를 조합해서 입력해주세요(8~16자)";
		}
	}
}
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
/* 이메일 여부 */
const $emailId = document.getElementById("emailId");
const $emailIdtxt = document.getElementById("emailIdtext");
const $duplicationCheck = document.getElementById("duplicationCheck");

disabled='disabled'

$emailId.oninput = function() {
	var pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	console.log($emailId.value);
	if (($emailId.value.match(pattern) != null)) {

		$emailIdtxt.innerHTML = "";
		$duplicationCheck.disabled = false;
	} else {
		$emailIdtxt.innerHTML = "이메일 주소를 정확히 입력해주세요";
		$emailIdtxt.style.color = 'red';
		$duplicationCheck.disabled = 'disabled';
	}
}

/* 비밀번호 확인 체크 (6~16글자 및 특수문자) */
if (document.getElementById("pw1")) {
	const $pw1 = document.getElementById("pw1");

	const $pw1check = document.getElementById('pw1check');



	$pw1.oninput = function() {
		var pw = $pw1.value;
		var SC = ["!", "@", "#", "$", "%"];
		var check_SC = 0;
		
		if(pw.legnth=0) {
			$pw1check.innerHTML='영문,숫자,특수문자를 조합해서 입력해주세요(8~16자)';
		}else {
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
}

/* 작성한 비밀번호 확인  */
if (document.getElementById("pw2")) {
	const $pw1 = document.getElementById("pw1");
	const $pw2 = document.getElementById("pw2");
	const $pw2check = document.getElementById('pw2check');
	$pw2.oninput = function() {
		if ($pw1.value != '' && $pw2.value != '') {
			if ($pw1.value == $pw2.value) {
				$pw2check.innerHTML = '작성하신 비밀번호와 일치합니다.'
				$pw2check.style.color = 'blue';
			}
			else {
				$pw2check.innerHTML = '작성하신 비밀번호와 일치하지 않습니다.';
				$pw2check.style.color = 'red';
			}
		}
	}

}

/* 휴대폰 번호 숫자만 입력 */
const $loginPhone = document.getElementById("loginPhone");

$loginPhone.oninput = function() {
	this.value = this.value.replace(/[^0-9.]/g, '')
		.replace(/(\..*)\./g, '$1');
}




/* Email 중복 확인 */
if (document.getElementById("duplicationCheck")) {
	const $duplication = document.getElementById("duplicationCheck");
	$duplication.onclick = function() {
		/* 유효성 검사하는것이 좋다.*/
		let memberId = document.getElementById("emailId").value;
		fetch("/login/idDupCheck", {
			method: "POST",
			headers: {
				'Content-Type': 'application/json;charset=UTF-8'
			},
			body: JSON.stringify({ membersId: memberId })
		})
			.then(result => result.text())
			.then(result => alert(result))
			.catch((error) => error.text().then((res) => alert(res)));
	}
}


















