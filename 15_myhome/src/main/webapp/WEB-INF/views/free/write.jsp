<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="게시판" name="title"/>
</jsp:include>



   <form id="frm_free_add" method="post" action="${contextPath}/free/add.do">
    
    <h1>자유게시글을 작성하세요</h1>
    
    
      <div>
        <label for="email">작성자</label>
        <input type="text" name="email" id="email" value="${sessionScope.user.email}" readonly>
      </div>

    
      <div>
        <label for="contents">내용</label>
        <textarea id="contents" name="contents" rows="10" cols="20"></textarea>
      </div>
       
      <div>
        <button type="submit">작성완료</button>
      </div>
    
  </form>

<%@ include file="../layout/footer.jsp" %>