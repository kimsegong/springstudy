<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <div>
    <div>${articleNo}</div>
    <div>${title}</div>
    <div>${content}</div>
  </div>

  <hr>
  
  <div>
    <div>${vo.articleNo}</div>
    <div>${vo.title}</div>
    <div>${vo.content}</div>
  </div>
  
  <hr>
  
  <div>
    <div>${articleVo.articleNo}</div>
    <div>${articleVo.title}</div>
    <div>${articleVo.content}</div>
  </div>
  
  <hr>
  
  <div>
    <div>${atcVo.articleNo}</div>
    <div>${atcVo.title}</div>
    <div>${atcVo.content}</div>
  </div>
 
</body>
</html>