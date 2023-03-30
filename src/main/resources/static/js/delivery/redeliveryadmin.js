function reOrderNumber(){
	var reOrderNumber=document.getElementById("reOrderNumber").value;
	console.log(reOrderNumber);
	
	
	$.ajax({
				url : '/admin/redeliveryadmin?reOrderNumber='+reOrderNumber,//쿼리파라미터
 				method : 'GET',
//				data : json,
				contentType : 'application/json; charset=UTF-8', //json 타입으로 통신하겠다. 그래서 보낼떄 이렇게 보냈고 받을때도 json (키와 벨류)으로 받는다. 
				error : xhr => console.log(xhr),
				success : responseJson => { //메소드를 받을떄 내가 다시 이름을 지을 수 있는것이고, 이것은 remapdelist의 객체이다. 
					
					
		             console.log(responseJson);
					console.log(responseJson.mapdelistkey);
				     
				    
				    
				    
				    re=responseJson.mapdelistkey
				    
				  
				    document.getElementById("thdwkdqjsgh").value=re.deliveryNum
				    document.getElementById("ghldnjsaud").value=re.membersName
				    document.getElementById("id").value=re.membersId
				    document.getElementById("productname").value=re.productName
				    document.getElementById("productcode").value=re.productCode
				    document.getElementById("productcolor").value=re.productOptionColor
				    document.getElementById("productsize").value=re.productOptionSize
				    
				    
				    
			
			}

		}); 		
}