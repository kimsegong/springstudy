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
	fnDelete();
	fnList();
})
function fnDelete(){
	$('#btn_delete').click(function(){		
      if(confirm('게시글을 삭제할까요?')){
        location.href ='${contextPath}/board/delete.do?boardNo=${board.boardNo}';
      }
	})
  }
function fnList(){
	$('#btn_list').click(function(){		
      location.href = '${contextPath}/board/list.do';
	})
  }
</script>
<body>

 <div>
    <h1>MvcBoard 게시글 상세보기화면</h1>
    <h3>${board.boardNo}번 게시글</h3>
    <div>
     <a>작성자 : ${board.author}</a>
    </div>
    <div>
     <a>작성일 : ${board.postDate}</a>
    </div>
    <div>
     <a>작성IP : ${board.ip}</a>
    </div>
    <div>
     <a>조회수 : ${board.hit}</a>
    </div>
    <div>
     <a>제목 : ${board.title}</a>
    </div>
    <div>
     <a>내용 : ${board.content}</a>
    </div>
    <div>
      <button type="button" id="btn_delete">삭제하기</button>
      <button type="button" id="btn_list">목록보기</button>
    </div>
  </div>

  
  
  
   
  
</body>
</html>