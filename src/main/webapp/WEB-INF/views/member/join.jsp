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
<main class="flex-shrink-0">
     <c:import url="../temp/header.jsp"></c:import>
     
<section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                            <h1 class="fw-bolder">회원가입</h1>
                            <p class="lead fw-normal text-muted mb-0">인적사항을 입력하세요</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                
                                <form id="contactForm" data-sb-form-api-token="API_TOKEN" action="./join" method="post">
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="userName" name="userName" type="text" placeholder="아이디" data-sb-validations="required" />
                                        <label for="userName">아이디</label>
                                        <div class="idRe" style="color:red" data-sb-feedback="name:required"></div>
                                    </div>
                                     <!-- password input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="password" name="password" type="tel" placeholder="비밀번호" data-sb-validations="required" />
                                        <label for="password">비밀번호</label>
                                        <div class="pwRe" data-sb-feedback="phone:required"></div>
                                    </div>
                                    <!-- Phone number input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="passwordCheck" name="passwordCheck" type="text" placeholder="비밀번호확인" data-sb-validations="required" />
                                        <label for="passwordCheck">비밀번호확인 </label>
                                        <div class="pwReCheck" data-sb-feedback="phone:required"></div>
                                    </div>
                                    <!-- Phone number input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="name" name="name" type="text" placeholder="이름" data-sb-validations="required" />
                                        <label for="name">이름</label>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">A phone number is required.</div>
                                    </div>
                                    <!-- Email address input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="email" name="email" type="email" placeholder="name@example.com" data-sb-validations="required,email" />
                                        <label for="email">이메일</label>
                                        <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                        <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                                    </div>
                                    <!-- Birth input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="birth" type="date" name="birth" data-sb-validations="required" />
                                        <label for="birth">생년월일</label>
                                        <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.</div>
                                    </div>
                                   
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg " id="submitButton" type="submit">Submit</button></div>
                                </form>
                            </div>
                        </div>
                    </div>
                  </div>
             </section>
</main>
<!-- footer 적용해야함 --> 
<c:import url ="../temp/footer.jsp"></c:import>
<!-- footer 적용 끝 -->
<script src="/js/joinFormCheck.js"></script>
</body>
</html>