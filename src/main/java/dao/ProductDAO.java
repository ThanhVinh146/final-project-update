package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import sqlConnection.Dbconnection;

public class ProductDAO {
	public List<Product> getLastestProducts() throws SQLException {
	Connection connection=Dbconnection.makeConnection();
	Statement stmt= connection.createStatement();
    String SQL="SELECT * FROM product where is_new=1 ";

    ResultSet resultSet=stmt.executeQuery(SQL);

    List<Product> list=new ArrayList<Product>();

    while (resultSet.next()){
        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        int price=resultSet.getInt("price");
        String imgName=resultSet.getString("img_name");
        boolean isNew=resultSet.getBoolean("is_new");
        
        Product product=new Product(id,name,price,imgName,isNew);
        list.add(product);}
    return list;
}
	public static Product getProductById(int productId) throws SQLException {
		Connection connection = Dbconnection.makeConnection();
		Statement stmt = connection.createStatement();

		String SQL = "select * from product where id = ?";

		PreparedStatement preStmt = connection.prepareStatement(SQL);
		preStmt.setInt(1, productId);

		ResultSet resultSet = preStmt.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean isNew=resultSet.getBoolean("is_new");


			Product product = new Product(id, name, price, imgName,isNew);
			return product;
		}
		return null;
	}

	// Write function to show all products
	public static List<Product> showAllProducts() throws SQLException {
		Connection connection = Dbconnection.makeConnection();
		Statement stmt = connection.createStatement();

		String showProductSQL = "select * from product";
		ResultSet resultSet = stmt.executeQuery(showProductSQL);

		List<Product> list = new ArrayList<Product>();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int price = resultSet.getInt("price");
			String imgName = resultSet.getString("img_name");
			boolean isNew=resultSet.getBoolean("is_new");
			Product product = new Product(id, name, price, imgName,isNew);
			list.add(product);
		}
		return list;
	}
}

	