<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="로그인" name="title"/>
</jsp:include>

<style>
  .login_form_wrap {
    width: 300px;
  }
  #email1 {
   margin-bottom: 20px;
  }
  
  #name1 {
   margin-top:5px;
  }
  
</style>

  <div class="login_form_wrap center_wrap">
    <form method="post" action="${contextPath}/user/login.do">
        <div class="input-group flex-nowrap" id="email1">
          <label for="email"></label>
          <span class="input-group-text" id="addon-wrapping">아이디</span>
          <input type="text"  name="email" id="email" class="form-control" placeholder="admin@gmail.com"aria-label="Username" aria-describedby="addon-wrapping">
        </div>
      <div class="input-group flex-nowrap">
        <label for="pw"></label>
        <span class="input-group-text" id="addon-wrapping">비밀번호</span>
        <input type="password" name="pw" id="pw"  class="form-control" placeholder="●●●●●●" aria-label="Username" aria-describedby="addon-wrapping">
      </div>
      <div id="name1">
        <input type="hidden" name="referer" value="${referer}">
        <button type="submit" class="btn btn-success">로그인</button>
      </div>
    </form>
    <ul class="ul_menu center_wrap">
      <li><a href="${contextPath}">자동로그인</a>
      <li><a href="${contextPath}">아이디/비밀번호 찾기</a>
    </ul>
    <hr>
    <div>
      <a href="${naverLoginURL}">
        <img src="${contextPath}/resources/image/btnD_완성형.png" width="200px">
      </a>
    </div>
  </div>

<%@ include file="../layout/footer.jsp" %>