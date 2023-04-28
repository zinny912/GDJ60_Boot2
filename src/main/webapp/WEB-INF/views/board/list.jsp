<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modern Business - Start Bootstrap Template</title>
       <!-- css & favicon  -->
       <c:import url="../temp/style.jsp"></c:import>
       <!-- css & favicon  -->
       <style>
       
table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 80%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: center;
}
  
thead {
  font-weight: bold;
  color: #fff;
  background: tomato;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
  text-align: center;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #tomato;
}
       
       
</style>
</head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
          <!-- Navigation-->
  		   <c:import url="../temp/header.jsp"></c:import>
  		   
  		   
            <!-- Header-->
             <section class="bg-light py-5">
                <div class="container px-5 my-5">
                    <div class="text-center mb-5">
                    <img src="../images/card.png">
                        <h1 class="fw-bolder" style="text-transform:uppercase; color:tomato;"> ${board}</h1>
                        <p class="lead fw-normal text-muted mb-0">GIVE ME THE MONEY!!</p>

                    </div>
                    </div>
                    <div class="container" style="margin-left:10%;">
                    <sec:authorize access="hasRole('ADMIN')">
                    <a href="./add" class="btn" style="color:tomato;">글쓰기</a>
                    </sec:authorize>
                    </div>
                    <div class="container-fluid" >
                    <table class="table" style="width:80%; margin:auto">
                    
                    <thead>
                    <tr>
	                    <th style="width:10%">NUMBER</th>
	                    <th>TITLE</th>
	                    <th>WRITER</th>
	                    <th>DATE</th>
	                    <th>조회수</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="boardVO">
                    	<tr>
                    		<td>${boardVO.num}</td>
                    		<td><a href="./detail?num=${boardVO.num}">${boardVO.title}</a></td>
                    		<td>${boardVO.writer}</td>
                    		<td>${boardVO.wdate}</td>
			                <td>${boardVO.click}</td>   	
                    	</tr>
                    
                    </c:forEach>
                    
                    </tbody>
                    </table>
                    </div>



	


 
    <div class="row my-3">
	<nav aria-label="Page navigation example ">
		<ul class="pagination" style="justify-content: center">
							<li class="page-item ${pager.page eq 1 ?'disabled':''}"><a
								class="page-link"
								href="./list?page=1&kind=${pager.kind}&search=${pager.search}"
								aria-label="Previous" data-board-page="1"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="page-item ${pager.page eq 1 ?'disabled':''}">
								<a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous" data-board-page="${pager.startNum}"> 
									<span aria-hidden="true">&lsaquo;</span>
							</a></li>

							<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="page">
								<li class="page-item"><a class="page-link" href="./list?page=${page}&kind=${pager.kind}&search=${pager.search}">${page}</a></li>
							</c:forEach>


							<li class="page-item ${pager.next eq false ?'disabled':''}">
								<a class="page-link"
								href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"
								aria-label="Next" data-board-page="${pager.lastNum}"> <span
									aria-hidden="true">&rsaquo;</span>
							</a>
							</li>

							<li
								class="page-item ${pager.page eq pager.totalPage?'disabled' : ''}">
								<a class="page-link"
								href="./list?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}"
								aria-label="Next" data-board-page="${pager.totalPage}"> <span
									aria-hidden="true">&raquo;</span>
							</a>
							</li>
						</ul>
	</nav>
</div> 

	<!-- 검색창 -->
	<form action="./list" method="get">
		<div class="row" style="justify-content: center;">
			<div class="col-auto">
						<select class="form-select" aria-label="Default select example" name="kind">
									  <option value="title">글제목 </option>
									  <option value="contents">내용 </option>
									  <option value="writer">작성자 </option>
								</select>
							</div>	
							<div class="col-auto">
								<input type="text" name="search" class="form-control">
								</div>
							<div class="col-auto">
								<button type="submit" class="btn mb-3" style="color:tomato;">검색</button>
								</div>
								</div>
							</form>

</section>



 </main>           
<!-- footer 적용해야함 --> 
<c:import url ="../temp/footer.jsp"></c:import>
<!-- footer 적용 끝 -->