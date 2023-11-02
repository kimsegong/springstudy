<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="업로드게시판" name="title"/>
</jsp:include>
<style>
  div {
   box-sizing: border-box;
  }
  .upload_list {
   width: 1000px;
   margin: 10px auto;
   display: flex;
   flex-wrap: wrap;   
  }
  .upload {
   width: 300px;
   height: 300px;
   border: 1px solid gray;
   text-align: center;
   padding-top: 100px;
   margin: 20px 10px; 
  }
  .upload:hover {
    background-color: silver;
    cursor: pointer;
  }
</style>

<div>

  <div>
    <a href="${contextPath}/upload/write.form">
      <button type="button" class="btn btn-primary">새글작성</button>
    </a>
  </div>
  
  <div id="upload_list" class="upload_list"></div>

</div>

<script>

  // 전역 변수
  var page = 1;
  var totalPage = 0;

  const fnGetUploadList = () => {
    $.ajax({
      // 요청
      type: 'get',
      url: '${contextPath}/upload/getList.do',
      data: 'page=' + page,
      // 응답
      dataType: 'json',
      success: (resData) => {
    	totalPage = resData.totalPage;
    	//$('#upload_list').empty();
    	$.each(resData.uploadList, (i, upload) => {
    	  let str = '<div class="upload">';
    	  str += '<div>' + upload.title + '</div>';
    	  str += '<div>' + upload.userDto.name + '</div>';
    	  str += '<div>' + upload.createdAt + '</div>';
    	  str += '<div>' + upload.attachCount + '</div>';
    	  str += '</div>';
    	  $('#upload_list').append(str);
    	})
      }
    })
    
  }
  
  const fnScroll = () => {
	  
	var timerId;  // 최초 undefined 상태
	  
	$(window).on('scroll', () => {
		
		if(timerId){  // timerId가 undefined이면 false로 인식, timerId가 값을 가지면 true
		  clearTimeout(timerId);
		}
		timerId = setTimeout(() => { 
		  let scrollTop = $(window).scrollTop();
		  let windowHeight = $(window).height();
		  let documentHeight = $(document).height();
		  
		  if(scrollTop + windowHeight + 100 >= documentHeight){
			if(page > totalPage){
			 return;
			}
			page++;
			fnGetUploadList();
		  }
		}, 200);
	})  
  }

  const fnAddResult = () => {
	  let addResult = '${addResult}';  // '', 'true', 'false'
	  if(addResult !== ''){
		  if(addResult === 'true'){
			  alert('성공적으로 업로드 되었습니다.');
			  $('#upload_list').empty();
			  fnGetUploadList();
		  } else {
			  alert('업로드가 실패하였습니다.');
		  }
	  }
  }
  fnScroll();
  fnGetUploadList();
  fnAddResult();

</script>

<%@ include file="../layout/footer.jsp" %>