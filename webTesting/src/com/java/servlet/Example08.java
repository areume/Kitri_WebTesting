package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example08
 */

public class Example08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example08() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// include
		request.setCharacterEncoding("utf-8");
		String msg=request.getParameter("msg");
		System.out.println("Example08 : "+msg);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		request.setAttribute("name","홍길동");
		request.setAttribute("phone","010-1234-1234");
		
		RequestDispatcher rd=request.getRequestDispatcher("/com/java/servlet/Example08_Sub");
		rd.include(request,response);
		
		out.print("<hr color='red'>");
		out.print("<h4>include는 다시 돌아온다. 제어권을 넘겨주지 않는다.</h4>");
		out.print("<h5>서블릿에서 데이터는 pageScope, requestScope, sessionScope, applicationScope</h5>");
		// 페이지 스코프 : 페이지 안에서만 사용가능.
		// 리쿼스트 스코프 : 리퀘스트 객체가 넘어와 사용되는 것.
		// 세션 스코프 : 한번 선언하면 JSP 프로젝트 내에서 모두 사용할 수 있다. - static과 비슷하다.
		// 애플리케이선 스코프 : 
		
		
		out.print("</body>");
		out.print("</html>");
	
		out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward
		request.setCharacterEncoding("utf-8");
		String msg=request.getParameter("msg");
		System.out.println("Example08 : "+msg);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		request.setAttribute("name","홍길동");
		request.setAttribute("phone","010-1234-1234");
		
		RequestDispatcher rd=request.getRequestDispatcher("/com/java/servlet/Example08_Sub");
		rd.forward(request,response);
		
		out.print("<hr color='red'>");
		out.print("<h4>forward는 다시 돌아오지 않는다. 제어권을 넘겨준다.</h4>");
		out.print("<h5>서블릿에서 데이터는 pageScope, requestScope, sessionScope, applicationScope</h5>");		
		
		out.print("</body>");
		out.print("</html>");
	
		out.close();
	}

}
