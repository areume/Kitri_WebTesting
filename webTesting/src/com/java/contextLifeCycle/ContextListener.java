package com.java.contextLifeCycle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author : 김아름
 * @date   : 2020. 6. 10.
 * @description : 웹 애플리케이션 (webTesting/context) 생명주기
 * 
 * [web.xml 등록]
 * <listener>
 *   <listener-class>com.java.contextLifeCycle.ContextListener</listener-class>
 * </listener>
 */

public class ContextListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//System.out.println("contextInitialized---------------------------------------");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//System.out.println("contextDestroyed-----------------------------------------");
	}
}
