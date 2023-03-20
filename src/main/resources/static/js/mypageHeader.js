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
    

}