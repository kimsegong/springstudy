<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="${upload.uploadNo}번 게시글" name="title"/>
</jsp:include>

<style>
  .attach {
    cursor: pointer;
  }
</style>

<div>

  <h1 style="text-align: center;">Upload 게시글</h1>
  <div>작성자 : ${upload.userDto.name}</div>
  <div>작성일 : ${upload.createdAt}</div>
  <div>수정일 : ${upload.modifiedAt}</div>
  <div>제목 : ${upload.title}</div>
  <div>내용</div>
  <div>${upload.contents}</div>
  <div>
    <c:if test="${sessionScope.user.userNo == upload.userDto.userNo}">
      <form id="frm_btn">
        <input type="hidden" name="uploadNo" value="${upload.uploadNo}">
        <button type="button" id="btn_edit">편집</button>
        <button type="button" id="btn_remove">삭제</button>
      </form>
    </c:if>
  </div>
  
  <hr>
  
  <h4>첨부 다운로드</h4>
  <div>
    <c:if test="${empty attachList}">
      <div>첨부 없음</div>
    </c:if>
    <c:if test="${not empty attachList}">
      <c:forEach items="${attachList}" var="atc">
        <div class="attach" data-attach_no="${atc.attachNo}">
          <c:if test="${atc.hasThumbnail == 1}">
            <img src="${contextPath}${atc.path}/s_${atc.filesystemName}" alt="썸네일" width="50px">
          </c:if>
          <c:if test="${atc.hasThumbnail == 0}">
            <img src="${contextPath}/resources/image/attach1.png" alt="썸네일" width="50px">
          </c:if>
          ${atc.originalFilename}
        </div>
      </c:forEach>
      <div><a href="${contextPath}/upload/downloadAll.do?uploadNo=${upload.uploadNo}">모두 다운로드</a></div>
    </c:if>
  </div>
  
</div>
  
<script>

  var frmBtn = $('#frm_btn');

  const fnEdit = () => {
	  $('#btn_edit').click(() => {
		  frmBtn.attr('action', '${contextPath}/upload/edit.form');
		  frmBtn.attr('method', 'get');
		  frmBtn.submit();
	  })
  }


  const fnDownload = () => {
	  $('.attach').click(function(){
		  if(confirm('다운로드 할까요?')){
			  location.href = '${contextPath}/upload/download.do?attachNo=' + $(this).data('attach_no');
		  }
	  })
  }
  
  const fnModifyResult = () => {
	  let modifyResult = '${modifyResult}';
	  if(modifyResult !== ''){
		  if(modifyResult === '1'){
			  alert('게시글이 수정되었습니다.');
		  } else {
			  alert('게시글이 수정되지 않았습니다.');
		  }
	  }
  }
  
  fnEdit();
  fnDownload();
  fnModifyResult();
  
</script>
  
<%@ include file="../layout/footer.jsp" %>