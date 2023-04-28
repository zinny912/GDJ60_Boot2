<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="../temp/style.jsp"></c:import>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

 <style type="text/css">
		.redResult{
			color: red;
		}
		.blueResult{
			color: blue;
		}
			
	a {	
	color: #2c396b;
  	text-decoration: none;
  	background-color: transparent; }
		
		a:hover{
		color:#6c757d;
		text-decoration: none;
		cursor:pointer;
		}
		
		a:not([href]):not([tabindex]) {
  color: inherit;
  text-decoration: none; }
  a:not([href]):not([tabindex]):hover, a:not([href]):not([tabindex]):focus {
    color: inherit;
    text-decoration: none; }
  a:not([href]):not([tabindex]):focus {
    outline: 0; }

 a .footer-text{
  font-family: "Gowun Dodum",  sans-serif;
  font-weight: 100;
  font-size: 5px;
}  

</style>
</head>

   <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
          <!-- Navigation-->
  		   <c:import url="../temp/header.jsp"></c:import>
<form class="col-6 mx-auto my-5 justify-content-center" id="passwordForm" action="./findPassword" method="post">
<h3 class="col-6 text-center mx-auto" style="padding-bottom:10%;">비밀번호 찾기</h3>
 
  <div class="d-flex flex-row align-items-center mx-auto mb-4 col-6">
    <div class="form-outline flex-fill mb-0">
   
      <input type="text"  id="username" name="username" Class="form-control" placeholder="아이디"/>
           <label class="form-label" id="idLabel" for="username"></label>
      <input type="email" id="email" name="email" class="form-control" placeholder="이메일"/>
      <label class="form-label" for="email" id="passwordLabel"></label>
      
    </div>
  </div>
		  <div class="d-flex flex-row align-items-center mb-4">
		<button class="btn btn-danger col-6 mx-auto" type="submit">비밀번호 찾기</button>
</div>
</form>

 </main>           
<!-- footer 적용해야함 --> 
<c:import url ="../temp/footer.jsp"></c:import>
<!-- footer 적용 끝 -->
</body>
</html>