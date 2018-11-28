package org.tektutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainingService {

	private Connection connect= new DatabaseConnectivity().getConnection();
	
	public List<Training> getAllTrainings(){
		
		List<Training> trainings=new ArrayList<Training>();
		try {
			PreparedStatement ps = connect.prepareStatement("select * from training");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Training training =new Training();
				training.setId(rs.getInt(1));
				training.setName(rs.getString(2));
				training.setDuration(rs.getString(3));
				trainings.add(training);
			}

			connect.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

/*
		Training training = new Training();
		training.setId(1);
		training.setName("Ansible");
		training.setDuration("3 days");

		trainings.add ( training );

		training.setId(2);
		training.setName("BDD");
		training.setDuration("3 days");

		trainings.add ( training );
*/
		return trainings;
	}

	public Training getTraining(int id) {

		Training training = new Training();

		try {
			PreparedStatement ps= connect.prepareStatement("select * from Training where id=?");
			ps.setInt(1, id );
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				training.setId(rs.getInt(1));
				training.setName(rs.getString(2));
				training.setDuration(rs.getString(3));
				
			}
			rs.close();
			connect.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return training;

	}

	public Training addTraining(Training training) throws SQLException{
		PreparedStatement ps = connect.prepareStatement("insert into  Training(id,Name,Duration) values(?,?,?);");

		ps.setInt(1, training.getId());
		ps.setString(2, training.getName());
		ps.setString(3, training.getDuration());

		int status=ps.executeUpdate();

		System.out.println(status);

		ps.close();
		connect.close();

		return training;
	}

	public int updateTraining(Training training) throws SQLException {

		if (training.getId()<0) 
			return 0;
		else {
			PreparedStatement ps = 
				connect.prepareStatement("update Training set Name=?, duration=? where id=?");
			ps.setString(1, training.getName());
			ps.setString(2, training.getDuration());
			ps.setInt(3, training.getId());
		
			int status=ps.executeUpdate();
			connect.close();
			return status;
		}
	}

	public void deleteTraining(int id) throws SQLException{
		PreparedStatement ps=connect.prepareStatement("delete from Training where id=?");
		ps.setInt(1, id);
		
		int status=ps.executeUpdate();
		System.out.println(status);
		connect.close();
	}

}
