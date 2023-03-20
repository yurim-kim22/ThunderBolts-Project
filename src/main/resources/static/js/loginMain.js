const naverLogin = new naver.LoginWithNaverId(
	{
		clientId: "YOUR_CLIENT_ID",
		callbackUrl: "YOUR_CALLBACK_URL",
		loginButton: { color: "white", type: 3, height: 40 }
	}
);
naverLogin.init(); // 로그인 설정

/* (4) Callback의 처리. 정상적으로 Callback 처리가 완료될 경우 main page로 redirect(또는 Popup close) */
window.addEventListener('load', function() {
	naverLogin.getLoginStatus(function(status) {
		if (status) {
			/* (5) 필수적으로 받아야하는 프로필 정보가 있다면 callback처리 시점에 체크 */
			var email = naverLogin.user.getEmail();
			console.log(email); // 사용자 이메일 정보를 받을수 있습니다.
			console.log(naverLogin.user); //사용자 정보를 받을수 있습니다.
			if (email == undefined || email == null) {
				alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
				/* (5-1) 사용자 정보 재동의를 위하여 다시 네아로 동의페이지로 이동함 */
				naverLogin.reprompt();
				return;
			}

			window.location.replace("http://" + window.location.hostname + ((location.port == "" || location.port == undefined) ? "" : ":" + location.port) + "/sample/main.html");
		} else {
			console.log("callback 처리에 실패하였습니다.");
		}
	});
});
var testPopUp;
function openPopUp() {
	testPopUp = window.open("https://nid.naver.com/nidlogin.logout", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,width=1,height=1");
}
function closePopUp() {
	testPopUp.close();
}

function naverLogout() {
	openPopUp();
	setTimeout(function() {
		closePopUp();
	}, 1000);


}
$("#naverLogin").on("click", function() {
	var btnNaverLogin = document.getElementById("naverIdLogin").firstChild;
	btnNaverLogin.click();
});


//카카오 로그인
$("#kakaoLogin").on("click", function() {
	Kakao.init('8890a67c089173194979845f9389950d'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단


	//카카오로그인
	function kakaoLogin() {
		Kakao.Auth.login({
			success: function(response) {
				Kakao.API.request({
					url: '/v2/user/me',
					success: function(response) {
						console.log(response)
					},
					fail: function(error) {
						console.log(error)
					},
				})
			},
			fail: function(error) {
				console.log(error)
			},
		})
	}
	//카카오로그아웃  
	function kakaoLogout() {
		if (Kakao.Auth.getAccessToken()) {
			Kakao.API.request({
				url: '/v1/user/unlink',
				success: function(response) {
					console.log(response)
				},
				fail: function(error) {
					console.log(error)
				},
			})
			Kakao.Auth.setAccessToken(undefined)
		}
	}
})


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


