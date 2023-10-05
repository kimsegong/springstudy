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

  <div>
    <a href="${contextPath}/board/list.do">목록으로 이동</a>
  </div>

  <div>
    <h3>게시글 상세보기</h3>
    <div>번호 : ${board.boardNo}</div>
    <div>제목 : ${board.title}</div>
    <div>작성 : ${board.editor}</div>
  </div>

</body>
</html>