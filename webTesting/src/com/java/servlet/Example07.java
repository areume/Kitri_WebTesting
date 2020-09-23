package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Example07
 */

/**
 * @author : 김아름
 * @date   : 2020. 6. 8.
 * @description : 다른 서버 페이지로 이동. response.sendRedirect("URL/URI");
 */

public class Example07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example07() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response 객체
		// 문서타입, 한글 : setContentType() 설정 : ("text/html;charset=utf-8")
		// 출력 : getWriter();
		// 쿠키 저장(설정) 기능, 헤더 설정(파일 업로드 시) 기능
		// 페이지 이동 : sendRedirect
		
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		System.out.println(id+"\t"+pwd);
		
		// DB랑 연동해야 한다.
		String dbId="abc123";
		String dbPwd="abc123";
		
		// 같은 패키지 안에서는 URL, URI 모두 가능하다.
		// 입력받은 데이터를 공유하고 싶으면 get 방식으로 받아와야 한다.
		if(id.equals(dbId) && pwd.equals(dbPwd)) {
			response.sendRedirect("/webTesting/com/java/servlet/Example07_Success");
			
		}else {
			response.sendRedirect("/webTesting/com/java/servlet/Example07_Fail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
