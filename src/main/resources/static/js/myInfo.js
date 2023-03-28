	// 내정보 조회에서 수정으로
	const $info_btn = document.getElementById("info_btn")
	console.log($info_btn);
	$info_btn.addEventListener('click', function(){
		location.href ="/mypage/modify";
	})