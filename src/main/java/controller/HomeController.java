package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.ProductDAO;
import entity.Category;
import entity.Product;





/**
 * Servlet implementation class HomeController
 */
@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		ProductDAO productDAO = new ProductDAO();
		CategoryDao categoryDao=new CategoryDao();
		List<Product> products;
		
		String categoryID=request.getParameter("categoryId");
		String action=request.getParameter("action");
		String searchValue=request.getParameter("searchValue");
		
		// after using model data produclist
		
		
		if("SHOW_ALL".equals(action)){
		    products=productDAO.getAllProducts();
		}
		else if(categoryID!=null){
		    products=productDAO.getProductsByCategoryID(categoryID);
		}
		else if(searchValue!=null){
		    products=productDAO.search(searchValue);
		}
		else{
		    products=productDAO.getLastestProducts();
		}
		
		
		
		//send data to view
		RequestDispatcher rd= request.getRequestDispatcher("/index.jsp");
		request.setAttribute("lastestProducts", products);
		request.setAttribute("categories", categoryDao.getAllCategories());
		rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
