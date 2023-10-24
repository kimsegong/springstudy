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
    fnSearch();
  })

  function fnSearch(){
	$('#btn_search').click(function(){
      $.ajax({
        // 요청
        type: 'get',
        url: '${contextPath}/openapi/shopping.do',
        data: $('#frm_search').serialize(),
        // 응답
        dataType: 'json',
        success: function(resData){
          $('#products').empty();
          $.each(resData.items, function(i, product){
            var tr = '<tr>';
            tr += '<td><a href="' + product.link + '">' + product.title + '</a></td>'; 
            tr += '<td><a href="' + product.link + '"><img width="200px" src="' + product.image + '" alt="' + product.title + '"></a></td>';
            tr += '<td>' + product.lprice + '</td>';
            tr += '<td>' + product.mallName + '</td>';
            tr += '</tr>';
            $('#products').append(tr);
          })
        },
        error: function(jqXHR){
          alert(jqXHR.responseText);
        }
      })
	})
  }
  
</script>
</head>
<body>

  <div>
    <form id="frm_search">
      <div>
        <label for="display">검색결과건수</label>
        <select name="display" id="display">
          <option value="10" selected>10</option>
          <option value="20">20</option>
          <option value="40">40</option>
          <option value="60">60</option>
          <option value="80">80</option>
          <option value="100">100</option>
        </select>
      </div>
      <div>     
        <input type="radio" name="sort" id="sim" value="sim" checked><label for="sim">유사도순</label>
        <input type="radio" name="sort" id="date" value="date"><label for="date">날짜순</label>
        <input type="radio" name="sort" id="asc" value="asc"><label for="asc">낮은가격순</label>
        <input type="radio" name="sort" id="dsc" value="dsc"><label for="dsc">높은가격순</label>
      </div>
      <div>
        <label for="query">검색어 입력</label>
        <input type="text" name="query" id="query"> 
        <button type="button" id="btn_search">검색</button>
      </div>
    </form>
  </div>
  <hr>
  <div>
    <table border="1">
      <thead>
        <tr>
          <td>상품명</td>
          <td>썸네일</td>
          <td>최저가</td>
          <td>판매처</td>
        </tr>
      </thead>
      <tbody id="products"></tbody>
    </table>
  </div>
  
</body>
</html>