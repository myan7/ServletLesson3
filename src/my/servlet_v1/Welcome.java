package my.servlet_v1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		instead of using request.getParameter from the Valid servlet, I want to retrieve the data from session
//		String name = request.getParameter("username");
//		String psw = request.getParameter("password");
		
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		String sessionId = (String) session.getAttribute("sessionid");
		// this is for preventing illegal login by directly go to welcome page.
		if(name == null || password == null)
		{
			response.sendRedirect("login");
		}
		
		System.out.println(name);
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<p>Welcome! </p>");
		pw.append(name).append(" "+password);
		pw.println("<br>");
		pw.append(sessionId);
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
