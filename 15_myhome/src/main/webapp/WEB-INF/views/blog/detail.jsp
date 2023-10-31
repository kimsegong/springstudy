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
<style>
 .blind {
  display: none;
 }
 .ico_remove_comment {
  cursor: pointer;
 
 }
</style>


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
      <!-- 블로그의 작성자는 편집/삭제를 수행할 수 있다. -->
      <c:if test="${sessionScope.user.userNo == blog.userDto.userNo}">
        <form id="frm_btn" method="post">
          <input type="hidden" name="blogNo" value="${blog.blogNo}">
          <button type="button" id="btn_edit">편집</button>
          <button type="button" id="btn_remove">삭제</button>
        </form>
      </c:if>
    </div>
    <div>${blog.contents}</div>
  </div>
  
  <script>
    
    var frmBtn = $('#frm_btn');
  
    const fnEditBlog = () => {
      $('#btn_edit').click(() => {
        frmBtn.attr('action', '${contextPath}/blog/edit.form');
        frmBtn.submit();
      })
    }
    
    const fnRemoveBlog = () => {
      $('#btn_remove').click(() => {
        if(confirm('블로그를 삭제하면 모든 댓글이 함께 삭제됩니다. 삭제할까요?')){
          frmBtn.attr('action', '${contextPath}/blog/remove.do');
          frmBtn.submit();          
        }
      })
    }
    
    fnEditBlog();
    fnRemoveBlog();
    
  </script>
  
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
      $('#contents, #btn_comment_add, .btn_open_reply, .btn_add_reply').click(() => {
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
    	  if('${sessionScope.user}' === ''){
              if(confirm('로그인이 필요한 기능입니다. 로그인할까요?')){
                location.href = '${contextPath}/user/login.form';
              } else {
                return;
              }
            }
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
            if(c.status === 0){
              str += '<div>삭제된 댓글입니다.</div>';
            } else {           	
            str += '  <div>' + c.userDto.name + '</div>';
            str += '  <div>' + c.contents + '</div>';
            str += '  <div style="font-size: 12px;">' + c.createdAt + '</div>';
            if(c.depth === 0){
              str += '  <div><button type="button" class="btn_open_reply">답글달기</button></div>';
            }
            /************************** 답글 입력 창 **************************/
            str += '  <div class="blind frm_add_reply_wrap">';
            str += '    <form class="frm_add_reply">';
            str += '      <textarea rows="3" cols="50" name="contents" placeholder="답글을 입력하세요"></textarea>';
            str += '      <input type="hidden" name="userNo" value="${sessionScope.user.userNo}">';
            str += '      <input type="hidden" name="blogNo" value="${blog.blogNo}">';
            str += '      <input type="hidden" name="groupNo" value="' + c.groupNo + '">';
            str += '      <button type="button" class="btn_add_reply">답글작성완료</button>';
            str += '    </form>';
            str += '  </div>';
            /******************************************************************/
            if('${sessionScope.user.userNo}' == c.userDto.userNo){           	
            str += '  <div>';
            str += '   <input type="hidden" value="' + c.commentNo + '">';           
            str += '   <i class="fa-solid fa-circle-xmark ico_remove_comment" style="color: #47acd7;"></i>';
            str += '  </div>';
              }
            }                
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
    
    const fnBlind = () => {
     $(document).on('click', '.btn_open_reply', (ev) => {
    	if('${sessionScope.user}' === ''){
             if(confirm('로그인이 필요한 기능입니다. 로그인할까요?')){
               location.href = '${contextPath}/user/login.form';
             } else {
               return;
             }
           }
    	var blindTarget = $(ev.target).parent().next();
    	if(blindTarget.hasClass('blind')){
    	  // 모든 답글 입력화면 닫기
    	  $('.frm_add_reply_wrap').addClass('blind');
    	  blindTarget.removeClass('blind'); // 답글 입력화면 열기
    	} else {
    	  blindTarget.addClass('blind');
    	}
     })
    }
    
    const fnCommentReplyAdd = () => {
    	$(document).on('click', '.btn_add_reply', (ev) => {
    		if('${sessionScope.user}' === ''){
    	          if(confirm('로그인이 필요한 기능입니다. 로그인할까요?')){
    	            location.href = '${contextPath}/user/login.form';
    	          } else {
    	            return;
    	          }
    	        }
    		var frmAddReply = $(ev.target).closest('.frm_add_reply');
    		$.ajax({
    			// 요청
    			type: 'post',
    			url: '${contextPath}/blog/addCommentReply.do',
    			data: frmAddReply.serialize(),
    			// 응답
    			dataType: 'json',
    			success: (resData) => {  // resData = {"addCommentReplyResult": 1}
    				if(resData.addCommentReplyResult === 1){
    					alert('답글이 등록되었습니다.');
    					fnCommentList();
    					frmAddReply.find('textarea').val('');
    				} else {
    					alert('답글이 등록되지 않았습니다.');
    				}
    			}
    		})
    	})
    }
    fnCommentRemove = () => {
    $(document).on('click', '.ico_remove_comment', (ev) => {
    	  if (!confirm('댓글을 삭제하시겠습니까?')) {
		    return;
    	  }
    	  $.ajax({
    	     type: 'post',
    	     url: '${contextPath}/blog/removeComment.do',
    	     data: 'commentNo=' + $(ev.target).prev().val(), 
    	     dataType: 'json',
    	     success: (resData) => {
    	      if(resData.removeResult === 1){
    	         alert('댓글이 삭제되었습니다.');
    	         fnCommentList();
    	        } else {
    	         alert('댓글 삭제에 실패했습니다.');
              }
    	     }
    	   })
    	})
    }
    
    fnRequiredLogin(); 
    fnCommentAdd();
    fnCommentList();
    fnBlind();
    fnCommentReplyAdd();
    fnCommentRemove();
    
    /*
    <div style="width: 100%; border-bottom: 1px solid gray;">
    
      // 삭제된 댓글/답글
      <div>삭제된 댓글입니다.</div>
    	
      <div>이름</div>
      <div>내용</div>
      <div style="font-size: 12px;">작성일자</div>
      <div><button type="button" class="btn_open_reply">답글달기</button></div>
      <div class="blind">
        <form class="frm_add_reply">
          <textarea rows="3" cols="50" name="contents" placeholder="답글을 입력하세요"></textarea>
          <input type="hidden" name="userNo" value="">
          <input type="hidden" name="blogNo" value="">
          <input type="hidden" name="groupNo" value="">
          <button type="button" class="btn_add_reply">답글작성완료</button>
        </form>
      </div>
      <div>
        <input type="hidden" value="${comment.commentNo}">
        <button type="button" class="btn_remove_comment">삭제하기</button>
      </div>
    </div>
    */
    
  </script>

</div>

<%@ include file="../layout/footer.jsp" %>