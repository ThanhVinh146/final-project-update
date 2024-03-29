package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import sqlConnection.Dbconnection;

public class UserDAO {
	public User getUserByNameAndPassword(String username,String password) throws SQLException {
		//connect to mysql database
		Connection connection=Dbconnection.makeConnection();
        // create onject statement to execute sql query
		String SQL="SELECT * FROM user where username = ? AND password = ?";
		
		PreparedStatement stmt= connection.prepareStatement(SQL);
		stmt.setString(1,username);
		stmt.setString(2,password);
		
        //execute sql
	    ResultSet resultSet=stmt.executeQuery();


	    if (resultSet.next()){
	        int id=resultSet.getInt("id");
	        return new User(id,username,password);
	        }
	    return null;
	}
	public User registerNewAccount( User user) throws SQLException {
		Connection connection = Dbconnection.makeConnection();
		if (checkExistedEmailAndUsername(user.getUsername())==1) {
			return user=null;
		} else {
			String sqlQuery = "INSERT INTO user (username, password,gender,hobby) VALUES (?,?,?,?)";
			PreparedStatement preStmt = connection.prepareStatement(sqlQuery);

			
			preStmt.setString(1, user.getUsername());
			preStmt.setString(2, user.getPassword());
			preStmt.setString(3, user.getGender());
			preStmt.setString(4, user.getHobby());

			preStmt.executeUpdate();
			return new User();
		}

	}
	private int checkExistedEmailAndUsername( String username) throws SQLException {
		Connection connection = Dbconnection.makeConnection();
		String sqlQuery = "SELECT COUNT(*) FROM user WHERE  username=?";
		PreparedStatement preStmt = connection.prepareStatement(sqlQuery);
		
		preStmt.setString(1, username);
		ResultSet resultSet = preStmt.executeQuery();

		if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count;
        }
		return -1;
	}
	
}


