	// 프로필 수정 버튼
	const $mypageInfo= document.getElementById("info_btn")
	console.log($mypageInfo);
	$mypageInfo.addEventListener('click', function(){
		location.href ="/mypage/info";
	})
	
		//구매 상세내역
	const $myBuy= document.getElementById("side_myBuy")
	console.log($myBuy);
	$myBuy.addEventListener('click', function(){
		location.href ="/mypage/mybuy";
	})
	//판매 상세 내역
	const $mySell= document.getElementById("side_mySell")
	console.log($mySell);
	$mySell.addEventListener('click', function(){
		location.href ="/mypage/mysell";
	})