/* 검수 기준 */
if (document.getElementById("modalBtn1") && document.getElementById("modal1")) {
	
	const modalBtn1 = document.getElementById("modalBtn1");
	const modal1 = document.getElementById("modal1");

	modalBtn1.addEventListener('click',function(){
		modal1.style.display = "block";
	});
	
	window.addEventListener('click',function(event){
		if(event.target === modal1) {
			event.target.style.display = "none";
		}
	})


}

/* 이용 정책 */
if (document.getElementById("modalBtn2") && document.getElementById("modal2")) {
	
	const modalBtn2 = document.getElementById("modalBtn2");
	const modal2 = document.getElementById("modal2");
	
	modalBtn2.addEventListener('click',function(){
		modal2.style.display = "block";
	});
	
	window.addEventListener('click',function(event){
		if(event.target === modal2) {
			event.target.style.display = "none";
		}
	})

}
/* 개인정보 수집 동의 */
if (document.getElementById("modalBtn3") && document.getElementById("modal3")) {
	
	const modalBtn3 = document.getElementById("modalBtn3");
	const modal3 = document.getElementById("modal3");
	
	modalBtn3.addEventListener('click',function(){
		modal3.style.display = "block";
	});
	
	window.addEventListener('click',function(event){
		if(event.target === modal3) {
			event.target.style.display = "none";
		}
	})
}
/* 패널티 정책 */
if (document.getElementById("modalBtn4") && document.getElementById("modal4")) {
	
	const modalBtn4 = document.getElementById("modalBtn4");
	const modal4 = document.getElementById("modal4");
	
	modalBtn4.addEventListener('click',function(){
		modal4.style.display = "block";
	});
	
	window.addEventListener('click',function(event){
		if(event.target === modal4) {
			event.target.style.display = "none";
		}
	})
}	
/* 이용 약관 */
if (document.getElementById("modalBtn5") && document.getElementById("modal5")) {

	const modalBtn5 = document.getElementById("modalBtn5");
	const modal5 = document.getElementById("modal5");
	
	modalBtn5.addEventListener('click',function(){
		modal5.style.display = "block";
	});
	
	window.addEventListener('click',function(event){
		if(event.target === modal5) {
			event.target.style.display = "none";
		}
	})
}
/* 커뮤니티 가이드 */
if (document.getElementById("modalBtn6") && document.getElementById("modal6")) {

	const modalBtn6 = document.getElementById("modalBtn6");
	const modal6 = document.getElementById("modal6");
	
	modalBtn6.addEventListener('click',function(){
		modal6.style.display = "block";
	});
	
	window.addEventListener('click',function(event){
		if(event.target === modal6) {
			event.target.style.display = "none";
		}
	})
}
/*  커뮤니티 가이드(이용 약관) */
if (document.getElementById("modalBtn5c") && document.getElementById("modal5")) {

	const modalBtn5 = document.getElementById("modalBtn5c");
	const modal5 = document.getElementById("modal5");
	const modal6 = document.getElementById("modal6");
	
	modalBtn5.addEventListener('click',function(){
		modal5.style.display = "block";
		modal6.style.display = "none";
		
	});
	
	window.addEventListener('click',function(event){
		if(event.target === modal5) {
			event.target.style.display = "none";
		}
	})
}


const closeBtns = document.getElementsByClassName("close");
const accordions = document.getElementsByClassName("accordion");



for (let closeBtn of closeBtns) {
	closeBtn.onclick = (event) => {
		event.target.parentElement.parentElement.style.display = "none";
	};
}
for (let accordion of accordions) {
	accordion.onclick = () => {
		const otherAccordions = Array.from(accordions).filter(acc => acc !== accordion);
		otherAccordions.forEach(otherAcc => {
			otherAcc.classList.remove("active");
			otherAcc.nextElementSibling.style.display = "none";
		});

		accordion.classList.toggle("active");
		const panel = accordion.nextElementSibling;
		if (panel.style.display === "block") {
			panel.style.display = "none";
		} else {
			panel.style.display = "block";
		}
	};
}


let currentContentId = null;

function toggleContent(contentId) {
	let content = document.getElementById(contentId);
	if (contentId === currentContentId) {
		content.style.display = 'none';
		currentContentId = null;
	} else {
		if (currentContentId) {
			let currentContent = document.getElementById(currentContentId);
			currentContent.style.display = 'none';
		}
		content.style.display = 'block';
		currentContentId = contentId;
	}
}

