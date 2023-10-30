<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="${blog.blogNo}번 블로그" name="title"/>
</jsp:include>

<div>

  <!-- 블로그 상세보기 -->
  <div>
    <h1>${blog.title}</h1>
    <div>작성자 : ${blog.userDto.name}</div>
    <div>조회수 : ${blog.hit}</div>
    <div>작성IP : ${blog.ip}</div>
    <div>작성일 : ${blog.createdAt}</div>
    <div>수정일 : ${blog.modifiedAt}</div>
    <div>
      버튼구역
    </div>
    <div>${blog.contents}</div>
  </div>
  
  <hr>
  
  <!-- 댓글 작성 화면 -->
  <div>
    <form id="frm_comment_add">
      <textarea rows="3" cols="50" name="contents" id="contents" placeholder="댓글을 작성해 주세요"></textarea>
      <input type="hidden" name="userNo" value="${sessionScope.user.userNo}">
      <input type="hidden" name="blogNo" value="${blog.blogNo}">
      <button type="button" id="btn_comment_add">작성완료</button>
    </form>
  </div>
  
  <!-- 블로그 댓글 목록 -->
  <div style="width: 100%; border-bottom: 1px solid gray;"></div>
  <div id="comment_list"></div>
  <div id="paging"></div>
  
  <script>
  
    const fnRequiredLogin = () => {        
      // 로그인을 안하고 작성을 시도하면 로그인 페이지로 보내기
      $('#contents, #btn_comment_add').click(() => {
        if('${sessionScope.user}' === ''){
          if(confirm('로그인이 필요한 기능입니다. 로그인할까요?')){
            location.href = '${contextPath}/user/login.form';
          } else {
            return;
          }
        }
      })
    }
    
    const fnCommentAdd = () => {
      $('#btn_comment_add').click(() => {
        $.ajax({
          // 요청
          type: 'post',
          url: '${contextPath}/blog/addComment.do',
          data: $('#frm_comment_add').serialize(),
          // 응답
          dataType: 'json',
          success: (resData) => {  // {"addCommentResult": 1}
            if(resData.addCommentResult === 1){
              alert('댓글이 등록되었습니다.');
              $('#contents').val('');
              fnCommentList();
            }
          }
        })
      })
    }
    
    // 전역 변수
    var page = 1;
    
    const fnCommentList = () => {
      $.ajax({
        // 요청
        type: 'get',
        url: '${contextPath}/blog/commentList.do',
        data: 'page=' + page + '&blogNo=${blog.blogNo}',
        // 응답
        dataType: 'json',
        success: (resData) => {  // resData = {"commentList": [], "paging": "<div>...</div>"}
        	$('#comment_list').empty();
        	$('#paging').empty();
          if(resData.commentList.length === 0){
        	  $('#comment_list').text('첫 번째 댓글의 주인공이 되어 보세요');
        	  $('#paging').text('');
        	  return;
          }
          $.each(resData.commentList, (i, c) => {
        	  let str = '';
        	  if(c.depth === 0){
        		  str += '<div style="width: 100%; border-bottom: 1px solid gray;">';
        	  } else {
        		  str += '<div style="width: 100%; border-bottom: 1px solid gray; margin-left: 32px;">';
        	  }
        	  str += '  <div>' + c.userDto.name + '</div>';
        	  str += '  <div>' + c.contents + '</div>';
        	  str += '  <div style="font-size: 12px;">' + c.createdAt + '</div>';
        	  str += '</div>';
        	  $('#comment_list').append(str);
          })
          $('#paging').append(resData.paging);  // fnAjaxPaging() 함수가 호출되는 곳
        }
      })
    }
    
    const fnAjaxPaging = (p) => {
    	page = p;
    	fnCommentList();
    }
    
    fnRequiredLogin();
    fnCommentAdd();
    fnCommentList();
    
    /*
    <div style="width: 100%; border-bottom: 1px solid gray;">
      <div>이름</div>
      <div>내용</div>
      <div style="font-size: 12px;">작성일자</div>
    </div>
    */
    
  </script>

</div>

<%@ include file="../layout/footer.jsp" %>