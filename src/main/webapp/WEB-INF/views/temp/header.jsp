<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
 
       <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container px-5">
                    <a class="navbar-brand" href="/"><img src="/images/baseball.png" class="border border-2 border-color-black rounded-4 "> 최강야구</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                            <li class="nav-item"><a class="nav-link" href="/notice/list">노티스</a></li>
                            <li class="nav-item"><a class="nav-link" href="/qna/list">QNA</a></li>
	                           <li class="nav-item"><a class="nav-link" href="/member/admin">관리자</a></li>
	                           
                          
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">선수명단</a>
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
                                    <li><a class="dropdown-item" href="blog-home.html">감독</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">배터리</a></li>
                                    <li><a class="dropdown-item" href="blog-post.html">야수들</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdownPortfolio" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Portfolio</a>
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownPortfolio">
                                    <li><a class="dropdown-item" href="portfolio-overview.html">Portfolio Overview</a></li>
                                    <li><a class="dropdown-item" href="portfolio-item.html">Portfolio Item</a></li>
                                </ul>
                            </li>
                            
                        	<sec:authorize access="!isAuthenticated()">
                             <li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>
                            <li class="nav-item"><a class="nav-link" href="/member/join">회원가입</a></li>
                            </sec:authorize>
                            
                           <sec:authorize access="isAuthenticated()">
                           <li class="nav-item"><a class="nav-link" href="/member/logout">로그아웃</a></li>
                           	<li class="nav-item"><a class="nav-link" href="/member/myPage">마이페이지</a></li>
                         </sec:authorize>
                           
                            <li class="nav-item"><a class="nav-link" href="/?lang_opt=ko">KO</a></li>
                            <li class="nav-item"><a class="nav-link" href="/?lang_opt=en">EN</a></li>
                        </ul>
                    </div>
                </div>
            </nav>