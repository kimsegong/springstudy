<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>

  <div>
    <h1>MvcBoard 작성화면</h1>
  </div>
  
  <div>
    <form method="post" action="${contextPath}/board/insert.do">    
      <input type="text" name="author">
      <input type="text" name="title">
      <input type="text" name="content">
      <button>저장하기</button>
      <button>다시작성</button>
      <button>목록보기</button>
    </form>
  </div>

</body>
</html>