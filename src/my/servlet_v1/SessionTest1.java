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
@WebServlet("/sessiontest1")
public class SessionTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest1() {
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
	
		//set the session idle time to be 30s, 
		//if the value you gave it is negative, which means session will never time out
		// if you set the value to be 0, the session will be invalidated immediately
		session.setMaxInactiveInterval(30);
		System.out.println(sessionId);
		
		
		// set an attribute into the session, 
		session.setAttribute("name","Alex Yan");
		session.setAttribute("title", "Java developer");

		
		// you will see session id is the same sessionTest1 and sessionTest2                // one browser instance only.
		// session makes it available for a user to share his data thru different pages
		// consider session is a "table" where the user's data are stored in a key-value pair pattern
		// different pages share the same session, which means they all can access the same "data table", session
		pw.println("<html>");
		pw.println("<body>");
		pw.println("SessionTest 1 session id is "+ sessionId);
		pw.println("<br>");
		pw.println("<a href=index.jsp>home</a>");
		pw.println("</body>");
		pw.println("</html>");
	
		
//		for(int i =0;i<30;i++)
//		{
//			try {
//				Thread.sleep(1000);
//				System.out.println(30-i+ "s");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
