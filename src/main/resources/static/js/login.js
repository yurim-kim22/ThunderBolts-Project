
const naverLogin = new naver.LoginWithNaverId(
            {
                clientId: "YOUR_CLIENT_ID",
                callbackUrl: "YOUR_CALLBACK_URL",
                loginButton: {color: "white", type: 3, height: 40}
            }
        );
 naverLogin.init(); // 로그인 설정
 
 $("#naverLogin").on("click", function(){ 
		var btnNaverLogin = document.getElementById("naverIdLogin").firstChild;
		btnNaverLogin.click();
	});
	