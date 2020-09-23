package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example09
 */

public class Example09_CookieSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example09_CookieSet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] animal=request.getParameterValues("animal");
		System.out.println(animal.length);
	
		// sessionScope : context 안에 모든 page에서 공유.
		// response : 쿠키 설정(저장), request : 쿠키 읽기
		
		if(animal.length!=0) {
			for(int i=0;i<animal.length;i++) {
				// key, value
				String key="animal"+(i+1);
				String value=animal[i];
				System.out.println(key+"\t"+value);
				
				// 다른 페이지에서도 cookies 배열 사용할 수 있다.
				Cookie cookie=new Cookie(key,value);
				cookie.setMaxAge(60*60*1); 	// 초*분*시*일 (60*60*24*365는 1년을 의미, 60*30은 30분, 60*60*2는 2시간)
				response.addCookie(cookie);
			}
		}

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");

		out.print("<script type='text/javascript'>");
		out.print("alert('장바구니에 담겼습니다.');");
		// 확인 누르면 원하는 페이지로 이동할 수 있도록 한다.
		out.print("location.href='http://localhost:8181/webTesting/Servlet/09_Example.html';");
		out.print("</script>");
		out.print("</body>");
		out.print("</html>");

		out.close();

		// 쿠키는 클라이언트 쿠키 폴더에 저장, 세션은 서버에 저장.
		// 사용자 쿠키 폴더 지우면 땡.
		// 크롬 > 설정 > 사이트 설정 > 쿠키 및 사이트 데이터 > 모든 쿠키 및 사이트 데이터 보기 확인
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
