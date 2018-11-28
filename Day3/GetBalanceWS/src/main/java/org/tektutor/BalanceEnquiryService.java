package org.tektutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BalanceEnquiryService {

	private Connection connect= new DatabaseConnectivity().getConnection();
	
	public double getBalance(int accountNo) {

		double balance = 0.0;

		try {
			PreparedStatement ps= connect.prepareStatement("select * from account where accountNo=?");
			ps.setInt(1, accountNo);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				balance = rs.getDouble(3);
			}
			rs.close();
			connect.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return balance;

	}

}
