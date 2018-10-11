package com.string.calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.string.calculator.service.impl.AdditionCalculationEngineServiceImpl;
import com.string.calculator.service.impl.DivisionCalculationEngineServiceImpl;
import com.string.calculator.service.impl.MultiplicationCalculationEngineServiceImpl;
import com.string.calculator.service.impl.PowerCalculationEngineServiceImpl;
import com.string.calculator.service.impl.SubtractionCalculationEngineServiceImpl;

public class CalculationEngineService {

	public static final List<Character> OPERAND_CHAR_LIST = Arrays.asList('+', '-', '/', '*', '^');
	public static final List<Character> NUMERICAL_CHAR_LIST = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', '.');

	/**
	 * Engine Function to perform operation on an Expression. BODMAS rule is
	 * followed to solve the equation This function is a must to be override by
	 * the child classes so that they can perform functionality specific
	 * 
	 * @param expression
	 *            The expression on which the operand execution is to be
	 *            performed
	 * @param lengthOfExpression
	 *            length of the provided expression
	 * @param positionOfOperand
	 *            first position of the operand.
	 * @return the output expression post the calculation being done, replacing
	 *         the multiple brackets enclosed
	 */
	public String calculateOperandExpression(String expression, int lengthOfExpression, int positionOfOperand) {
		return expression;
	};

	/**
	 * Actual Calculation Engine is invoked in here. Only the valid expressions
	 * will be passed as in input. The code follows B.O.D.M.A.S rule which says,
	 * solve brackets, then exponential/power/of functions, followed by
	 * Division, Multiplication, Addition, Subtraction in order respectively.
	 * 
	 * @param expression
	 *            - A Valid Expression string on which calculations will be
	 *            performed.
	 * @return - Output value as a String so that it can be stored in the map
	 *         against the key representing order of insertion of a valid
	 *         expression, which also contains "Invalid Expression" as a value
	 *         to the key which is the order of insertion of an invalid
	 *         expression.
	 */
	public String invokeCalculationEngine(String expression) {

		int lengthOfExpression = expression.length();
		System.out.println("supplied expression is " + expression);
		//int position = 0;
		int positionOfPow = 0;
		int positionOfAdd = 0;
		int positionOfSubtract = 0;
		int positionOfMultiply = 0;
		int positionOfDivide = 0;
		//int positionOfOpenBracket = 0;
		//int positionOfClosedBracket = 0;
		//positionOfOpenBracket = expression.indexOf('(');
		//int lastPositionOfOpenBracket = expression.lastIndexOf('(');
		for (int s = 0; s < lengthOfExpression; s++) {
			if ((s + 1) == lengthOfExpression) {
				break;
			}
			//char presentChar = expression.charAt(s + 1);
			// if(NUMERICAL_CHAR_LIST.contains(presentChar)) {
			positionOfPow = expression.indexOf('^');
			positionOfDivide = expression.indexOf('/');
			positionOfMultiply = expression.indexOf('*');
			positionOfAdd = expression.indexOf('+');
			positionOfSubtract = expression.indexOf('-');

			String outputExpression = "";
			if (!(positionOfPow == -1 || positionOfPow == 0)) {
				PowerCalculationEngineServiceImpl exponentEngine = new PowerCalculationEngineServiceImpl();
				// outputExpression = calculatePower(expression,
				// lengthOfExpression, positionOfPow);
				outputExpression = exponentEngine.calculateOperandExpression(expression, lengthOfExpression,
						positionOfPow);
				System.out.println(outputExpression);
				positionOfPow = outputExpression.indexOf('^');
				/*
				 * if(positionOfPow!=-1){ lengthOfExpression =
				 * outputExpression.length(); outputExpression =
				 * calculatePower(expression, lengthOfExpression,
				 * positionOfPow); } else { positionOfDivide =
				 * outputExpression.indexOf('/'); }
				 */
			} else if (!(positionOfDivide == -1 || positionOfDivide == 0)) {
				DivisionCalculationEngineServiceImpl divisionEngine = new DivisionCalculationEngineServiceImpl();
				// outputExpression = calculateDivision(expression,
				// lengthOfExpression, positionOfDivide);
				outputExpression = divisionEngine.calculateOperandExpression(expression, lengthOfExpression,
						positionOfDivide);
				System.out.println(outputExpression);
			} else if (!(positionOfMultiply == -1 || positionOfMultiply == 0)) {
				MultiplicationCalculationEngineServiceImpl multiplicationEngine = new MultiplicationCalculationEngineServiceImpl();
				/*
				 * outputExpression = calculateMultiplication(expression,
				 * lengthOfExpression, positionOfMultiply);
				 */
				outputExpression = multiplicationEngine.calculateOperandExpression(expression, lengthOfExpression,
						positionOfMultiply);
				System.out.println(outputExpression);
			} else if (!(positionOfAdd == -1 || positionOfAdd == 0)) {
				AdditionCalculationEngineServiceImpl additionEngine = new AdditionCalculationEngineServiceImpl();
				// outputExpression = calculateAddition(expression,
				// lengthOfExpression, positionOfAdd);
				outputExpression = additionEngine.calculateOperandExpression(expression, lengthOfExpression,
						positionOfAdd);
				System.out.println(outputExpression);
			} else if (!(positionOfSubtract == -1 || positionOfSubtract == 0)) {
				SubtractionCalculationEngineServiceImpl subtractionEngine = new SubtractionCalculationEngineServiceImpl();
				// outputExpression = calculateSubtraction(expression,
				// lengthOfExpression, positionOfSubtract);
				outputExpression = subtractionEngine.calculateOperandExpression(expression, lengthOfExpression,
						positionOfSubtract);
				System.out.println(outputExpression);
			} else {
				outputExpression = expression;
				s = lengthOfExpression - 1;
				break;
			}
			System.out.println("Expression is " + expression + " with length as " + lengthOfExpression);
			expression = outputExpression;
			lengthOfExpression = outputExpression.length();
			System.out.println(
					"Expression after reassignement is " + expression + " with length as " + lengthOfExpression);
			s = 0;
			// }
		}
		return expression;
	}

	/**
	 * This function is to start the calculation engine. It first checks if the
	 * Passed test case string is a Valid or Invalid String. If a Valid String
	 * expression is found, it is then passed on the calculation Engine. If an
	 * invalid string expression is found it is then not passed into the engine.
	 * For Valid expression, its occurrence order (as provided by user) is
	 * stored as key bearing the value of the solved expression i.e. the end
	 * result. For Invalid expression, its occurrence order is stored as key
	 * bearing the string "Invalid Expression" as value
	 * 
	 * @param testCasesNum
	 *            - No. of Test cases which will be passed by the user.
	 * @param outputMap
	 *            - A TreeMap to store the end result in the same order as
	 *            provided by user. The value to any key is either the solved
	 *            value for the expression (in case of Valid expression String)
	 *            or "Invalid Expression" (in case of Invalid expression String)
	 * @param testCasesArr
	 *            - The array of the read test cases provided by the user. This
	 *            will contain expressions on which Validations and calculations
	 *            (if Valid) have to be performed
	 */
	public void startCalculationEngine(int testCasesNum, Map<Integer, String> outputMap, String[] testCasesArr) {
		for (int i = 0; i < testCasesNum; i++) {
			boolean validityFlag = true;
			String expression = testCasesArr[i];
			System.out.println("initial expression is " + expression);
			int index = 0;
			int openingBrackets = 0;
			int closingBrackets = 0;
			char[] expressionArr = expression.toCharArray();
			int len = expressionArr.length;
			for (char c : expressionArr) {
				System.out.println("char is " + new Character(c));
				System.out.println("index is " + index);
				if (OPERAND_CHAR_LIST.contains(c) || c == '(' || c == ')') {
					if (index != len - 1) {
						char nextChar = expressionArr[index + 1];
						System.out.println("next char in operand is " + new Character(nextChar));
						if (c == '(' & (nextChar != ')' || !OPERAND_CHAR_LIST.contains(nextChar))) {
							openingBrackets++;
						} else if (OPERAND_CHAR_LIST.contains(c)
								&& (nextChar != ')' || !OPERAND_CHAR_LIST.contains(nextChar))) {

						} else if (c == ')' && nextChar != '(') {
							closingBrackets++;
						} else if (c != ')' && nextChar == '(') {
							openingBrackets++;
						} else if (!OPERAND_CHAR_LIST.contains(nextChar) && nextChar != ')') {

						} else {
							validityFlag = false;
							// System.out.println("Invalid Expression");
							break;
						}
					} else {
						if (c == ')') {
							closingBrackets++;
						} else if (c == '(' || OPERAND_CHAR_LIST.contains(c)) {
							validityFlag = false;
							// System.out.println("Invalid Expression");
							break;
						}
					}
				} else if (NUMERICAL_CHAR_LIST.contains(c)) {
					if (index != len - 1) {
						char nextChar = expressionArr[index + 1];
						System.out.println("next char in numerical is " + new Character(nextChar));
						// System.out.println(new Character(nextChar));
						if (NUMERICAL_CHAR_LIST.contains(nextChar) || OPERAND_CHAR_LIST.contains(nextChar)
								|| nextChar == ')') {

						} else {
							validityFlag = false;
							// System.out.println("Invalid Expression");
							break;
						}
					} else if (c == '(' && OPERAND_CHAR_LIST.contains(c)) {
						validityFlag = false;
						// System.out.println("Invalid Expression");
						break;
					}
					// System.out.println("Invalid Expression");
				} else {
					validityFlag = false;
					break;
				}
				index = index + 1;
			}
			if (validityFlag && (openingBrackets == closingBrackets)) {
				// System.out.println("Starting now in Valid expression");
				outputMap.put(i, "Valid Expression");
				CalculationEngineService calculationEngine = new CalculationEngineService();
				expression = calculationEngine.invokeCalculationEngine(expression);
				// System.out.println(expression);
				outputMap.put(i, expression);
			} else {
				outputMap.put(i, "Invalid Expression");
			}

		}
	}

}
