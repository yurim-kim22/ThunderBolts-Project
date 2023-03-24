	// 프로필 수정 버튼
	const $mypageInfo= document.getElementById("info_btn")
	console.log($mypageInfo);
	$mypageInfo.addEventListener('click', function(){
		location.href ="/mypage/info";
	})