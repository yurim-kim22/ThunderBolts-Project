window.onload = function() {

	if(document.getElementById("home")) {
        const $login = document.getElementById("home");
        $login.onclick = function() {
            location.href = "/";
        }
    }

	if(document.getElementById("login")) {
        const $login = document.getElementById("login");
        $login.onclick = function() {
            location.href = "/login/main";
        }
    }
}