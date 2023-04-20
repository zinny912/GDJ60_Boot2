<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business - Start Bootstrap Template</title>
       <!-- css & favicon  -->
       <c:import url="../temp/style.jsp"></c:import>
       <!-- css & favicon  -->
    </head>
<body>

<section class="vh-70" style="background-color: #eee;">
  <div class="container-fluid">
    <div class="row d-flex justify-content-center align-items-center h-80">
      <div class="col-lg-12 col-xl-11">
            <div class="row justify-content-center">
              <div class="col-md-8 col-lg-5 col-xl-4 order-1 order-lg-1">
        <div class="card text-black" style="border-radius: 20px;">
          <div class="card-body">
          
                <p class="text-center h3 fw-bold mb-2 mx-1 mx-md-4 mt-2">회원가입</p>

                <form id="login_form" class="login_form mx-1 mx-md-4" action="./join" method="post">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="userName" name="userName" class="form-control" placeholder="아이디"/>
                           <label class="form-label" id="idLabel" for="id"></label>
					<div  class="hstack gap-3" id="emailDiv">
                      <input  type="email" id="email" name="email" class="col essential form-control" placeholder="이메일"/>
<!--                       <button type="button" class="col-2 btn btn-secondary text-nowrap">인증</button> -->
					</div>
                    

          <input type="password" id="password" name="password" class=" form-control" placeholder="비밀번호"/>
                      <label class="form-label" for="Password" id="password"></label>
                      <!-- <input type="password" id="passwordCheck" class="essential form-control" placeholder="비밀번호 확인"/>
                      <label class="form-label" id="passwordCheckLabel" for="passwordCheck"></label>
                    </div> -->
                  </div>
                  
                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="name" name="name" class="essential form-control" placeholder="이름"/>
<!--                       <label class="form-label" for="name">Your Name</label> -->
                    </div>
                  </div>



                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <input type="text" id="birth" name="birth" class="form-control" placeholder="생년월일"/>
<!--                       <label class="form-label" for="phone">연락처</label> -->
                    </div>
                  </div>

                 <!--  <div class="form-check d-flex justify-content-center mb-5">
                   <p>모든 약관에 동의합니다.</p>
                    <label class="form-check-label" for="agree">
                    <br>
                   <input class="check1 form-check-input me-2 text-center" onClick="javascript:mAgree();" type="checkbox" value="" id="agree" />
                     <a id="terms" href="javascript:mAgree()">약관확인</a>
                    </label>
    				
                  </div> -->

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" id="submitbtn" class="btn btn-primary btn-lg">회원가입</button>
                  </div>

                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- footer 적용해야함 --> 
<c:import url ="../temp/footer.jsp"></c:import>
<!-- footer 적용 끝 -->

</body>
</html>