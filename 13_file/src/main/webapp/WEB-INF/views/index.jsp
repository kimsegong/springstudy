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

  <div>
  <h3>MVC업러드</h3>
   <form method="post" action="${contextPath}/upload.do" enctype="multipart/form-data">
    <div>
      <input type="file" name="files" id="files" multiple>
    </div>
    <div>
      <button type="submit">업로드</button>
    </div>
   </form>
  </div>

  <hr>
  
  <div>
    <div>
      <input type="file" id="files" multiple>
    </div>
    <div>
      <button type="button" id="btn_upload">업로드</button>
    </div>
  </div>
  <script>
  
  	fnFileCheck();
  	
  	function fnFileCheck() {
  	 $('#files').change(function(){
  		 var maxSize = 1024 * 1024 * 100;
  		 var maxSizePerFile = 1024 * 1024 * 10;
  		 var totalSize = 0;
  		 var files = this.files;
  		 for(let i =0; i < this.files.length; i++){
  		  totalSize += file[i].size;
  		  if(file.size > maxSizePerFile) {
  			  alert('각 첨부파일의 최대 크기는 10MB입니다.');
  			  $(this).val('');
  			  return;
  			}
  		 })
  		 if(totalSize > maxSize) {
  			 alert('전체 첨부파일의 최대 크기는 100MB입니다.');
  			 $(this).val('');
  			 return;
  		 }
  	 })
  	}
  	
  </script>  
  
  <hr>
  
  <script>
  	fnUpload();
  	function fnUpload() {
     $('#btn_upload').click(function(){
    	 // ajax 파일 첨부는 FormData 객체를 생성해서 data로 전달한다.
     	 var formData = new FormData();
    	 var files = $('#files')[0].files;
    	 $.each(files, function(i, elem){   		 
    	 	formData.append('files', elem);
    	 })
    	 // ajax
    	 $.ajax({
    	   // 요청
    	   type: 'post',
    	   url: '${contextPath}/ajax/upload.do',
    	   data: formData,
    	   contentType: false,
    	   processData: false,
    	   // 응답
    	   dataType: 'json',
    	   success: function(resData){ // resData === {"success": true}
    	    if(resData.success) {
    	       alert('성공');
    	    } else {
    	   	   alert('실패');
    	    } 
    	   }
    	 })
     })		
  	}
  	
  </script>
  
  
  
</body>
</html>