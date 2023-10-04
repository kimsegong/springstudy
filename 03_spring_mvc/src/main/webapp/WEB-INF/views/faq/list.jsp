<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
  var addResult = '${addResult}'; // var addResult ='1'; add 성공
  								  // var addResult ='0'; add 실패
  								  // var addResult ='';  add와 상관없음
  if(addResult !== ''){
	if(addResult === '1'){
		alert('add 성공했습니다');
	}else {
		alert('add 실패했습니다');
	}
  }
</script>                         
</head>
<body>
  faq 목록
</body>
</html>