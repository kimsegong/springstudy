<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="회원가입" name="title"/>
</jsp:include>
<script src="${contextPath}/resources/js/user_join.js"></script>
<script>

</script>
  <div>
  
    <form id="frm_join" method="post" action="${contextPath}/user/join.do">
    
      <h1>회원가입</h1>
      
      <div>
        <label for="email">이메일</label>
        <input type="text" name="email" id="email">
        <button type="button" id="btn_get_code">인증번호받기</button>
        <span id="msg_email"></span>
      </div>
      <div>
        <input type="text" id="code" placeholder="인증코드입력">
        <button type="button" id="btn_verify_code">인증하기</button>
      </div>
      
    
     
        <div>
          <input type="hidden" name="event" value="${event}">
          <button type="submit">회원가입하기</button>
        </div>
    </form>
  
  
  
  </div>

<%@ include file="../layout/footer.jsp" %>