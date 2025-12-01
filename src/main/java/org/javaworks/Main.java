package org.javaworks;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class Main {
    /*
    Maven is a build automation and dependency management tool for Java.
    Maven Mainly Helps With:
    -> Project Structure (standard folder format)
    -> Dependencies (automatic download of libraries)
    -> Build & Packaging (mvn package → creates .jar)
    -> Plugins (compiler, test, packaging, reporting)
    -> Versioning & reproducible builds
     */
    public static void main(String[] args) throws Exception {
        try {
            //Step 1: Place the dependency in pom.xml(Loading th driver class)
            Class.forName("com.mysql.cj.jdbc.Driver");

            Properties props = new Properties();

            //Create a config file with info regarding your username and password for security
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.password");

            //Step 2: Create a connection object
            Connection con = DriverManager.getConnection(url, user, pass);

            //Step 3: Create a statement object
            Statement stmt = con.createStatement();
            String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, 5000);
            ps.setInt(2, 2);

            //Step 4: Execute the query and grab the result set
            ps.executeUpdate();
            ResultSet rs = stmt.executeQuery("SELECT * FROM accounts");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                        rs.getString("name") + " - " +
                        rs.getDouble("balance"));
            }

            //Step 5: Close the connection
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}