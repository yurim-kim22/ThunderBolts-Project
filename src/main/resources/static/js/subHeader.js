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
            location.href = "/login/Main";
        }
    }
    
        if(document.getElementById("logout")) {
        const $logout = document.getElementById("logout");
        $logout.onclick = function() {
            location.href = "/login/logout";
        }
    }

   if(document.getElementById("mypage")) {
        const $mypage = document.getElementById("mypage");
        $mypage.onclick = function() {
            location.href = "/mypage";
        }
    }
    
    if(document.getElementById("heartProduct")) {
        const $heartProduct = document.getElementById("heartProduct");
        $heartProduct.onclick = function() {
            location.href = "/mypage/wish";
        }
    }

}