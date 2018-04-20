package my.servlet_v1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//make it Chinese friendly
		response.setContentType("text/html; charset=gbk");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		// get error message
		String info = (String)request.getParameter("info");
		if(info !=null)
			pw.println("<h1>Info: "+info+"</h1><br>");
		
		pw.println("<h1>login page</h1>");
		pw.println("<form action = valid method = post>");
		pw.println("Username:<input type='text' name='username'><br>");
		pw.println("Password:<input tpye='password' name='password'><br>");
		pw.println("<input type  = 'submit' value = 'login'>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
