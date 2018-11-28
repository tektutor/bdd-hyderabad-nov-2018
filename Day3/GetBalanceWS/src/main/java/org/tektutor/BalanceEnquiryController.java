package org.tektutor;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("getBalance")
public class BalanceEnquiryController {
	
	BalanceEnquiryService balanceEnquiryService= new BalanceEnquiryService();
	
	@GET
	@Path("{accountNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public double getBalanceEnquiryByAccountNo(@PathParam("accountNo") int accountNo) {
	        return balanceEnquiryService.getBalance(accountNo);
	}	 

}
