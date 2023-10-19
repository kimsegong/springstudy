<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.title == null ? '마이홈' : param.title}</title>
<link rel="stylesheet" href="${contextPath}/resources/css/init.css?dt=${dt}" />
<link rel="stylesheet" href="${contextPath}/resources/css/header.css?dt=${dt}" />
<link rel="stylesheet" href="${contextPath}/resources/css/main.css?dt=${dt}" />
<link rel="stylesheet" href="${contextPath}/resources/css/footer.css?dt=${dt}" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/40.0.0/classic/ckeditor.js"></script>
</head>
<body>

  <div class="header_wrap">
    <div class="logo"></div>
    <div class="login_wrap">
      <c:if test="${sessionScope.user == null}">
        <ul>
          <li><a href="${contextPath}/user/login.form">로그인</a></li>
          <li><a href="${contextPath}/user/join.form">회원가입</a></li>
        </ul>
      </c:if>
      <c:if test="${sessionScope.user != null}">
        <div>${sessionScope.user.name}님 환영합니다 ♥</div>
        <div><a href="${contextPath}/user/logout.do">로그아웃</a></div>
      </c:if>
    </div>
    <div class="gnb_wrap">
      <ul class="gnb">
        <li><a href="${contextPath}">댓글형게시판</a></li>
        <li><a href="${contextPath}">계층게시판</a></li>
        <li><a href="${contextPath}">첨부게시판</a></li>
        <li><a href="${contextPath}">MY</a></li>
      </ul>
    </div>
  </div>
  
  <div class="main_wrap">