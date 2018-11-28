package org.tektutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepositService {

	private Connection connect= new DatabaseConnectivity().getConnection();
	
	public int deposit(int accountNo, double amount) throws SQLException {

		double balance = 0.0;

		if (amount < 0) 
			return 0;
		else {
			PreparedStatement ps1 = 
				connect.prepareStatement("select amount from account where accountNo=?");
			ps1.setInt(1, accountNo);

			ResultSet rs=ps1.executeQuery();
			if(rs.next()){
				balance = rs.getDouble(1);
			}
			balance = balance + amount;
		        PreparedStatement ps2 = connect.prepareStatement("update account set amount=? where accountNo=?");
			ps2.setDouble(1, balance);
			ps2.setInt(2, accountNo);
		
			int status=ps2.executeUpdate();
			connect.close();
			return status;
		}
	}

}
