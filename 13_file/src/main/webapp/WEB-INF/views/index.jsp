<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  .ck.ck-editor {
    max-width: 800px;
  }
  .ck-editor__editable {
    min-height: 400px;
  }
  .ck-content {
    font-size: 12px;
    color: orange;
  }
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/40.0.0/classic/ckeditor.js"></script>
<script>

  $(function(){     
    fnFileCheck();
    fnUpload();
    fnCkeditor();
  })
  
  function fnFileCheck(){
    $('.files').change(function(){
      console.log(this.files);
      $('#file_list').empty();
      var maxSize = 1024 * 1024 * 100;
      var maxSizePerFile = 1024 * 1024 * 10;
      var totalSize = 0;
      var files = this.files;
      for(let i = 0; i < files.length; i++){
        totalSize += files[i].size;
        if(files[i].size > maxSizePerFile){
          alert('각 첨부파일의 최대 크기는 10MB입니다.');
          $(this).val('');
          $('#file_list').empty();
          return;
        }
        $('#file_list').append('<div>' + files[i].name + '</div>');
      }
      if(totalSize > maxSize){
        alert('전체 첨부파일의 최대 크기는 100MB입니다.');
        $(this).val('');
        $('#file_list').empty();
        return;
      }
    })
  }
  
  function fnUpload(){
    $('#btn_upload').click(function(){
      // ajax 파일 첨부는 FormData 객체를 생성해서 data로 전달한다.
      var formData = new FormData();
      var files = $('#files').prop('files');  // var files = $('#files')[0].files;  
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
        success: function(resData){  // resData === {"success":true}
          if(resData.success){
            alert('성공');
          } else {
            alert('실패');
          }
        }
      })
    })
  }

  function fnCkeditor(){
	 
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
    	   // 업로드 경로
    	   uploadUrl: '${contextPath}/ckeditor/upload.do'
       }
	   })
	   .catch(err => {
		   console.log(err)
	   });
	  
  }
  
</script>
</head>
<body>

  <div>
    <h3>MVC 파일첨부</h3>
    <form method="post" action="${contextPath}/upload.do" enctype="multipart/form-data">
      <div>
        <input type="file" name="files" class="files" multiple>
      </div>
      <div>
        <button type="submit">업로드</button>
      </div>
    </form>
  </div>
  
  <hr>
  <div id="file_list"></div>
  <hr>
  
  <div>
    <h3>ajax 파일첨부</h3>
    <div>
      <input type="file" class="files" id="files" multiple>
    </div>
    <div>
      <button type="button" id="btn_upload">업로드</button>
    </div>
  </div>
  
  <hr>
  
  <div>
    <h3>CKEditor</h3>
    <form method="post" action="${contextPath}/add.do">
      <div>
        <textarea id="contents"></textarea>
      </div>
      <button type="submit">전송</button>
    </form>
  </div>

</body>
</html>