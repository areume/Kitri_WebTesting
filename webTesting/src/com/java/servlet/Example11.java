package com.java.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Example11
 */

public class Example11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example11() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		// 세션 생성시간. (단위 : 1/1000 초)
		long createTime=session.getCreationTime();	 // 시간관련된 함수는 초단위인 경우가 많다.
				
		// 세션 마지막 접근시간. (단위 : 1/1000 초)
		long lastTime=session.getLastAccessedTime();
		
		// 마지막 접근시간-생성시간 = 사이트에 머문시간. (단위 : 분)
		long userTime=(lastTime-createTime)/(1000*60);
		
		Date date=new Date(createTime);
		System.out.println("생성 시간 : "+createTime+"\t"+date.toString());
		System.out.println("접근 시간 : "+lastTime+"\t"+new Date(lastTime).toString());
		System.out.println("머문 시간 : "+userTime+"분");
		
//		if(userTime > 5) {
//			session.invalidate();
//		}
		
//		int max=session.getMaxInactiveInterval()/60;  // 설정된 시간 확인.
//		System.out.println(max);
		
		// 액션이 없을 경우 세션 시간 설정으로 자동 종료.
		session.setMaxInactiveInterval(50);	// 시간이 부여되지 않으면 자동으로 서버가 30분 부여.
		
		if(request.isRequestedSessionIdValid()) {
			System.out.println("세션 아이디가 유효합니다.");
		}else {
			System.out.println("세션 아이디가 유효하지 않습니다.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
