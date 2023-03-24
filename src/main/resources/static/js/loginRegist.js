
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

/* 작성한 비밀번호 확인  */
if (document.getElementById("pw2")) {
	const $pw1 = document.getElementById("pw1");
	const $pw2 = document.getElementById("pw2");
	const $pw2check = document.getElementById('pw2check');
$pw2.oninput = function() {
	let pw = $pw2.value;
	let SC = ["!", "@", "#", "$", "%"];
	let check_SC = 0;

	if (pw.legnth = 0) {
		$pw2check.innerHTML = '영문,숫자,특수문자를 조합해서 입력해주세요(8~16자)';
	} else {
		if (pw.length < 6 || pw.length > 16) {
			$pw2check.innerHTML = '비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.';
			$pw2check.style.color = 'red';
			pw = '';
		} else {
			$pw2check.innerHTML = '';
			for (let i = 0; i < SC.length; i++) {
				if (pw.indexOf(SC[i]) != -1) {
					check_SC = 1;
				}
			}
			if (check_SC == 0) {
				$pw2check.innerHTML = '!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.';
				$pw2check.style.color = 'red';
				pw = '';
			} else {
				if (($pw2.value.match(pwdPattern) != null)) {
					$pw2check.innerHTML = "";

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

				} else {
					$pw2check.innerHTML = "영문,숫자,특수문자를 조합해서 입력해주세요(8~16자)";


				}
			}
		}

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



let duplicationNum;
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
			.then(result => {
				
				if (result == "사용 가능한 아이디입니다.") {
					dupliNum();
				} else { dulimNum(); }
				return alert(result);
			})
			.catch((error) => error.text().then((res) => alert(res)));

	}
}

function dupliNum() {
	duplicationNum = '1';
	

}
function dulimNum() {
	duplicationNum = '0';
	

}

/* 가입하기 버튼 활성화 */
const $registJoin = document.getElementById("registJoin");

const $loginName = document.getElementById("loginName");
const $emailId = document.getElementById("emailId");
const $duplicationCheck = document.getElementById("duplicationCheck");
const $pw1 = document.getElementById("pw1");

const $pw2 = document.getElementById("pw2");

const $loginPhone = document.getElementById("loginPhone");
const $consentCheckboxTitleEs = document.getElementById("consentCheckboxTitleEs")

const $pw1check = document.getElementById('pw1check');
const $pw2check = document.getElementById('pw2check');
const emailPattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;;
const phonePattern = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
const pwdPattern = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;


window.onkeydown = function() {
	
	if (
		($loginName.value != "예) 홍길동")
		&& ($loginName.value.trim() != null)
		&& ($emailId.value.match(emailPattern) != null)
		&& duplicationNum == '1'
		&& ($pw1.value.match(pwdPattern) != null)
		&& ($pw2.value.match(pwdPattern) != null)
		&& $pw1.value == $pw2.value
		&& $pw1.value != '' && $pw2.value != ''
		&& $loginPhone.value.match(phonePattern) != null
		&& $consentCheckboxTitleEs.checked
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
		($loginName.value != "예) 홍길동")
		&& ($loginName.value.trim() != null)
		&& ($emailId.value.match(emailPattern) != null)
		&& duplicationNum == '1'
		&& ($pw1.value.match(pwdPattern) != null)
		&& ($pw2.value.match(pwdPattern) != null)
		&& $pw1.value == $pw2.value
		&& $pw1.value != '' && $pw2.value != ''
		&& $loginPhone.value.match(phonePattern) != null
		&& $consentCheckboxTitleEs.checked
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
		($loginName.value != "예) 홍길동")
		&& ($loginName.value.trim() != null)
		&& ($emailId.value.match(emailPattern) != null)
		&& duplicationNum == '1'
		&& ($pw1.value.match(pwdPattern) != null)
		&& ($pw2.value.match(pwdPattern) != null)
		&& $pw1.value == $pw2.value
		&& $pw1.value != '' && $pw2.value != ''
		&& $loginPhone.value.match(phonePattern) != null
		&& $consentCheckboxTitleEs.checked
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
		($loginName.value != "예) 홍길동")
		&& ($loginName.value.trim() != null)
		&& ($emailId.value.match(emailPattern) != null)
		&& duplicationNum == '1'
		&& ($pw1.value.match(pwdPattern) != null)
		&& ($pw2.value.match(pwdPattern) != null)
		&& $pw1.value == $pw2.value
		&& $pw1.value != '' && $pw2.value != ''
		&& $loginPhone.value.match(phonePattern) != null
		&& $consentCheckboxTitleEs.checked
	) {
		
		$registJoin.disabled = false;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$registJoin.disabled = true;
		$registJoin.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}





/* 상위 동의하기 체크시 전체 체크 */

if (document.getElementById("consentCheckboxTitleEs")) {
	
	$('#consentCheckboxTitleEs').click(function(){
		if($('#consentCheckboxTitleEs').is(':checked')){
			$('#consentCheckboxSubTitleEs1').prop('checked',true);
			$('#consentCheckboxSubTitleEs2').prop('checked',true);
			} else{
				$('#consentCheckboxSubTitleEs1').prop('checked',false);
				$('#consentCheckboxSubTitleEs2').prop('checked',false);
			}
		})
	
	}

if (document.getElementById("consentCheckboxTitleCh")) {
	
	$('#consentCheckboxTitleCh').click(function(){
		if($('#consentCheckboxTitleCh').is(':checked')){
			$('#consentCheckboxSubTitleCh1').prop('checked',true);
			$('#consentCheckboxSubTitleCh2').prop('checked',true);
			} else{
				$('#consentCheckboxSubTitleCh1').prop('checked',false);
				$('#consentCheckboxSubTitleCh2').prop('checked',false);
			}
		})
	
	}	
		
		
