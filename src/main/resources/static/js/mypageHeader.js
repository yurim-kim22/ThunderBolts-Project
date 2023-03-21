window.onload = function() {

	if(document.getElementById("home")) {
        const $home = document.getElementById("home");
        $home.onclick = function() {
            location.href = "/";
        }
    }

	if(document.getElementById("login")) {
        const $login = document.getElementById("login");
        $login.onclick = function() {
            location.href = "/login/main";
        }
    }

   if(document.getElementById("mypage")) {
        const $mypage = document.getElementById("mypage");
        $mypage.onclick = function() {
            location.href = "/mypage";
        }
    }
    

	if(document.getElementById("header_img")) {
        const $header_img = document.getElementById("header_img");
        $header_img.onclick = function() {
            location.href = "/";
        }
    }
	
	if(document.getElementById("heartProduct")) {
        const $heartProduct = document.getElementById("heartProduct");
        $heartProduct.onclick = function() {
            location.href = "/mypage/wish";
        }
    }
}