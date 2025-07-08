package club;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Your DB credentials
            String url = "jdbc:mysql://localhost:3306/university_db";  
            String user = "root"; 
            String pass = "23092005@Uday"; 

            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Connected successfully.");
        } catch (Exception e) {
            System.out.println("❌ Connection failed.");
            e.printStackTrace();
        }
        return con;
    }
}
