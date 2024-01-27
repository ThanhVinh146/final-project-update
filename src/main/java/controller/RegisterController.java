package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		
		User user = new User(username, password, gender, "");
		
		for (String hobby : hobbies) {
			if (user.getHobby().isEmpty()) {
				user.setHobby(hobby);
			} else {
				user.setHobby(user.getHobby() + ", + hobby");
			}
		}
		try {
			userDAO.registerNewAccount(user);
			if (user == null) {
	            request.setAttribute("errorMessage", " username already exists.");
	            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
	            rd.forward(request, response);
	        } else {
	            response.sendRedirect("login.jsp");
	        }
	    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
