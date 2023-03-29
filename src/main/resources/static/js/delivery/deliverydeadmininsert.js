function deliverySave(){
	var xorqortk=document.getElementById("xorqotk").value;
	var thdwkd=document.getElementById("thdwkd").value;
	var orderNo=document.getElementById("orderNo").value;
	
		var json={};   /*객체를 만들어서  키와 벨류를 만든다. */
				json.xorqortk = xorqortk
				json.thdwkd = thdwkd
				json.orderNo=orderNo
	
	$.ajax({
				url : '/admin/deliveryinsert',//쿼리파라미터
 				method : 'post',
          		data: JSON.stringify(json),  /*json의 형태로 변환해서 바디에 담는다. 컨트롤(스프링)로 날린다.*/ 
				contentType : 'application/json; charset=UTF-8', //json 타입으로 통신하겠다. 그래서 보낼떄 이렇게 보냈고 받을때도 json (키와 벨류)으로 받는다. 
				error : xhr => console.log(xhr),
				success : responseJson => { //메소드를 받을떄 내가 다시 이름을 지을 수 있는것이고, 이것은 maplist의 객체이다. 
				
				
			        key=responseJson.suceesskey //suceesskey는 키값 
					
					if(key>=1){
						alert('저장되었습니다.')
					}else{ alert('저장이 실패하였습니다.')};
					
					
					
				}	
	});
	}		    