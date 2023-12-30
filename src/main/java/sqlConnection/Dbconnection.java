package sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {
    public static Connection makeConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/be5_final_project",
                    "vinhcute146","Vinhcute146");
            return conn;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}

	