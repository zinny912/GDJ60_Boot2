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
			 if($('#userName').val()!=''){
			 console.log(result)
			 if(!result){
				$('.idReCheck').text("사용가능한 ID");
				$('.idReCheck').css('color', 'green');
			 }
			 else {
				 $('.idReCheck').text("중복된 ID");
				 $('.idReCheck').css('color', 'tomato');
			 }
			} 
		 },
		 error:function(){
			 console.log('error')
		 }
		 
	 })
 }

$("#passwordCheck").blur(pwCheck);
function pwCheck(){
	
   if($('#password').val() != $('#passwordCheck').val()){
	    	if($('#passwordCheck').val()!=''){
	    	    $('#passwordCheck').val('');
				$('.pwReCheck').text("비밀번호가 일치하지 않습니다.");
				$('.pwReCheck').css('color','tomato');
	          $('#passwordCheck').focus();
	    	}else if($('#password').val() == $('#passwordCheck').val()){
				$('.pwReCheck').text("비밀번호가 일치합니다.")
				$('.pwReCheck').css('color','green');
		   }
			
		}
	
}
