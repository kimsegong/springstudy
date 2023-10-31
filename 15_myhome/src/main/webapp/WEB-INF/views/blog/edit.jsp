<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="블로그편집" name="title"/>
</jsp:include>
<style>
  .ck.ck-editor {
    max-width: 1000px;
  }
  .ck-editor__editable {
    font-size 12px;
    min-height: 400px;
  }
  .ck-content {
    color: gray;
  }
  #sub {
   margin-top: 10px;
   margin-bottom: 10px;
  }
</style>


   <form id="frm_blog_modify" method="post" action="${contextPath}/blog/modifyBlog.do">
    
      <h1 style="text-align: center;">${blog.blogNo}번 블로그 편집🐶</h1>
    
    
      <div>
        <label for="title">제목</label>
        <input type="text" name="title" id="title" class="form-control" value="${blog.title}">
      </div>

    
      <div>
        <label for="contents">내용</label>
        <textarea id="contents" name="contents" rows="10" cols="20">${blog.contents}</textarea>
      </div>
       
      <div id="sub">
        <input type="hidden" name="blogNo" value="${blog.blogNo}">
        <button type="submit" class="btn btn-dark">수정완료</button>
      </div>
    
  </form>
  
  
  <script>
  
   const fnCkeditor = () => {	 
	  ClassicEditor
	    .create(document.getElementById('contents'), {
		    toolbar: {
			    items: [
		        'undo', 'redo',
		        '|', 'heading',
		        '|', 'fontfamily', 'fontsize', 'fontColor', 'fontBackgroundColor',
		        '|', 'bold', 'italic', 'strikethrough', 'subscript', 'superscript', 'code',
		        '|', 'link', 'uploadImage', 'blockQuote', 'codeBlock',
		        '|', 'bulletedList', 'numberedList', 'todoList', 'outdent', 'indent'
  		    ],
  		    shouldNotGroupWhenFull: false
  	   },
       heading: {
         options: [
           { model: 'paragraph', title: 'Paragraph', class: 'ck-heading_paragraph' },
           { model: 'heading1', view: 'h1', title: 'Heading 1', class: 'ck-heading_heading1' },
           { model: 'heading2', view: 'h2', title: 'Heading 2', class: 'ck-heading_heading2' },
           { model: 'heading3', view: 'h3', title: 'Heading 3', class: 'ck-heading_heading3' },
           { model: 'heading4', view: 'h4', title: 'Heading 4', class: 'ck-heading_heading4' },
           { model: 'heading5', view: 'h5', title: 'Heading 5', class: 'ck-heading_heading5' },
           { model: 'heading6', view: 'h6', title: 'Heading 6', class: 'ck-heading_heading6' }
         ]
       },
       ckfinder: {
    	   // 이미지 업로드 경로
    	   uploadUrl: '${contextPath}/blog/imageUpload.do'
         }
	   })
	   .catch(err => {
		   console.log(err)
	   });
  }
   
   fnCkeditor();
  </script>

<%@ include file="../layout/footer.jsp" %>