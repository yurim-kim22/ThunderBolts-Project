function orderNumber(){
	var orderNo=document.getElementById("orderNo").value;
	console.log(orderNo);
	
	
	$.ajax({
				url : '/admin/deliverydeadmin?orderNo='+orderNo,//쿼리파라미터
 				method : 'GET',
//				data : json,
				contentType : 'application/json; charset=UTF-8', //json 타입으로 통신하겠다. 그래서 보낼떄 이렇게 보냈고 받을때도 json (키와 벨류)으로 받는다. 
				error : xhr => console.log(xhr),
				success : responseJson => { //메소드를 받을떄 내가 다시 이름을 지을 수 있는것이고, 이것은 maplist의 객체이다. 
					
					
					console.log(responseJson);
					console.log(responseJson.mapdelistkey);
				    console.log(document.getElementById("deliveryde"));//deliver.html에 있는 저 id의 태그들을 가져온다. 
				    
				    
				    
				    
				    
				    re=responseJson.mapdelistkey
				    
				  
				    document.getElementById("id").value=re.membersId
				    document.getElementById("qothdwl").value=re.postAddmin
				    document.getElementById("wnanstkdvna").value=re.productName
				    document.getElementById("rnqns").value=re.checkingResult
				    document.getElementById("ghldnsjaud").value=re.membersName
				    document.getElementById("xorqotk").value=re.deliveryCompany
				    document.getElementById("thdwkd").value=re.deliveryNum
				    
				    
				    
			
			}

		}); 		
}