package web;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//��ȡ����·��
		System.out.println(req.getContextPath());
		System.out.println(req.getServletPath());
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURL());
	}

}
