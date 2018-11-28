package org.tektutor;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("withdraw")
public class WithdrawController {
	
	WithdrawService withdrawService= new WithdrawService();
	
	@PUT
	@Path("{accountNo}/{amount}")
	@Produces(MediaType.APPLICATION_JSON)
	public int withdraw(@PathParam("accountNo") int accountNo, @PathParam("amount") double amount) throws SQLException{
		return withdrawService.withdraw(accountNo, amount);
	}
		 
}
