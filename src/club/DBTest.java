package club;

import java.sql.*;

public class DBTest {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            System.out.println("✅ Connected successfully!");
        } else {
            System.out.println("❌ Connection failed.");
        }
    }
}
