package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Order;
import entity.OrderDetails;
import entity.Product;
import sqlConnection.Dbconnection;

public class OrderDAO {

	public void addOrder(int userId, java.sql.Date submitDate) throws SQLException {
		Connection connection = Dbconnection.makeConnection();
		PreparedStatement preStmt = null;

		String SQL = "INSERT INTO `order` (userId, submitDate) VALUES (?, ?);";
		preStmt = connection.prepareStatement(SQL);

		preStmt.setInt(1, userId);
		preStmt.setDate(2, submitDate);

		preStmt.executeUpdate();

	}
	
	public void addOrderDetail(int orderId, int productId, double price, int quantity) throws SQLException {
		Connection connection = Dbconnection.makeConnection();
		PreparedStatement preStmt = null;

		String SQL = "INSERT INTO `order_detail` (orderId, productId, price, quantity) VALUES (?, ?, ?, ?);";
		preStmt = connection.prepareStatement(SQL);

		preStmt.setInt(1, orderId);
		preStmt.setInt(2, productId);
		preStmt.setDouble(3, price);
		preStmt.setInt(4, quantity);		

		preStmt.executeUpdate();

	}
	
	public int getOrderId(int userId, Date submitDate) throws SQLException {
        Connection connection = Dbconnection.makeConnection();
        String sql = "SELECT * FROM order WHERE userId = ? and submitDate = ?";

        PreparedStatement preStmt = connection.prepareStatement(sql);
        preStmt.setInt(1, userId);
        preStmt.setDate(2, (java.sql.Date) submitDate);

        ResultSet resultSet = preStmt.executeQuery();

        if (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setUserId(resultSet.getInt("userId"));
            order.setSubmitDate(resultSet.getDate("submitDate"));

            return order.getId();
        }
        return 0;

    }

}