import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;

public class DatabaseConnectivity {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Name:");
        String name = br.readLine();

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sample";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        
        String query2 = "SELECT * FROM STUDENT where name = ?;";
        PreparedStatement preStat = connection.prepareStatement(query2);
        preStat.setString(1, name);
        ResultSet result = preStat.executeQuery();
        
        while(result.next()) {
            int regno = result.getInt("Roll_No");
            String name = result.getString("Name");
            String branch = result.getString("Branch");
            System.out.println("Name - " + name);
            System.out.println("Branch - " + branch);
            System.out.println("Registration number - " + regno);
        }
    }
    
}