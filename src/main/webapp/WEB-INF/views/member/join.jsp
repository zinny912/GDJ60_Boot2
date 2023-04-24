<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
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
                                
                                <%-- <form id="contactForm" data-sb-form-api-token="API_TOKEN" action="./join" method="post"> --%>
                                <form:form id="contactForm" modelAttribute="memberVO" method="post">
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                        <form:input path="userName" id="userName" cssClass="form-control"/>
                     
                                        <form:label path="userName">아이디</form:label>
                                        <form:errors path="userName" cssStyle="color:tomato"/>
                                       	<div class="idReCheck"></div>
                                    </div>
                                     <!-- password input-->
                                    <div class="form-floating mb-3">
                                    <form:input path="password" id="password" cssClass="form-control" type="password"/>
                                       
                                        <form:label path="password">비밀번호</form:label>
                                    <form:errors path="password" cssStyle="color:tomato"/>    
                                         
                                    </div>
                                    <!-- Phone number input-->
                                    <div class="form-floating mb-3">
                                        <form:input cssClass="form-control" id="passwordCheck" path="passwordCheck" type="password" placeholder="비밀번호확인" />
                                        <form:label path="passwordCheck">비밀번호확인 </form:label>
                                        <form:errors path="passwordCheck"></form:errors>
                                        <div class="pwReCheck"></div>
                                    </div>
                                    <!-- Phone number input-->
                                    <div class="form-floating mb-3">
                                    <form:input path="name" id="name" cssClass="form-control"/>
                                       
                                        <form:label path="name">이름</form:label>
                                        <form:errors path="name" cssStyle="color:tomato"/>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">A phone number is required.</div>
                                    </div>
                                    <!-- Email address input-->
                                    <div class="form-floating mb-3">
                                       <form:input id="email" path="email" cssClass="form-control"/>
                                        <form:label path="email">이메일</form:label>
                                        <form:errors path="email" cssStyle="color:tomato"/>
                                    </div>
                                    <!-- Birth input-->
                                    <div class="form-floating mb-3">
                                        <form:input cssClass="form-control" id="birth" type="date" path="birth" />
                                        <form:label path="birth">생년월일</form:label>
                                        <form:errors path="birth" cssStyle="color:tomato"/>
                                    </div>
                                   
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg " id="submitButton" type="submit">Submit</button></div>
                               </form:form>
                               
                            </div>
                        </div>
                    </div>
                  </div>
             </section>
</main>
<!-- footer 적용해야함 --> 
<c:import url ="../temp/footer.jsp"></c:import>
<!-- footer 적용 끝 -->
<!-- <script src="/js/joinFormCheck.js"></script> -->
</body>
</html>