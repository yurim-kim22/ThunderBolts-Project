
$(document).ready(function(){}); 

if($(".eheart") != null){
$(".eheart").on('click', function(e){
    e.target.classList.toggle('heart')
});

}

if ($(".downImg") != null) {
	$(".downImg").on('click', function(e) {
		e.target.classList.toggle('upImg');
		if (e.target.parentElement.className == "deliveryNoticeTitle") {
			if ($(".deliveryNoticeContent").css("display") == "none") {
				$(".deliveryNoticeTitle").css({"font-weight": "600", "border-bottom": "2px solid black"});
				$(".deliveryNoticeContent").css("display", "block");
			} else {
				$(".deliveryNoticeTitle").css({"font-weight": "500", "border-bottom": "1px solid gray"});
				$(".deliveryNoticeContent").css("display", "none");
			}
		}
		
		if (e.target.parentElement.className == "checkNoticeTitle") {
			if ($(".checkNoticeContent").css("display") == "none") {
				$(".checkNoticeTitle").css({"font-weight": "600", "border-bottom": "2px solid black"});
				$(".checkNoticeContent").css("display", "block");
			} else {
				$(".checkNoticeTitle").css({"font-weight": "500", "border-bottom": "1px solid gray"});
				$(".checkNoticeContent").css("display", "none");
			}
		}
		
		if (e.target.parentElement.className == "buyNoticeTitle") {
			if ($(".buyNoticeContent").css("display") == "none") {
				$(".buyNoticeTitle").css({"font-weight": "600", "border-bottom": "2px solid black"});
				$(".buyNoticeContent").css("display", "block");
			} else {
				$(".buyNoticeTitle").css({"font-weight": "500", "border-bottom": "1px solid gray"});
				$(".buyNoticeContent").css("display", "none");
			}
		}
		
	});

}