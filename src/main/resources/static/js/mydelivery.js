	// 내정보 조회에서 수정으로
	const $mydel_btn = document.getElementById("mydel_btn")
	console.log($mydel_btn);
	$mydel_btn.addEventListener('click', function(){
		location.href ="/mypage/delivery";
	})