
$(document).ready(function() { });


if (document.getElementById('bannericon')) {
	/* 메인 베너 하다 버튼 이미지 클릭시 변경*/
	const $bannericon = document.getElementById('bannericon');

	$bannericon.addEventListener('click', e => {
		const $bannerbutton = document.getElementsByClassName('button')
		const $button = Array.from($bannerbutton);
		const $buttonli = Array.from($bannericon.children);
	
		if (e.target.matches('.bannerbutton, .button')) {
			$button.forEach(c => c.className = 'bannerbutton');
			e.target.className = 'button';
		}
		
		$buttonli.forEach((li,index)=>{
			if(e.target == li){
			$bannericon.previousElementSibling.style.backgroundImage="url(/upload/image/main/banner/mainbanner"+(index+1)+".png)";
			}
		})
		

	});
};


/* 메인 베너 2초마다 변경 */
let countNum = 0;
function bannerNext(){
	
	const $bannericon = document.getElementById('bannericon');	
	const $buttonli = Array.from($bannericon.children);
	for (let i =0 ; i < $buttonli.length; i++){
	
		if(i === countNum){
		$bannericon.previousElementSibling.style.backgroundImage="url(/upload/image/main/banner/mainbanner"+(countNum+1)+".png)";
		$buttonli[countNum].className = 'button';
		
		} else {
			
			$buttonli[i].className = 'bannerbutton';
		}
	}
		
	if(countNum < $buttonli.length){
		countNum++; 
		if(countNum === $buttonli.length ){
			countNum = 0;	
		}
	}
	
	setTimeout(bannerNext, 2000);
}
bannerNext();








/* 관심상품 클릭시 하트 이미지 변경*/
$(".eheart").on('click', function(e) {
	e.target.classList.toggle('heart')
});

/* 슬라이드 클릭시 변경 */

$('#producthot').slick({
	
infinite: true,
	slidesToShow: 5	,
	slidesToScroll: 1,
	initialSlide : 0,
	arrows:true,
    nextArrow: "<i class='nextimg'></i>",
	prevArrow: "<i class='preimg'></i>"
});

$('#productNew').slick({
	
infinite: true,
	slidesToShow: 5	,
	slidesToScroll: 1,
	initialSlide : 0,
	arrows:true,
    nextArrow: "<i class='nextimg'></i>", 
	prevArrow: "<i class='preimg'></i>"
});

$('#productSeason').slick({
	
infinite: true,
	slidesToShow: 5	,
	slidesToScroll: 1,
	initialSlide : 0,
	arrows:true,
    nextArrow: "<i class='nextimg'></i>", 
	prevArrow: "<i class='preimg'></i>" 
});

$('#style').slick({
	
infinite: true,
	slidesToShow: 5	,
	slidesToScroll: 1,
	initialSlide : 0,
	arrows:true,
    nextArrow: "<i class='styleNextimg'></i>",
	prevArrow: "<i class='stylePreimg'></i>"
});

$('#productSale').slick({
	
infinite: true,
	slidesToShow: 5	,
	slidesToScroll: 1,
	initialSlide : 0,
	arrows:true,
    nextArrow: "<i class='nextimg'></i>", 
	prevArrow: "<i class='preimg'></i>"
});



