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
   <h1>공지 작성화면</h1>
   <form method="post" action="${contextPath}/notice/save.do">
    <select name="gubun">
      <option value="2">일반</option>
      <option value="1">긴급</option>
    </select>
    <input type="text" name="title">
    <input type="text" name="content">
    <button>작성완료</button>
   </form>
  </div>

</body>
</html>