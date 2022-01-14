package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController extends Main {
	
	public void initialize(URL location, ResourceBundle resources) {
		String sql = "Select count(*) From cinema";
		String sql2 = "SELECT ville, nom, count(*) from seance"; 
		
		try {
			
	        PreparedStatement stat = conn.prepareStatement(sql);
	        ResultSet rs = stat.executeQuery();
	         
	        String totalLocation = "";
	        
	        while(rs.next()) { 
				totalLocation = rs.getString(1);
	        }
	        
	        
	        stat = conn.prepareStatement(sql2);
	        rs = stat.executeQuery();
	        String ville = "", cinema_nom = "";
	        String nb_cinema = "";
	        
	        while(rs.next()) { 
	        	ville = rs.getString(1);
	        	cinema_nom = rs.getString(2);
	        	nb_cinema = rs.getString(3);
	        	
	        	break;
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
