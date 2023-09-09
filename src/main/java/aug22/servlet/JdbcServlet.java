package aug22.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.StudentDao;
import web.vo.Student;

@WebServlet("/JdbcServlet")
public class JdbcServlet extends HttpServlet {
	
	private StudentDao dao = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init method is called");
		new StudentDao();
	}

	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		StudentDao dao = new StudentDao();
		List<Student> studs = dao.getAllStudents();
		pw.println("<h2>Details of students :</h2>");
		pw.println("<table border = 1>");
		for(Student st:studs) {
			pw.println("<tr>");
			pw.println("<td>"+st.getStuId()+"</td>");
			pw.println("<td>"+st.getFirstName()+"</td>");
			pw.println("<td>"+st.getLastName()+"</td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
	}

}
