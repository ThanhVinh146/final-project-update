package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import sqlConnection.Dbconnection;

public class CategoryDao {
	public List<Category> getAllCategories() throws SQLException {
		Connection connection=Dbconnection.makeConnection();
		Statement stmt= connection.createStatement();
	    String SQL="SELECT * FROM category order by priority ";

	    ResultSet resultSet=stmt.executeQuery(SQL);

	    List<Category> list=new ArrayList<Category>();

	    while (resultSet.next()){
	        int id=resultSet.getInt("id");
	        String name=resultSet.getString("name");
	        int priority=resultSet.getInt("priority");
	        
	        Category category=new Category(id,name,priority);
	        list.add(category);}
	    return list;

}}
