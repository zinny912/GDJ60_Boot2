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
        <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
  		<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
          <!-- Navigation-->
  		   <c:import url="../temp/header.jsp"></c:import>
            <!-- Header-->
 </main>           
  <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">
                            <div class="feature  bg-gradient text-white rounded-3 mb-3"><img src="../images/pencil.png"></div>
                            <h1 class="fw-bolder" style="text-transform:uppercase;" >${board} 글쓰기</h1>
                            <p class="lead fw-normal text-muted mb-0">글을 써주세요</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                             
                               <%--  <form id="contactForm" action="./add" method="post" enctype="multipart/form-data"> --%>
                                <form:form id="contactForm" cssClass= "" modelAttribute="boardVO" method="post" enctype="multipart/form-data"> 
                                   
                                    <!-- Title input-->
                                    <div class="form-floating mb-3">
                                        <!-- <input class="form-control" id="title" type="text" name="title" placeholder="제목을 입력하세요" data-sb-validations="required" /> -->
                                        
                                        <form:input path="title" id="title" cssClass="form-control" />
                                        <!-- modelAttribute로 받은 setter를 path에 쓰기  -->
                                        
                                        <label for="title">제목</label>
                                        <form:errors path="title" cssStyle="color:tomato"></form:errors>
                                        
                                    </div>
                                    <!-- Writer input-->
                                    <div class="form-floating mb-3">
                                       <!--  <input class="form-control" id="writer" type="text" name="writer" data-sb-validations="required" /> -->
                                        <form:input path="writer" id="writer" cssClass="form-control"/>
                                        <label for="writer">작성자</label>
                                        <form:errors path="writer" cssStyle="color:tomato"></form:errors>
                                        
                                    </div>
                                    <div class="form-floating mb-3">
                                       <!--  <input class="form-control" id="writer" type="text" name="writer" data-sb-validations="required" /> -->
                                        <form:input path="subVO.subName" id="writer" cssClass="form-control"/>
                                        <label for="subName">subName</label>
                                       <%--  <form:errors path="writer" cssStyle="color:tomato"></form:errors> --%>
                                        
                                    </div>
                                    
                                     <div class="form-floating mb-3">
                                       <!--  <input class="form-control" id="writer" type="text" name="writer" data-sb-validations="required" /> -->
                                        <form:input path="names" id="writer" cssClass="form-control"/>
                                        <label for="names">Names</label>
                                       <%--  <form:errors path="writer" cssStyle="color:tomato"></form:errors> --%>
                                        
                                    </div>
                                     <div class="form-floating mb-3">
                                       <!--  <input class="form-control" id="writer" type="text" name="writer" data-sb-validations="required" /> -->
                                        <form:input path="boardFileVOs[1].fileName" id="writer" cssClass="form-control"/>
                                        <label for="writer">BoardFileName</label>
                                       <%--  <form:errors path="writer" cssStyle="color:tomato"></form:errors> --%>
                                        
                                    </div>
                                   
                                   <div class="form-floating mb-3">
                                       <!--  <input class="form-control" id="writer" type="text" name="writer" data-sb-validations="required" /> -->
                                        <form:input path="boardFileVOs[2].fileName" id="writer" cssClass="form-control"/>
                                        <label for="writer">BoardFileName</label>
                                       <%--  <form:errors path="writer" cssStyle="color:tomato"></form:errors> --%>
                                        
                                    </div>
                                   
                                   
                                   
                                 
                                     <!-- Contents input-->
                                     <div class="form-floating mb-3">
                                        <textarea class="form-control" id="contents" type="text" name="contents" placeholder="Enter your message here..." style="height: 10rem" data-sb-validations="required"></textarea>
                                        <label for="contents">내용</label>
                                        <div class="invalid-feedback" data-sb-feedback="message:required">A message is required.</div>
                                    </div>
                                    
                                    
                                  <!--   
                                   <div class="form-floating">
										<textarea class="form-control" placeholder="Leave a comment here" id="contents"></textarea>
										<label for="contents">Comments</label>
									</div>
                                    -->
									  
									
									<div class="mb-3" id="imgList">
										<div class="form-text">최소 1장, 최대 5장까지 등록 가능합니다.</div>                                        
                                       	<div class="fw-bold fs-5 col-12 my-1 input-group" id="img'+idx+'">
							            <input type="file" class="form-control img" name="boardFiles" multiple="multiple" id="imgs">
							            <button type="button" class="btn btn-outline-primary btn-image" id="fileInsert">+</button>
							            
							           </div>                                                                                 
                                    </div>
									                                    
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                    
         
                    <!-- Contact cards-->
                    <div class="row gx-5 row-cols-2 row-cols-lg-4 py-5">
                        <div class="col ">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-chat-dots"></i></div>
                            <div class="h5 mb-2">Chat with us</div>
                            <p class="text-muted mb-0">Chat live with one of our support specialists.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-people"></i></div>
                            <div class="h5">Ask the community</div>
                            <p class="text-muted mb-0">Explore our community forums and communicate with other users.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-question-circle"></i></div>
                            <div class="h5">Support center</div>
                            <p class="text-muted mb-0">Browse FAQ's and support articles to find solutions.</p>
                        </div>
                        <div class="col">
                            <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-telephone"></i></div>
                            <div class="h5">Call us</div>
                            <p class="text-muted mb-0">Call us during normal business hours at (555) 892-9403.</p>
                        </div>
                    </div>
                </div>
            </section>
 
 
 
 <!-- <script src="../js/boardForm.js"></script> -->
 <script src="../js/fileManager.js"></script>
<!-- footer 적용해야함 --> 
<c:import url ="../temp/footer.jsp"></c:import>
<!-- footer 적용 끝 -->
</body>
</html>