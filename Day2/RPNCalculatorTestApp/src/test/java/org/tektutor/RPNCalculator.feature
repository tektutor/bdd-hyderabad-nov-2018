Feature: Develop a RPNCalculator application in Core Java.
	
	Scenario Outline: Should be able to perform addition
		Given the input is <rpnMathExpression>
		When I evaluate the rpn math expression
		Then I expect the <expectedResult>

		Examples:
			| rpnMathExpression |  expectedResult |	
			| "10 15 +"         |  "25.0"         |
			| "100 15 +"        |  "115.0"        |
			| "200 25 +"        |  "225.0"        |

	Scenario Outline: Should be able to perform subtraction 
		Given the input is <rpnMathExpression>
		When I evaluate the rpn math expression
		Then I expect the <expectedResult>

		Examples:
			| rpnMathExpression |  expectedResult |	
			| "100 15 -"        |  "85.0"         |
			| "100 25 -"        |  "75.0"         |
			| "200 35 -"        |  "165.0"        |

	Scenario Outline: Should be able to perform multiplication 
		Given the input is <rpnMathExpression>
		When I evaluate the rpn math expression
		Then I expect the <expectedResult>

		Examples:
			| rpnMathExpression |  expectedResult |	
			| "100 15 *"        |  "1500.0"         |
			| "100 25 *"        |  "2500.0"         |
			| "200 35 *"        |  "7000.0"        |

	Scenario Outline: Should be able to perform division 
		Given the input is <rpnMathExpression>
		When I evaluate the rpn math expression
		Then I expect the <expectedResult>

		Examples:
			| rpnMathExpression |  expectedResult |	
			| "100 15 /"        |  "6.666"         |
			| "100 25 /"        |  "4.0"         |
			| "200 35 /"        |  "5.714"        |

	Scenario Outline: Should be able to compute complex rpn math expression 
		Given the input is <rpnMathExpression>
		When I evaluate the rpn math expression
		Then I expect the <expectedResult>

		Examples:
			| rpnMathExpression                 |  expectedResult |	
			| "15 7 1 1 + - / 3 * 2 1 1 + + -"  |  "5.0"          |
