package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    
    public static Connection C() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3307/zhaba08?serverTimezone=UTC", "root", "");
    }
   
}
