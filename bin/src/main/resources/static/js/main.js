<<<<<<< HEAD
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
=======
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

/* 좌측 상단 카테고리 클릭시 진하게 및 밑줄 */
/*const $main3 = document.getElementById('headermain3');
$main3.addEventListener('click', e =>{
    const $mainboldline = document.getElementsByClassName('boldline')
    const $boldline = Array.from($mainboldline);
    if(e.target.matches('.categorymenu, .categorymenu boldline')){
        $boldline.forEach(c => c.className='categorymenu')
        e.target.className = 'categorymenu boldline';
    }
  
});*/
/* 관심상품 클릭시 하트 이미지 변경*/
$(document).ready(function(){}); 

$(".eheart").on('click', function(e){
    e.target.classList.toggle('heart')
});


/* 슬라이드 클릭시 변경 (작성중) */
$(".nextimg").on('click',function(){
    
    console.log($('#producthot'))    
    
});
>>>>>>> branch 'master' of https://github.com/yujunglove/thunderbolts.git
