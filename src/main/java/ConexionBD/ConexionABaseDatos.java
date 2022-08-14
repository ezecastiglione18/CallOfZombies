package ConexionBD;

import javax.xml.transform.Result;
import java.sql.*;

public class ConexionABaseDatos {
  public static void main(String[] args){
    try {
      String jdbcURL = "jdbc:mysql://localhost:3306/CallOfZombies";
      String username = "root";
      String password = "root";
      Connection connection = DriverManager.getConnection(jdbcURL, username, password);
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("show databases;");
      System.out.println("Conectado");
    }
    catch (Error | SQLException error) {
      System.out.println(error);
    }
  }
}
