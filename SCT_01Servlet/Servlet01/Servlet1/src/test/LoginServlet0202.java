package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet0202")
public class LoginServlet0202 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet0202() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html;utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		String tel = (String) session.getAttribute("tel");
		String name = (String) session.getAttribute("name");
		String bir = (String) session.getAttribute("bir");
		
		PrintWriter out = response.getWriter();

		out.println("<html>");

		out.println("<head><title>������Ϣ</title></head>");
		
		out.println("<body>");
		out.println("ѧ��:" + tel + "</br>");
		out.println("����:" + bir + "</br>");
		out.println("����:" + name + "</br>");
		/*String[] sex = request.getParameterValues("sex");
		for (String string1 : sex) {

			out.println("�Ա�:" +string1+ "</br>");
		}

		String[] active = request.getParameterValues("active");

		out.println("����:" +"</br>");
		for (String string : active) {
			out.println( string);

		}*/

		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
