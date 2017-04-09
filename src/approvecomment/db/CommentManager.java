package approvecomment.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentManager {

	 private Connection connection;
	 
	 
	 public CommentManager() {
	        connection = Database.getConnection();
	    }
	 
	 public int getOccurencesforUser(String username){
		 int counter=0;
		   try {
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT( * ) AS counter from  comments where user = ?");
         preparedStatement.setString(1, username);
         ResultSet rs = preparedStatement.executeQuery();
         while (rs.next()) {
         		counter = Integer.parseInt(rs.getString("counter"));
         }
		   } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return counter;
	 }
	 public boolean createComment(Comment comment){
	        Boolean b=false;
	              
	        try {
	            System.out.println("add comment start");
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into comments(comment, user) values (?, ?)");
	            // Parameters start with 1
	            preparedStatement.setString(1, comment.getComment());
	            preparedStatement.setString(2, comment.getUser());
	            preparedStatement.executeUpdate();
	             System.out.println("add preparedStatement end");
	             b=true;

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return b;
	    }
}
