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
  #paging a {
    margin: 10px;
  }
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>

  $(function(){
	  fnChkAll();
	  fnChkOne();
	  fnMemberRegister();
	  fnMemberList();
  })

  // 전체 선택을 클릭하면 개별 선택에 영향을 미친다.
  function fnChkAll(){
	  $('#chk_all').click(function(){
		  $('.chk_one').prop('checked', $(this).prop('checked'));
	  })
  }
  
  // 개별 선택을 클릭하면 전체 선택에 영향을 미친다.
  function fnChkOne(){
	  $(document).on('click', '.chk_one', function(){
		  var total = 0;
		  $.each($('.chk_one'), function(i, elem){
			  total += $(elem).prop('checked');
		  })
		  $('#chk_all').prop('checked', total === $('.chk_one').length);
	  })
  }
  
  // 회원 등록
  function fnMemberRegister(){
	  $('#btn_register').click(function(){
	    $.ajax({
        // 요청
        type: 'post',
        url: '${contextPath}/members',
        contentType: 'application/json',
        data: JSON.stringify({
          id: $('#id').val(),
          name: $('#name').val(),
          gender: $(':radio:checked').val(),
          address: $('#address').val()
        }),
        // 응답
        dataType: 'json',
        success: function(resData){
          console.log(resData);
        }
      })
	  })
  }
  
  // 전역변수 (모든 함수에서 사용할 수 있는 변수)
  var page = 1;
  
  // 회원 목록
  function fnMemberList(){
	  $.ajax({
		  // 요청
		  type: 'get',
		  url: '${contextPath}/members/page/' + page,
		  // 응답
		  dataType: 'json',
		  success: function(resData){
			  // 회원 목록을 테이블로 만들기
			  $('#member_list').empty();
			  $.each(resData.memberList, function(i, member){
				  var tr = '<tr>';
				  tr += '<td><input type="checkbox" class="chk_one" value="'+member.memberNo+'"></td>';
				  tr += '<td>'+member.id+'</td>';
				  tr += '<td>'+member.name+'</td>';
				  tr += '<td>'+member.gender+'</td>';
				  tr += '<td>'+member.address+'</td>';
				  tr += '<td><button type="button" class="btn_detail" data-member_no="'+member.memberNo+'">조회</button></td>';
				  tr += '</tr>';
				  $('#member_list').append(tr);
			  })
			  // 페이징
			  $('#paging').html(resData.paging);
		  }
	  })
  }
  
  // 페이지를 바꿀때마다 호출되는 fnAjaxPaging 함수
  function fnAjaxPaging(p){
	  page = p;        // 페이지 번호를 바꾼다.
	  fnMemberList();  // 새로운 목록을 가져온다.
  }

</script>

</head>
<body>

  <div>
    <h1>회원 관리하기</h1>
    <div>
      <label for="id">아이디</label>
      <input type="text" id="id">
    </div>
    <div>
      <label for="name">이름</label>
      <input type="text" id="name">
    </div>
    <div>
      <input type="radio" id="man" name="gender" value="man" checked>
      <label for="man">남자</label>
      <input type="radio" id="woman" name="gender" value="woman">
      <label for="woman">여자</label>
    </div>
    <div>
      <label for="address">주소</label>
      <select id="address">
        <option>서울</option>
        <option>경기</option>
        <option>인천</option>
      </select>
    </div>
    <div>
      <button type="button" onclick="fnInit()">초기화</button>
      <button type="button" id="btn_register">등록</button>
      <button type="button" id="btn_modify">수정</button>      
    </div>
  </div>

  <hr>
  
  <div>
    <table border="1">
      <thead>
        <tr>
          <td><input type="checkbox" id="chk_all"><label for="chk_all">전체선택</label></td>
          <td>아이디</td>
          <td>이름</td>
          <td>성별</td>
          <td>주소</td>
          <td></td>
        </tr>
      </thead>
      <tbody id="member_list"></tbody>
      <tfoot>
        <tr>
          <td colspan="6" id="paging"></td>
        </tr>
      </tfoot>
    </table>
  </div>

</body>
</html>