package my.servlet_v1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Valid
 */
@WebServlet("/valid")
public class Valid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Valid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// receive the user input
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		
		if(username.equalsIgnoreCase("ming")&& password.equals("123"))
		{
			// if the user credential is valid, write it into session.
			HttpSession session = request.getSession();
			// the default session time is 30 mins, we can change it by calling this function (second)
//			session.setMaxInactiveInterval(20);
			
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			
			//this sessionId is assigned per browser which means, no matter how many tabs I opened in a sing browser, the session id will be the same
			String sessionId = session.getId();
			session.setAttribute("sessionid", sessionId);
//			response.sendRedirect("welcome?username="+ username+"&&password="+password); 
			response.sendRedirect("welcome");
		}
		else
		{
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
