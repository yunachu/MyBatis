package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MDBoardDao;
import com.vo.MDBoardVo;

/**
 * Servlet implementation class MDBoardServlet
 */
@WebServlet("/MDBoardServlet")
public class MDBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MDBoardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		dual(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		dual(request, response);
	}

	private void dual(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("<<<"+command);
		// 서비스와 연결해야하는데 너무 간단한 게시판이라 그냥 다오 연결
		MDBoardDao dao = new MDBoardDao();
		PrintWriter out = response.getWriter();

		if (command.equals("write")) {
			System.out.println("[글 작성하기]");
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			MDBoardVo vo = new MDBoardVo(writer, title, content);

			int res = dao.insert(vo);
			if (res > 0) {
				out.println("<script>");
				out.println("alert('글 등록 성공!');");
				out.println("location.href = 'boardlist.jsp';");
				out.println("</script>");

			} else {
				out.println("<script>");
				out.println("alert('글 등록 실패...');");
				out.println("location.href = 'boardwrite.jsp';");
				out.println("</script>");
			}

		} else if (command.equals("update")) {
			
			System.out.println("[글 수정하기]");
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title"); 
			String content = request.getParameter("content"); 
			MDBoardVo vo = new MDBoardVo(seq, title, content);

			int res = dao.update(vo);
			if(res>0){
				out.println("<script>");
				out.println("alert('글 수정 성공!');");
				out.println("location.href = 'boardlist.jsp';");
				out.println("</script>");	
			}else {
				out.println("<script>");
				out.println("alert('글 수정 실패...');");
				out.println("location.href = 'boarddetail.jsp?seq="+seq+";");
				out.println("</script>");
			}
			
		}  else if (command.equals("delete")) {
			System.out.println("[글 삭제하기]");
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			int res = dao.delete(seq);

			if(res>0){
				out.println("<script>");
				out.println("alert('글 삭제 성공!');");
				out.println("location.href = 'boardlist.jsp';");
				out.println("</script>");	
			}else {
				out.println("<script>");
				out.println("alert('글 삭제 실패...');");
				out.println("location.href = 'boardlist.jsp';");
				out.println("</script>");
			}			
			dao.delete(seq);
		} else if (command.equals("muldel")) {
			System.out.println("[글 복수삭제하기]");
			String[] seq = (request.getParameterValues("chk"));

			if(seq==null || seq.length==0){
				out.println("<script>");
				out.println("alert('삭제할 글을 1개 이상 선택해 주세요');");
				out.println("location.href = 'boardlist.jsp';");
				out.println("</script>");
			}else {
				int res = dao.multiDelete(seq);
				if(res == seq.length){
					out.println("<script>");
					out.println("alert('체크된 글 삭제 성공!');");
					out.println("location.href = 'boardlist.jsp';");
					out.println("</script>");	
				}else {
					out.println("<script>");
					out.println("alert('체크된 글 삭제 실패');");
					out.println("location.href = 'boardlist.jsp';");
					out.println("</script>");
				}
			}
		}

	}
}
