<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%-- MyController01으로 요청 --%>
  <div>
    <a href="${contextPath}/board/list.do">board 목록</a>
  </div>
  
  <%-- MyController02으로 요청 --%>
  <div>
    <a href="${contextPath}/notice/list.do">notice 목록</a>
    <br>
    <a href="${contextPath}/member/list.do">member 목록</a>
  </div>
  
  <%-- MyController03으로 요청 --%>
  <div>
    <a href="${contextPath}/blog/detail.do?blogNo=100">블로그 상세보기</a>
  </div>
  
</body>
</html>