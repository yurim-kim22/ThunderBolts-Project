function delite(){
	var orderNo=document.getElementById("orderNo").value;
	/*var id=document.getElementById("id").value;
	var qothdwl=document.getElementById("qothdwl").value;
	var wnanstkdvna=document.getElementById("wnanstkdvna").value;
	var rnqns=document.getElementById("rnqns").value;
	var ghldnsjaud=document.getElementById("ghldnsjaud").value;
	var xorqotk=document.getElementById("xorqotk").value;
	var thdwkd=document.getElementById("thdwkd").value;*/
	
		var json={};   /*객체를 만들어서  키와 벨류를 만든다. */
				json.orderNo = orderNo
			/*	json.thdwkd = id
				json.orderNo=qothdwl
				json.orderNo=wnanstkdvna
				json.orderNo=rnqns
				json.orderNo=ghldnsjaud
				json.orderNo=xorqotk
				json.orderNo=thdwkd*/
	
	$.ajax({
				url : '/admin/deliverydelite',//쿼리파라미터
 				method : 'post',
          		data: JSON.stringify(json),  /*json의 형태로 변환해서 바디에 담는다. 컨트롤(스프링)로 날린다.*/ 
				contentType : 'application/json; charset=UTF-8', //json 타입으로 통신하겠다. 그래서 보낼떄 이렇게 보냈고 받을때도 json (키와 벨류)으로 받는다. 
				error : xhr => console.log(xhr),
				success : responseJson => { //메소드를 받을떄 내가 다시 이름을 지을 수 있는것이고, 이것은 maplist의 객체이다. 
				
				
			        key=responseJson.suceesskey //suceesskey는 키값 
					
					if(key>=1){
						alert('삭제되었습니다.')
					}else{ alert('삭제에 실패하였습니다.')};
					
					
					
				}	
	});
	}		    