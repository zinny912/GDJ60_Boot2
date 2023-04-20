<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<html>
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business - Start Bootstrap Template</title>
       <!-- css & favicon  -->
       <c:import url="../temp/style.jsp"></c:import>
       <!-- css & favicon  -->

 <style type="text/css">
		.redResult{
			color: red;
		}
		.blueResult{
			color: blue;
		}
		.btnKakao{display:inline-block!important;margin-top:25px;padding-left:20px;width:100%;height:45px;line-height:45px;background-color:#fee500;background-image:url('/resources/images/kakao_btn.svg');background-repeat:no-repeat;background-size:15px;background-position:15px;border-radius:6px;font-size:15px;color:#111;box-sizing:border-box}
		
		
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
            <!-- Header-->



<div class="container-fluid">
<div class="row d-flex justify-content-center">
<div class="col-6" style="margin-top: 5%;">

<form class="col-6 mx-auto my-5 justify-content-center" id="loginForm" action="./login" method="post">
<a href="/"><h4>스타트 스프링부트</h4></a>
<br><h3 class="col-6 text-center mx-auto" style="padding-bottom:10%;">로그인</h3>
  <div class="d-flex flex-row align-items-center mb-4">
    <div class="form-outline flex-fill mb-0">
      <input type="text" id="userName" name="userName" class="form-control" placeholder="아이디"/>
           <label class="form-label" id="idLabel" for="id"></label>
      <input type="password" id="password" name="password" class="form-control" placeholder="비밀번호"/>
      <label class="form-label" for="Password" id="passwordLabel"></label>
    </div>
  </div>

  <div class="d-flex flex-row align-items-center mb-4">
    <button type="submit" id="submitBtnLogin" class="btn btn-dark col-12">로그인</button>
  </div>

  <div class="d-flex flex-row align-items-center mb-4">
    <a id="submitBtnJoin" class="btn btn-secondary col-12" href="./join">회원가입</a>
  </div>                 

</form>



</div>
</div></div>
 
 
 
 
  </main>          
<!-- footer 적용해야함 --> 
<c:import url ="../temp/footer.jsp"></c:import>
<!-- footer 적용 끝 -->


</body>
</html>