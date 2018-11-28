package org.tektutor;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("trainings")
public class TrainingController {
	
	TrainingService trainingService= new TrainingService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Training> getTrainings() {
		 List<Training> listOfTrainings= trainingService.getAllTrainings();
		 return listOfTrainings;
	}
		
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Training getTrainingById(@PathParam("id") int id) {
	        return trainingService.getTraining(id);
	}	 

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Training addTraining(Training training) throws SQLException{
		return trainingService.addTraining(training);
	}
		 
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public int updateTraining(Training training) throws SQLException{
		return trainingService.updateTraining(training);
	}
		 
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteTraining(@PathParam("id") int id) throws SQLException{
		trainingService.deleteTraining(id);
	}
}
