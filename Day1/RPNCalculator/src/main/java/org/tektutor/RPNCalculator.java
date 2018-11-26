package org.tektutor;

import java.util.Stack;

public class RPNCalculator {

	private Stack<Double> numberStack;
	private double firstNumber, secondNumber, result;

	public RPNCalculator() {
		numberStack = new Stack<Double>();
		firstNumber = secondNumber = result = 0.0;
	}

	private void extractOperands() {
		secondNumber = numberStack.pop();
		firstNumber = numberStack.pop();
	}

	private boolean isMathOperator( String strMathOperator ) {
		String mathOperators = "+-*/";
		return mathOperators.contains(strMathOperator);
	}
	
	public double calculate( String strRPNMathExpression ) {

		String[] rpnTokens = strRPNMathExpression.split ( " " );
		IMathOperation mathOperation = null;

		for ( String token : rpnTokens ) {
			
			if ( isMathOperator ( token ) ) {
				extractOperands();
				mathOperation = MathFactory.getMathObject( token );
				result = mathOperation.calculate(firstNumber, secondNumber);
				numberStack.push ( result );

			}
			else {
				numberStack.push ( Double.parseDouble( token ) );
			}
		}

		return numberStack.pop();
	}

}
