package approvecomment.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
   
     public static Connection getConnection() {
          try  {
        	 /* 
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
                      ("jdbc:mysql://localhost:3306/dbname",
                      "root","P@ssw0rd");
              */
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
                      ("jdbc:mysql://127.0.0.1:50846/azuredb",
                      "root","password");
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
      }
 
       public static void close(Connection con) {
          try  {
              con.close();
          }
          catch(Exception ex) {
          }
      }

}