package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	UserDAO userDao=new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String action = request.getParameter("action");
			if (action != null) {

				switch (action) {
				case "LOG_IN": {
					login(request, response);
					break;
				}

				case "LOG_OUT": {
					logout(request, response);
					break;
				}
				default:{
					break;
				}
				}
				}}
			
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

		
	
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		User user;

			
			user = userDao.getUserByNameAndPassword(username,password);
			if(user==null){
				//login failed-> send back to login
				RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}else{
				//login success-> send to index.jsp
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("Home");
			
			}
		
	}
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("Home");
	}
	
		
	
		
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
