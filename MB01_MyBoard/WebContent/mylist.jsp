<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>    
<%@ page import ="com.my.vo.MyBoardVo" %>
<%@ page import ="com.my.dao.MyBoardDao" %>
<%@ page import ="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardVo> list = dao.selectAll();
%>
<body>
	<h1>list page</h1>
	<table border="1">
	<col width="50px">
	<col width="100px">
	<col width="200px">
	<col width="100px">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>내용</th>
		<th>날짜</th>
		<th>수정</th>
		<th>삭제</th>	
	</tr>
<% 
	for(int i=0;i<list.size();i++){
%>	
	<tr>
		<td><%=list.get(i).getMyno() %></td>
		<td><%=list.get(i).getMyname() %></td>
		<td><a href="selectone.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle() %></a></td>
		<td><%=list.get(i).getMycontent() %></td>
		<td><%=list.get(i).getMydate() %></td>
		<td><a href="myupdate.jsp?myno=<%=list.get(i).getMyno()%>">수정</td>
		<td><a href="mydelete.jsp?myno=<%=list.get(i).getMyno()%>">삭제</td>
	</tr>		
<% 	} %>
	<tr>
		<td colspan="7" align="right">
			<button onclick="location.href='myinsert.jsp'">글쓰기</button>
		</td>
	</tr>
		
	</table>
</body>
</html>