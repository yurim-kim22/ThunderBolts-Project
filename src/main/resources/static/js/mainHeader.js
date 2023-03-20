window.onload = function() {
/* 좌측 상단 카테고리 클릭시 진하게 및 밑줄 */
const $main3 = document.getElementById('headermain3');
$main3.addEventListener('click', e =>{
    const $mainboldline = document.getElementsByClassName('boldline')
    const $boldline = Array.from($mainboldline);
    if(e.target.matches('.categorymenu, .categorymenu boldline')){
        $boldline.forEach(c => c.className='categorymenu')
        e.target.className = 'categorymenu boldline';
    }
  
});
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
    
    if(document.getElementById("mypage")) {
        const $login = document.getElementById("mypage");
        $login.onclick = function() {
            location.href = "/mypage/main";
        }
    }
    

}