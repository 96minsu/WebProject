<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h3>방명록 글쓰기</h3>

<hr align="left" width="500" style="background-color: pink;height: 10px;">
<div class="alert alert-success" style="width: 500px;">
	<b>총 ${totalCount}개의 방명록 글이 있습니다</b>
</div>
<c:set var="n" value="0"/><!-- 이미지 id 뒤에 숫자를 붙여서 고유값을 만듬 -->
<c:forEach var="dto" items="${list}">
	<table class="table table-bordered" style="width:500px;">
		<tr>
			<td>
				<b>${dto.writer}
				&nbsp;&nbsp;
				<a href="updateform?num=${dto.num}&pageNum=${currentPage}"
				style="color: gray;font-size: 0.8em;">수정</a>
				|
				<a href="deleteform?num=${dto.num}&pageNum=${currentPage}"
				style="color: gray;font-size: 0.8em;">삭제</a>
				</b>
				<span style="color: gray;font-size: 0.8em;float: right;">
					<fmt:formatDate value="${dto.writeday}"
					  pattern="yyyy-MM-dd HH:mm"/>
				</span>
				<pre>${dto.content}</pre>
				<c:forTokens var="im" items="${dto.photos}" delims=",">
					<c:set var="n" value="${n+1}"/>
					
					<button type="button" class="btn" data-toggle="modal"
					 data-target="#myModal${n}">
						<img src="save/${im}" 
						style="width: 100px;height: 100px;border: 1px solid gray;">
					</button>
				
					<!-- Modal-이미지 모달창으로 띄우기 -->
				  <div class="modal fade" id="myModal${n}" role="dialog">
				    <div class="modal-dialog">
				    
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 class="modal-title">이미지명:${im}</h4>
				        </div>
				        <div class="modal-body">
				          <img src="save/${im}">
				        </div>
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default" 
				          data-dismiss="modal">Close</button>
				        </div>
				      </div>				      
				    </div>
				  </div>				
					
				</c:forTokens>
			</td>
		</tr>
	</table>
</c:forEach>
<!-- 페이지 번호 -->
<div style="width: 500px;text-align: center;">
	<ul class="pagination">
	<!-- 이전페이지 -->
	<c:if test="${startPage>1}">
		<li><a href="list?pageNum=${startPage-1}">Prev</a></li>
	</c:if>
	<!-- 페이지 번호 -->
	 <c:forEach var="pg" begin="${startPage}" end="${endPage}">
	 	<c:if test="${currentPage==pg}">
	 		<li class="active"><a href="list?pageNum=${pg}">${pg}</a></li>
	 	</c:if>
	 	<c:if test="${currentPage!=pg}">
	 		<li><a href="list?pageNum=${pg}">${pg}</a></li>
	 	</c:if>
	 </c:forEach>	
	 
	 <!-- 다음페이지 -->
	 <c:if test="${endPage<totalPage }">
	 	<li><a href="list?pageNum=${endPage+1}">Next</a></li>
	 </c:if>
	</ul>
</div>
</body>
</html>





















