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
   <h3>연락처등록</h3>
   <form method="post" action="${contextPath}/contact/add.do">
    <div>
      <label for="name">이름</label>
      <input type="text" id="name" name="name">
    </div>
    <div>
      <label for="tel">전화번호</label>
      <input type="text" id="tel" name="tel">
    </div>
    <div>
      <label for="email">이메일</label>
      <input type="text" id="email" name="email">
    </div>
    <div>
      <label for="address">주소</label>
      <input type="text" id="address" name="address">
    </div>
    <div>
      <button type="submit">등록</button>
      <button type="reset">입력취소</button>
    </div>
   </form>
  </div>

</body>
</html>