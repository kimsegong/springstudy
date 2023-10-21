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
<script>
$(function(){    
	fnList();
})

function fnList(){
	$('#btn_list').click(function(){		
      location.href = '${contextPath}/board/list.do';
	})
  }
</script>
<body>

  <div>
    <h1>MvcBoard 작성화면</h1>
  </div>
  
  <div>
    <form method="post" action="${contextPath}/board/insert.do">  
    		  
      <div>
      	<div><label for="author">작성자</label></div>
        <input type="text" name="author">	
      </div>
      <div>
        <div><label for="title">제목</label></div>
        <input type="text" id="title" name="title">
      </div>
      <div>
        <div><label for="content">내용</label></div>
        <textarea id="content" name="content" rows="5" cols="30"></textarea>
      </div>
      <button>저장하기</button>
      <button type="reset">다시작성</button>
      <button type="button" id="btn_list">목록보기</button>
    </form>
  </div>

</body>
</html>