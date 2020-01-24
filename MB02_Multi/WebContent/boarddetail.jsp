<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>    
<%@ page import ="com.vo.MDBoardVo" %>
<%@ page import ="com.dao.MDBoardDao" %>
<%@ page import ="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
	#updateform{
		display : none;
	}
</style>
<script type="text/javascript">
 	function updateformView(){
 		$("#detailform").hide();
 		$("#updateform").show();		
 	}
 	function detailformView(){
 		$("#detailform").show();
 		$("#updateform").hide();	
 		
 	}
</script>
</head>
<body>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MDBoardDao dao= new MDBoardDao();
	MDBoardVo vo = dao.selectOne(seq);

%>

<div id ="detailform">
<h1>게시글 보기</h1>
<table border="1">
	<tr>
		<th>작성자 : </th>
		<td><%=vo.getWriter() %> </td>
	</tr>
	<tr>
		<th>작성일 : </th>
		<td><%=vo.getRegdate() %> </td>
	</tr>
	<tr>
		<th>제목 : </th>
		<td><%=vo.getTitle() %> </td>
	</tr>
	<tr>
		<th>내용 : </th>
		<td>
			<textarea rows="10" cols="60" readonly="readonly"><%=vo.getContent() %></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="수정" onclick="updateformView();">
			<input type="button" value="삭제" onclick="location.href='board?command=delete&seq=<%=seq%>'">
			<input type="button" value="목록으로" onclick="location.href='boardlist.jsp'">
		</td>
	</tr>
</table>
</div>

<div id="updateform">
<h1>글 수정하기</h1>
<form action="board?command=update" method="post">
<input type="hidden" name ="seq" value="<%=vo.getSeq() %>">
<table border="1">
	<tr>
		<th>작성자 : </th>
		<td><%=vo.getWriter() %> </td>
	</tr>
	<tr>
		<th>작성일 : </th>
		<td><%=vo.getRegdate() %> </td>
	</tr>
	<tr>
		<th>제목 : </th>
		<td><input type="text" name="title" value="<%=vo.getTitle() %>"> </td>
	</tr>
	<tr>
		<th>내용 : </th>
		<td>
			<textarea rows="10" cols="60" name="content"><%=vo.getContent() %></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="수정"/>
		<input type="button" onclick="detailformView();"value="취소"/>
		</td>
	</tr>
</table>
</form>
</div>

</body>
</html>