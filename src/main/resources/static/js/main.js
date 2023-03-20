window.onload = function() {
/* 메인 베너 하다 버튼 이미지 클릭시 변경*/
const $bannericon = document.getElementById('bannericon');
$bannericon.addEventListener('click', e =>{
    const $bannerbutton = document.getElementsByClassName('button')
    const $button = Array.from($bannerbutton);
        if(e.target.matches('.bannerbutton button, .button button')){
        $button.forEach(c => c.className='bannerbutton');
        e.target.parentElement.className = 'button';
    }
  
});

/* 관심상품 클릭시 하트 이미지 변경*/
$(document).ready(function(){}); 

$(".eheart").on('click', function(e){
    e.target.classList.toggle('heart')
});

/* 슬라이드 클릭시 변경 (작성중) */
$(".nextimg").on('click',function(){
    
    console.log($('#producthot'))    
    
});
}