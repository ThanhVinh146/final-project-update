package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import entity.Product;
import entity.Cart;
import entity.OrderDetails;
import entity.User;
/**
 * Servlet implementation class CheckoutController
 */
@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Cart cart = (Cart) session.getAttribute("cart");
			OrderDAO orderDAO = new OrderDAO();
			
			int userId =  user.getId();
			Date submitDate = new Date();
			java.sql.Date sqlSubmitDate = new java.sql.Date(submitDate.getTime());			

			orderDAO.addOrder(user.getId(), sqlSubmitDate);
			int orderId = orderDAO.getOrderId(userId, sqlSubmitDate);
			
			for (HashMap.Entry<Product, Integer> CartItem : cart.getItems().entrySet()) {
				Product Product = CartItem.getKey();
				int quantity = CartItem.getValue();

				OrderDetails orderDetails = new OrderDetails();
				orderDetails.setOrderId(orderId); 
				orderDetails.setProductId(Product.getId());
				orderDetails.setPrice(Product.getPrice()); 
				orderDetails.setQuantity(quantity);
			
				orderDAO.addOrderDetail(orderDetails.getOrderId(), orderDetails.getProductId(), orderDetails.getPrice(),quantity);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
