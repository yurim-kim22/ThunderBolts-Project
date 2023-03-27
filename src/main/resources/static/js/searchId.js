
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
const $searchIdbutton = document.getElementById("searchIdbutton");


const $loginPhone = document.getElementById("loginPhone");

const phonePattern = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;




window.onkeydown = function() {
	
	if (

		 $loginPhone.value.match(phonePattern) != null
	
	) {
		
		$searchIdbutton.disabled = false;
		$searchIdbutton.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$searchIdbutton.disabled = true;
		$searchIdbutton.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}


window.onchange = function() {

	if (
		
		$loginPhone.value.match(phonePattern) != null
	
	) {
	
		$searchIdbutton.disabled = false;
		$searchIdbutton.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$searchIdbutton.disabled = true;
		$searchIdbutton.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}

window.onclick = function() {

	if (
		
		 $loginPhone.value.match(phonePattern) != null
		
	) {
		
		$searchIdbutton.disabled = false;
		$searchIdbutton.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$searchIdbutton.disabled = true;
		$searchIdbutton.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}

window.oninput = function() {
	
	if (
	
		 $loginPhone.value.match(phonePattern) != null
		
	) {
		
		$searchIdbutton.disabled = false;
		$searchIdbutton.style.backgroundColor = 'rgba(186,133,209,1)';
	} else {
		$searchIdbutton.disabled = true;
		$searchIdbutton.style.backgroundColor = 'rgba(186,133,209,0.5)';
	}
}


/* 아이디 확인 비동기통신 확인 */
if (document.getElementById("searchIdbutton")) {
	const $searchIdbutton = document.getElementById("searchIdbutton");
	$searchIdbutton.onclick = function() {
		/* 유효성 검사하는것이 좋다. */
		let MembersTel = document.getElementById("loginPhone").value;
		console.log(MembersTel);
		fetch("/login/searchId", {
			method: "POST",
			headers: {
				'Content-Type': 'application/json;charset=UTF-8'
			},
			body: JSON.stringify({ membersTel: MembersTel })
		})
		   .then(result => result.text())
			.then(result => {
			if(result=='일치하는 회원정보가 없습니다.') {
					 alert(result); 
				  } else {
				const mkEmail = result.replace(/^(.{1}).*?(@.*$)/, "$1******$2");
				
				document.getElementById("searchMain").innerHTML=
			   `<div class="searchIdMainTitle" id="searchIdMainTitle">이메일 주소 찾기에 성공하였습니다.</div>

				<div class="serchIdEmailTitle" id="serchIdEmailTitle">이메일 주소</div >
				<div class="serchIdEmail">${mkEmail}</div>
				
				<div>
				
					<input type="button" value="비밀번호 찾기"onclick="location.href='/login/searchPw'" class="searchPwbutton"
					id="searchPwbutton" >
				
					<input type="button" value="로그인" onclick="location.href='/login/main'" class="searchtologin"
					id="searchtologin" >
			
				</div>`;	
				
      			
      			}
			})
			.catch(() =>  alert("에러가 발생하였습니다. 다시 시도 해주세요"));
	}
}
