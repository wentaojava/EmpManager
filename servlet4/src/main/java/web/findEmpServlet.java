package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class findEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ServletContext ctx=getServletContext();
		String size=ctx.getInitParameter("size");
		Integer count=(Integer)ctx.getAttribute("count");
		ctx.setAttribute("count", ++count);
		
		System.out.println(size);
		System.out.println(count);
	}

}
