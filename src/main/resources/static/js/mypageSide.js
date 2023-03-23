	// 마이페이지
	const $mypageTit = document.getElementById("side0")
	console.log($mypageTit);
	$mypageTit.addEventListener('click', function(){
		location.href ="/mypage";
	})
	
	// 구매 내역
	const $purchaseHistory = document.getElementById("side1")
	console.log($purchaseHistory);
	$purchaseHistory.addEventListener('click', function(){
		location.href ="/";
	})
	
	// 판매 내역
	const $salesHistory = document.getElementById("side2")
	console.log($salesHistory);
	$salesHistory.addEventListener('click', function(){
		location.href ="/";
	})
	
	// 관심 상품 
	const $wishList = document.getElementById("side3")
	console.log($wishList);
	$wishList.addEventListener('click', function(){
		location.href ="/mypage/wish";
	})
	
	// 내 정보 수정
	const $editProfile = document.getElementById("side4")
	console.log($editProfile);
	$editProfile.addEventListener('click', function(){
		location.href ="/mypage/info";
	})
	
	// 내 문의 내역
	const $inquiryHistory = document.getElementById("side5")
	console.log($inquiryHistory);
	$inquiryHistory.addEventListener('click', function(){
		location.href ="/";
	})
	
	// 정산계좌
	const $settlementAccount = document.getElementById("side7")
	console.log($settlementAccount);
	$settlementAccount.addEventListener('click', function(){
		location.href ="/";
	})
	
	// 주소록
	const $addressBook = document.getElementById("side6")
	console.log($addressBook);
	$addressBook.addEventListener('click', function(){
		location.href ="/";
	})
	
	
	/*const $purchaseHistory = document.querySelector('.list-group-item[href="#!"]:nth-of-type(1)');
	$purchaseHistory.addEventListener('click', function() {
	  if ($purchaseHistory) {
	    $purchaseHistory.onclick = function() {
	      location.href = "/";
	    }
	  }
	});
	

	
	// 판매 내역
	const $salesHistory = document.querySelector('.list-group-item[href="#!"]:nth-of-type(2)');
	$salesHistory.addEventListener('click', function() {
	  if ($salesHistory) {
	    $salesHistory.onclick = function() {
	      location.href = "/";
	    }
	  }
	});
	
	// 관심 상품                                                            
	const $wishList = document.querySelector('.list-group-item[href="#!"]:nth-of-type(3)');
	console.log($wishList)
	$wishList.addEventListener('click', function() {
	  if ($wishList) {
	    $wishList.onclick = function() {
	      location.href = "/mypage/wish";
	    }
	  }
	});
	
	
	// 내 정보 수정
	const $editProfile = document.querySelector('.sidebar-heading + .list-group .list-group-item:nth-of-type(1)');
	$editProfile.addEventListener('click', function() {
	  if ($editProfile) {
	    $editProfile.onclick = function() {
	      location.href = "/";
	    }
	  }
	});
	
	// 내 문의 내역
	const $inquiryHistory = document.querySelector('.sidebar-heading + .list-group .list-group-item:nth-of-type(2)');
	$inquiryHistory.addEventListener('click', function() {
	  if ($inquiryHistory) {
	    $inquiryHistory.onclick = function() {
	      location.href = "/";
	    }
	  }
	});
	
	// 주소록
	const $addressBook = document.querySelector('.sidebar-heading + .list-group .list-group-item:nth-of-type(3)');
	$addressBook.addEventListener('click', function() {
	  if ($addressBook) {
	    $addressBook.onclick = function() {
	      location.href = "/";
	    }
	  }
	});
	
	// 정산계좌
	const $settlementAccount = document.querySelector('.sidebar-heading + .list-group .list-group-item:nth-of-type(4)');
	$settlementAccount.addEventListener('click', function() {
	  if ($settlementAccount) {
	    $settlementAccount.onclick = function() {
	      location.href = "/";
	    }
	  }
	});*/
