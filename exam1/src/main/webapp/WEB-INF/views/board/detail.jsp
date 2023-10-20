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

  

  <div id="a">
    <h1>MvcBoard 게시글 상세보기화면</h1>
    <h3>${board.boardNo}번 게시글</h3>
    <a>작성자 : ${board.author}</a>
    <a>작성일 : ${board.postDate}</a>
    <a>작성IP : ${board.ip}</a>
    <a>조회수 : ${board.hit}</a>
    <a>제목 : ${board.title}</a>
    <a>내용 : ${board.content}</a>
    <div>
      <button type="button" id="btn_delete">삭제하기</button>
      <button type="button" id="btn_list">목록보기</button>
    </div>
  </div>
  
  
    <script>
      $('#gubun').val('${notice.gubun}');
      $('#title').val('${notice.title}');
      $('#content').val('${notice.content}');
      $('#noticeNo').val('${notice.noticeNo}');
    </script>
  
</body>
</html>