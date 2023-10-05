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
    <h3>게시글 목록</h3>
    <c:forEach items="${boardList}" var="b">
      <div>
        <a href="${contextPath}/board/detail.do?boardNo=${b.boardNo}">${b.boardNo} - ${b.title} - ${b.editor}</a>
      </div>
    </c:forEach>
  </div>

</body>
</html>