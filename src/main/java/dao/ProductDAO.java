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
	public List<Product> getProductsByCategoryID(String categoryId) throws SQLException {
		//connect to mysql database
		Connection connection=Dbconnection.makeConnection();
        // create onject statement to execute sql query
		String SQL="SELECT * FROM product where category_id = ?";
		
		PreparedStatement stmt= connection.prepareStatement(SQL);
		stmt.setString(1,categoryId);
		
        //execute sql
	    ResultSet resultSet=stmt.executeQuery();

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
			int quantity=resultSet.getInt("quantity");
			String description = resultSet.getString("description");


			Product product = new Product(id,name,price,imgName,quantity,description);
			return product;
		}
		return null;
	}

	// Write function to show all products
	public List<Product> getAllProducts() throws SQLException {
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
	public List<Product> search(String value) throws SQLException {
		//connect to mysql database
		Connection connection=Dbconnection.makeConnection();
        // create onject statement to execute sql query
		String SQL="SELECT * FROM product where name like ?";
		
		PreparedStatement stmt= connection.prepareStatement(SQL);
		stmt.setString(1,"%" + value + "%");
		
        //execute sql
	    ResultSet resultSet=stmt.executeQuery();

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
}

	