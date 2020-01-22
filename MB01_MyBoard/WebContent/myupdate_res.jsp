<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>    
<%@ page import ="com.my.vo.MyBoardVo" %>
<%@ page import ="com.my.dao.MyBoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int myno = Integer.parseInt(request.getParameter("myno"));
	String mytitle = request.getParameter("mytitle");
	String mycontent = request.getParameter("mycontent");
	
	MyBoardVo vo = new MyBoardVo(myno, mytitle, mycontent);
	MyBoardDao dao = new MyBoardDao();
	
	int res = dao.update(vo);
	if(res>0){
%>
	<script type="text/javascript">
	alert("글 수정에 성공하였습니다.");
	location.href="selectone.jsp?myno=<%=vo.getMyno() %>";
	</script>
	
<%}else{ %>

	<script type="text/javascript">
	alert("글 수정에 실패하였습니다.");
	location.href="myupdate.jsp?myno=<%=vo.getMyno() %>";
	</script>
	
<%} %>
</body>
</html>