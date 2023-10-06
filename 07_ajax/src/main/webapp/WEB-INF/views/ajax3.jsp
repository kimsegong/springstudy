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
<script>

  $(function(){
	  fnList();
	  fnDetail();
  })
  
  function fnList() {
	$('#btn_list').click(function(){
		$.ajax({
			// 요청
			type: 'get',
			url: '${contextPath}/ajax3/list.do',
			// 응답
			dataType: 'json',
			success: function(resData) {
			$('#list').empty();
			$.each(resData, function(i, elem){
			  $('#list').append( '<div class="row" data-name="'+elem.name+'"><span>' + elem.name + '</span>,' + elem.age + '</div>');
			})
		  }
		})
	})
}
  function fnDetail() {
	$(document).on('click', '.row', function(){
		$.ajax({
			//요청                  // (JSON 데이터를 서버로 보내기)
			type: 'post', 			// post 방식은 서버로 보낼 데이터를 요청 본문에 저장하는 방식이다.
			url : '${contextPath}/ajax3/detail.do',
			contentType: 'application/json',  // 서버로 보내는 요청 데이터의 타입
			data: JSON.stringify({  		  // 문자열 형식의 JSON 데이터를 보낸다. 파라미터로 보내는 방식이 아니다.
				    'name': $(this).data('name')
				  }),
			//응답
			dataType: 'json',
			success: function(resData){
				alert(resData.name + ',' + resData.age);
			}
		})
	})
}

</script>
</head>
<body>

  <div>
    <button id="btn_list">목록보기</button>
  </div>

  <hr>

  <div id="list"></div>
  
</body>
</html>