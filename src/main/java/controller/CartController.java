package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import dao.ProductDAO;
import entity.Cart;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO productDAO = new ProductDAO();
	CategoryDao categoryDao=new CategoryDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("ACTION");
		try {
			switch (action) {
			case "ADD_TO_CART": {

				addToCart(request, response);

				break;
			}
			case "VIEW_CART":{
				viewCart(request, response);
				break;
			}
			default:
				break;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @throws SQLException
	 * @throws NumberFormatException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, SQLException {
		String productId = request.getParameter("productId");
		
		Cart cart;
		HttpSession session=request.getSession();
		
		if(session.getAttribute("cart")==null) {
			cart=new Cart();
			cart.setItems(new HashMap<Product,Integer>());
		}else {
			cart=  (Cart) session.getAttribute("cart");
		}
		
		//Check product exist in cart
		Product product =ProductDAO.getProductById(Integer.parseInt(productId));
		if(cart.getItems().containsKey(product)) {
			int newQuantity=cart.getItems().get(product)+1;
			cart.getItems().put(product, newQuantity);
		}else {
			cart.getItems().put(product, 1);
		}
		
		
		;
		session.setAttribute("cart", cart);
		for(Map.Entry<Product,Integer> entry: cart.getItems().entrySet()) {
			System.out.print(" Product " +entry.getKey().getName());
			System.out.print(" quantity "+entry.getValue());
		}


		response.sendRedirect("Details?productId="+productId);

	}
	public void viewCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		CategoryDao categoryDAO = new CategoryDao();
		List<Category> categories = categoryDAO.getAllCategories();
				
		RequestDispatcher rd = request.getRequestDispatcher("/view-cart.jsp");
		request.setAttribute("categories", categories);
		rd.forward(request, response);
		
		
	}

}
