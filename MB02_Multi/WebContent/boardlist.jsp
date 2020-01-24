<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>   

<%@ page import ="com.vo.MDBoardVo" %>
<%@ page import="com.dao.MDBoardDao"%>
<%@ page import ="java.util.List" %>
<%	
	MDBoardDao dao = new MDBoardDao();
	List<MDBoardVo> list = dao.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	//전체선택 & 해제 함수
	function allChk(bool){
		var chks = document.getElementsByName("chk");
		for(var i=0; i<chks.length; i++){
			chks[i].checked = bool;			
		}
	}
</script>
</head>
<body>
<h1>글목록</h1>
<form action="board?command=muldel" method="post" id="muldelform">
	<table border="1">
		<col width="30px">
		<col width="50px">
		<col width="100px">
		<col width="300px">
		<col width="100px">
		<tr>
			<th><input type="checkbox" name ="all" onclick ="allChk(this.checked)"/></th>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>		
		</tr>
<%
	if(list.size()==0){ //글이 없는 경우
%>	
	<tr>
		<td colspan ="5">-----글이 존재하지 않습니다-----</td>
	</tr>
	
<%}else{ 
	for(MDBoardVo vo : list){//향상된 for문
%>
	<tr>
		<td><input type="checkbox" name ="chk" value="<%=vo.getSeq()%>"/></td><!-- 여기는 체크박스에 넘겨줄 값으로 seq사용한 것 -->
		<td><%=vo.getSeq() %></td>								<!-- 여기선 출력용으로 seq사용 -->
		<td><%=vo.getWriter() %></td>
		<td><a href ="<%= request.getContextPath() %>/boarddetail.jsp?seq=<%=vo.getSeq()%>"><%=vo.getTitle()%></a></td>  <!--parameter값으로 seq도 같이 넘겨준다  -->
		<td><%=vo.getRegdate() %></td>	
	</tr>		
<%	} 
}
%>
	<tr>
	<td colspan="5">
		<input type="button" value="글쓰기" onclick="location.href='boardwrite.jsp'">
		<input type="submit" value="삭제">
	</td>
	</tr>		
	</table>
</form>

</body>
</html>