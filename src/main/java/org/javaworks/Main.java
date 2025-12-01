package org.javaworks;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class Main {
    /*
    Prevent SQL Injection
     */
    public static void main(String[] args) throws Exception {
        try {
            //Step 1: Download the jar file and add it to libraries of your project(IntelliJ)
            Class.forName("com.mysql.cj.jdbc.Driver");

            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.password");

            Connection con = DriverManager.getConnection(url, user, pass);

            Statement stmt = con.createStatement();
            String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, 5000);
            ps.setInt(2, 2);
            ps.executeUpdate();
            ResultSet rs = stmt.executeQuery("SELECT * FROM accounts");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                        rs.getString("name") + " - " +
                        rs.getDouble("balance"));
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}