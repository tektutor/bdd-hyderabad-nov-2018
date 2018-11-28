package org.tektutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class Steps {

	private Mobile mobile;
	private ICamera camera;
	private boolean expectedResponse, actualResponse;
	
	@Given("The camera is functionally normally")
	public void the_camera_is_functionally_normally() {
		camera = new Camera();		
	}

	@Given("The camera is mocked")
	public void the_camera_is_mocked() {
		System.out.println ( "Camera is being mocked here ...");
		camera = mock ( ICamera.class );	
		when ( camera.ON() ).thenReturn ( true );
	}


	@When("I invoke Mobile powerOn")
	public void i_invoke_Mobile_powerOn() {
		mobile = new Mobile( camera );
		actualResponse = mobile.powerOn();
	}

	@Then("I expect the Camera to be turned On successfully.")
	public void i_expect_the_Camera_to_be_turned_On_successfully() {
		expectedResponse = true;
		assertEquals ( expectedResponse, actualResponse );
	}

	@Then("I expect the mobile powerOn to interact with camera.")
	public void i_expect_the_mobile_powerOn_to_interact_with_camera() {
		verify(camera, times(1)).ON();	
		
	}

}
