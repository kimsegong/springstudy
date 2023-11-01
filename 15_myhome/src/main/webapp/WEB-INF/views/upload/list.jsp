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

<div>

  <div>
    <a href="${contextPath}/upload/write.form">
      <button type="button" class="btn btn-primary">새글작성</button>
    </a>
  </div>
  
  <div id="upload_list"></div>

</div>

<script>

  const fnAddResult = () => {
	  let addResult = '${addResult}';  // '', 'true', 'false'
	  if(addResult !== ''){
		  if(addResult === 'true'){
			  alert('성공적으로 업로드 되었습니다.');
			  // 목록 갱신
		  } else {
			  alert('업로드가 실패하였습니다.');
		  }
	  }
  }

  fnAddResult();

</script>

<%@ include file="../layout/footer.jsp" %>