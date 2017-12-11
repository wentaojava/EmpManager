/**
 * 
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmpDao;
import Entity.Emp;

/**
 * @author Administrator
 *��ѯԱ���� /find.emp
 *����Ա���� /add.emp
 */
public class EmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�жϷ���·������������
		String path=request.getServletPath();
		if("/find.emp".equals(path)){
			findEmp(request,response);
		}else if(path.equals("/add.emp")){
			addEmp(request,response);
		}else{
			throw new RuntimeException("���޴�ҳ");
		}
	}

	//��ѯԱ��
	protected void findEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		List<Emp> list=dao.findAll();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter p=response.getWriter();
		p.println("<a href='addEmp.html'>����</a>");
		p.println("<table border='1' cellspacing='0' width='30%'>");
		p.println("<tr>");
		p.println("   <td>���</td>");
		p.println("   <td>����</td>");
		p.println("   <td>����</td>");
		p.println("   <td>����</td>");
		p.println("</tr>");
		if(list!=null){
			for(Emp e:list){
				p.println("<tr>");
				p.println("   <td>"+e.getEmpno()+"</td>");
				p.println("   <td>"+e.getName()+"</td>");
				p.println("   <td>"+e.getJob()+"</td>");
				p.println("   <td>"+e.getSal()+"</td>");
				p.println("</tr>");
			}
		}
		p.println("</table>");
		p.close();	
	}
	
	//���Ա��
	protected void addEmp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String empName=req.getParameter("empName");
		String empJob=req.getParameter("empJob");
		float empSal=new Integer(req.getParameter("empSal"));
		Emp emp=new Emp();
		emp.setName(empName);;
		emp.setJob(empJob);
		emp.setSal(empSal);
		EmpDao e=new EmpDao();
		e.saveEmp(emp);
		//�ض���
		res.sendRedirect("find.emp");
	}
}
