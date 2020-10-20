<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <form action="/insertProc" method="post">
      <div class="form-group">
        <h3>Num</h3>
        <p>${detail.listNum}</p>
      </div>
      <div class="form-group">
   		<h3>Name</h3>
        <p>${detail.listName}</p>
      </div>
      <div class="form-group">
   		<h3>Date</h3>
        <p>${detail.regDate}</p>
      </div>
      
      <!-- <button type="submit" class="btn btn-primary">작성</button> -->
    </form>
</div>

</body>
</html>