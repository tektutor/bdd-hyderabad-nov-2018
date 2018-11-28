package org.tektutor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.restassured.*;
import io.restassured.specification.*;
import io.restassured.response.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FundTransfer {

	private String baseURL;
	private String balanceEnquiryResourceURL;
	private String depositResourceURL;
	private String withdrawResourceURL;

	public FundTransfer() {

		baseURL = "http://localhost:8080";
		balanceEnquiryResourceURL = baseURL + "/tektutor-getbalance-ws-1.0.0/bank/getBalance/";
		depositResourceURL = baseURL + "/tektutor-deposit-ws-1.0.0/bank/deposit";
		withdrawResourceURL = baseURL + "/tektutor-withdraw-ws-1.0.0/bank/withdraw";

	}

	public double getBalance(int accountNo) {
	    String strBalance = "";
	    double balance = 0.0;
	    try {
		balanceEnquiryResourceURL = balanceEnquiryResourceURL + accountNo;

		URL url = new URL(balanceEnquiryResourceURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		while ((strBalance = br.readLine()) != null) {
			balance = Double.parseDouble ( strBalance );
		}

		conn.disconnect();
	    } 
            catch (Exception e) {
		e.printStackTrace();
	    } 
            return balance;
	}

	public boolean deposit(int accountNo, double amount ) {
	    try {
		depositResourceURL = 
			depositResourceURL + "/" + accountNo + "/" + amount ;  

		URL url = new URL(depositResourceURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		conn.disconnect();
	    } 
            catch (Exception e) {
		e.printStackTrace();
		return false;
	    } 
            return true;

	}

	public boolean withdraw(int accountNo, double amount ) {
	    try {
		String withdrawURL = withdrawResourceURL + "/" + accountNo + "/" + amount ;

		System.out.println ( withdrawURL );

		URL url = new URL(withdrawURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		conn.disconnect();
	    } 
            catch (Exception e) {
		e.printStackTrace();
		return false;
	    } 
            return true;

	}

	public boolean transferFund( int fromAccountNo, int toAccountNo, double amountToBeTransferred )        {
		double fromAccountBalance = getBalance ( fromAccountNo );
		System.out.println ( fromAccountBalance );	

		if ( amountToBeTransferred >= fromAccountBalance ) {
			System.out.println ("Insufficient fund to transfer.");
			return false;
		}

		if ( ! withdraw ( fromAccountNo, amountToBeTransferred ) ) { 
			System.out.println ("Withdraw webservice failed to perform withdraw.");
			return false;
		}

		if ( ! deposit ( toAccountNo, amountToBeTransferred ) ) {
			System.out.println ("Deposit webservice failed to perform deposit.");
			return false;
		}

		System.out.println ("Fund " + amountToBeTransferred + " is successfully transferred from " + fromAccountNo + " to " + toAccountNo + "." );
			
		return true;
	}

	public static void main ( String args[] ) {
		boolean status = new FundTransfer().transferFund ( 100, 200, 5000.00 );	
		System.out.println ( status );
	}

}
