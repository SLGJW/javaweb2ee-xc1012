package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet0201")
public class LoginServlet0201 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet0201() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String tel = request.getParameter("tel");
		String bir = request.getParameter("bir");
		String name = request.getParameter("name");
		String[] sex = request.getParameterValues("sex");
		String[] active = request.getParameterValues("active");
		
		HttpSession session = request.getSession(true);
		
		String id = session.getId();
		session.setAttribute("tel",tel);
		session.setAttribute("bir",bir);
		session.setAttribute("name",name);
		
		response.sendRedirect("LoginServlet0202");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
