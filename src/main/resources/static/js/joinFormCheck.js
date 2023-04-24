/**
 * 회원가입 유효성 검사 joinForm에서 검증 
 */

 
 
 $("#userName").blur(idDuplicateCheck);
 
 function idDuplicateCheck(){
	 
	 $.ajax({
		 type: "GET",
		 url: "./idDuplicateCheck",
		 data:{
			 userName:$('#userName').val()
		 },
		 success:function(result){
			 console.log(result)
			 if(!result){
				 console.log('사용가능한 ID');
			 }
			 else {
				 console.log("중복된 ID");
			 }
		 },
		 error:function(){
			 console.log('error')
		 }
		 
	 })
 }

$("#password2").blur(pwCheck);
function pwCheck(){
	
   if($('#password').val() != $('#password2').val()){
	    	if($('#password2').val()!=''){
				$('.passwordRe').text("비밀번호가 일치하지 않습니다.")
	    	    $('#password2').val('');
	          $('#password2').focus();
	    	}else if($('#password').val() == $('#password2').val()){
				$('.passwordRe').text("비밀번호가 일치합니다.")
		   }
			
		}
	
}
