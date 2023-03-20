
 if(document.getElementById("emailId")) {
        const $emailId = document.getElementById("emailId");
        $emailId.onfocus = function() {
           $emailId.value="";
        }
        $emailId.onblur = function() {
           $emailId.value="예) greedy@Thunderbolts.com";
        }
    } 
    
  if(document.getElementById("loginName")) {
        const $emailId = document.getElementById("loginName");
        $emailId.onfocus = function() {
           $emailId.value="";
        }
        $emailId.onblur = function() {
           $emailId.value="예) 홍길동";
        }
    }     
    
  if(document.getElementById("loginPhone")) {
        const $emailId = document.getElementById("loginPhone");
        $emailId.onfocus = function() {
           $emailId.value="";
        }
        $emailId.onblur = function() {
           $emailId.value="예) 휴대폰 번호는 숫자만 입력하세요";
        }
    } 
    
   if(document.getElementById("pw2")) {
        const $pw1 = document.getElementById("pw1");
        const $pw2 = document.getElementById("pw2");
        const $pw1check = document.getElementById('pw1check');
        const $pw2check = document.getElementById('pw2check');
        
        
        $pw1.oninput=function() {
            var pw = $pw1.value;
            var SC = ["!","@","#","$","%"];
            var check_SC = 0;
 
            if(pw.length < 6 || pw.length>16){
                $pw1check.innerHTML='비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.';
                $pw1check.style.color='red';
                pw='';
            } else {
				$pw1check.innerHTML='';
				for(var i=0;i<SC.length;i++){
                if(pw.indexOf(SC[i]) != -1){
                    check_SC = 1;
                }
            }
            if(check_SC == 0){
                $pw1check.innerHTML='!,@,#,$,% 의 특수문자가 들어가 있지 않습니다.';
                $pw1check.style.color='red';
                pw='';
            } else {
				$pw1check.innerHTML='';
			}
			}
            
        }
        
        $pw2.oninput = function(){
			    if($pw1.value !='' && $pw2.value!=''){
                if($pw1.value==$pw2.value){
                    $pw2check.innerHTML='작성하신 비밀번호와 일치합니다.'
                    $pw2check.style.color='blue';
                }
                else{
                    $pw2check.innerHTML='작성하신 비밀번호와 일치하지 않습니다.';
                    $pw2check.style.color='red';
                }
            }
		}
    
    } 
   