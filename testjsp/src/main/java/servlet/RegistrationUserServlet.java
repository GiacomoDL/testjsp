package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proxima.informatica.academy.DatabaseManagerSingleton;
import proxima.informatica.academy.dto.UserDto;
import service.UserService;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class RegistrationUserServlet
 */
public class RegistrationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(DatabaseManagerSingleton.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserDto user = new UserDto();
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
//		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setDateofbirth(Date.valueOf(request.getParameter("dateofbirth")));
		user.setRegdate(Timestamp.valueOf(LocalDateTime.now()));
		user.setRole(10);
		user.setImgpath(request.getParameter("imgpath"));
		user.setNote(request.getParameter("note"));
//		if (request.getParameter("enabled") != null)
//			user.setEnabled(true);
//		else
//			user.setEnabled(false);

		if (UserService.getInstance().insert(user))
			request.getRequestDispatcher("login.jsp").forward(request, response);
		else {
			logger.debug("Errore nell'inserimento dell'utente \n" + user.toString());
			request.getRequestDispatcher("registration.html").forward(request, response);
		}
	}

}
