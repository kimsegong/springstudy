<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 .board {
  border-bottom: 1px solid gray;
 }
</style>
</head>
<body>

  <div>
    <h3>게시글 목록</h3>
    <c:forEach items="${boardList}" var="boardDto">
      <div class="board">
        <div>제목 : ${boardDto.title}</div>
        <div>작성 : ${boardDto.editor}</div>
      </div>
    </c:forEach>
  </div>

</body>
</html>