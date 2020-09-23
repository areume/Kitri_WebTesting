package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example09_CookieGet
 */

public class Example09_CookieGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example09_CookieGet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Cookie[] cookies=request.getCookies();
		//System.out.println(cookies.length);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");

		// 쿠키 지우고, 장바구니에 넣어보고 실습해보자.
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				out.print("<h4>"+cookies[i].getName()+"&nbsp;&nbsp;"+cookies[i].getValue()+"</h4>");
			}
			
			String contextPath=request.getContextPath();
			for(int i=0;i<cookies.length;i++) {
				String imgStr=contextPath+"/img/"+cookies[i].getValue()+".jpg";
				System.out.println(imgStr);
				out.print("<img src='"+imgStr+"' width='150' height='120'>");	// 따옴표 쌍 유의하기
			}
		}else {
			out.print("<h3>장바구니 비워짐</h3>");
		}
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
