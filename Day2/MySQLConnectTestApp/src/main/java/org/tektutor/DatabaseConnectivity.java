package org.tektutor;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectivity {

	private Connection connection = null;

	public Connection getConnection() {  

        try {  
        	Class.forName("com.mysql.jdbc.Driver").newInstance();  
            	connection=DriverManager.getConnection("jdbc:mysql://localhost/trainings?"+"user=root&password=root&useSSL=false");  
            	System.out.println("connected");
        }catch(Exception e) {
		System.out.println(e);
	}
  
        return connection;  
    }  
}
