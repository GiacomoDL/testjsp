package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private final static Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.debug("DEBUG - doPost()");
		boolean result = false;
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		result = UserService.getInstance().login(email, password);

		if (result) {
			request.getSession().setAttribute("userLoggedEmail", email);
			logger.debug("DEBUG - Accesso eseguito come " + email);
			request.getRequestDispatcher("user.jsp").forward(request, response);
		} else {
			logger.debug("Login KO");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
