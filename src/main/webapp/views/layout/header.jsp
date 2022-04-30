<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- jstl tag 사용 --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> <%-- pom.xml에 시큐리티 태그 라이브러리 추가해줘야 사용 가능 --%>

<sec:authorize access="isAuthenticated()"> <%-- spring security로 로그인하면 알아서 session이 생성되는데 이를 principal로 받아서 jsp내에서 사용할 수 있음 --%>
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/">My Blog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">

			<%-- jstl 사용해서 session 유무에 따라 화면 구성을 다르게 --%>
			<c:choose>
			<%--<c:when test="${empty sessionScope.principal}">  전통적인 스프링 로그인 방식 사용(session 객체 사용)--%>
				<c:when test="${empty principal }"><%-- spring security taglib authentication 사용 --%>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/login">Log In</a></li>
						<li class="nav-item"><a class="nav-link" href="/join">Sign Up</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/board/form">Write</a></li>
						<li class="nav-item"><a class="nav-link" href="/user/form">User Info</a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">Log Out</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<br />