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
 * Servlet implementation class SessionTest1
 */
@WebServlet("/sessiontest2")
public class SessionTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		PrintWriter pw = response.getWriter();
		System.out.println(sessionId);
		String name = (String) session.getAttribute("name");
		String title = (String) session.getAttribute("title");
		
		
		pw.println("<br>");
		pw.println("name : "+ name);
		pw.println("<br>");
		pw.println("title : "+ title);
		pw.println("<br>");
		
		pw.println("SessionTest 2 session id is "+ sessionId);
		// you will see session id is the same
		// session makes it available for a user to share his data thru different pages
		// consider session is a "table" where the user's data are stored in a key-value pair pattern
		// different pages share the same session, which means they all can access the same "data table", session
		// one browser instance only.
		pw.println("<br>");
		pw.println("<a href=index.jsp>home</>");
		pw.println("<br>");
		
		pw.println("<a href=invalidate>Invalidate session</>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
