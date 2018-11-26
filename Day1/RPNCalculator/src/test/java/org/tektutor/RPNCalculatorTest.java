package org.tektutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;

import static org.junit.Assert.*;

public class RPNCalculatorTest {

	private RPNCalculator rpnCalculator;
	private String rpnMathExpression;
	private double expectedResult, actualResult;

	@Given("the input is {string}")
	public void the_input_is( String strInputExpression ) {
		rpnMathExpression = strInputExpression;
	}

	@When("I evaluate the rpn math expression")
	public void i_evaluate_the_rpn_math_expression() {
		rpnCalculator = new RPNCalculator();
		actualResult = rpnCalculator.calculate( rpnMathExpression );
	}

	@Then("I expect the {string}")
	public void i_expect_the(String strExpectedResult) {
		expectedResult = Double.parseDouble ( strExpectedResult );	
		assertEquals ( expectedResult, actualResult, 0.001 );
	}
}
