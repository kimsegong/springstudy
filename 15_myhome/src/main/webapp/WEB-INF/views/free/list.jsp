<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="자유게시판" name="title"/>
</jsp:include>
<style>
 .write {
 <button type="button" class="btn btn-secondary">Secondary</button>
 
 }
</style>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<div>
<div>
  
  <div id="write">
  <button><a href="${contextPath}/free/write.form">새글작성</a></button>
  </div>
  
</div>

<hr>

<div>
  <table border="1">
  <thead>
   <tr>
    <td>순번</td>
    <td>작성자</td>
    <td>내용</td>
    <td>작성일자</td>
   </tr>
  </thead>
    <tbody>
     <c:forEach items="${freeList}" var="free" varStatus="vs">
          <tr>
            <td>${beginNo - vs.index}</td>
            <td>${free.email}</td>
            <td>${free.contents}</td>
            <td>${free.createdAt}</td>
          </tr>        
        </c:forEach>
    </tbody>
    <tfoot>
      <tr>
       <td colspan="4">${paging}</td>
      </tr>
    </tfoot>
  </table>
</div>
</div>

<script>

  fnAddResult();
  
  const fnAddResult = () => {
  let addResult = '${addResult}';
  if(addResult !== ''){
    alert('게시글이 등록되었습니다.');
  } else {
      alert('게시글이 등록되지않았습니다.');
  }
  }
</script>

<%@ include file="../layout/footer.jsp" %>