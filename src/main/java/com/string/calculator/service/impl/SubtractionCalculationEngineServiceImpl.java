package com.string.calculator.service.impl;

import com.string.calculator.service.CalculationEngineService;

public class SubtractionCalculationEngineServiceImpl extends CalculationEngineService {

	/**
	 * Subtraction Engine Function to perform subtraction in the expression at
	 * places wherever the '-' sign occurs. This function overrides base
	 * function of the {@com.string.calculator.service.CalculationEngine} Class
	 * which uses BODMAS rule to solve the expression equation
	 * 
	 * @param expression
	 *            The expression in which the subtraction between digits is to
	 *            be performed
	 * @param lengthOfExpression
	 *            length of the provided expression.
	 * @param positionOfSubtract
	 *            first position of the '-' sign, in the expression to be
	 *            calculated.
	 * @return the output expression post the calculation being done, replacing
	 *         the multiple brackets enclosed, with the result of the expression
	 *         on which subtraction was performed.
	 */
	public String calculateOperandExpression(String expression, int lengthOfExpression, int positionOfSubtract) {
		String outputExpression;
		double startNum = 0;
		double endNum = 0;
		int startChip = 0, endChip = 0;
		for (int start = positionOfSubtract - 1; start >= 0; start--) {
			char startChar = expression.charAt(start);
			if (!(start == 0 && startChar == '(')) {
				if (NUMERICAL_CHAR_LIST.contains(startChar) || startChar == '(' || startChar == ')') {
					if (start == 0) {
						System.out.println(start);
						String extractedString = expression.substring(start, positionOfSubtract);
						extractedString = extractedString.replace("(", "").replace(")", "");
						startNum = Double.parseDouble(extractedString);
						startChip = start;
						break;
					}
				} else {
					String extractedString = expression.substring(start + 1, positionOfSubtract);
					extractedString = extractedString.replace("(", "").replace(")", "");
					startNum = Double.parseDouble(extractedString);
					startChip = start + 1;
					break;
				}
			} else {
				System.out.println(start);
				String extractedString = expression.substring(start, positionOfSubtract);
				extractedString = extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start;
				break;
			}
		}
		for (int end = positionOfSubtract + 1; end < lengthOfExpression; end++) {
			char endChar = expression.charAt(end);
			if (!((end == lengthOfExpression - 1) && endChar == ')')) {
				if (NUMERICAL_CHAR_LIST.contains(endChar) || endChar == '(' || endChar == ')') {
					if (end == lengthOfExpression - 1) {
						String extractedString = expression.substring(positionOfSubtract + 1, end + 1);
						extractedString = extractedString.replace("(", "").replace(")", "");
						endNum = Double.parseDouble(extractedString);
						endChip = end + 1;
					}
				} else {
					String extractedString = expression.substring(positionOfSubtract + 1, end);
					extractedString = extractedString.replace("(", "").replace(")", "");
					endNum = Double.parseDouble(extractedString);
					endChip = end;
					break;
				}
			} else {
				String extractedString = expression.substring(positionOfSubtract + 1, end + 1);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end + 1;
			}
			/*
			 * if(numericalCharList.contains(endChar) || endChar == '(' ||
			 * endChar == ')'){
			 * 
			 * } else { String extractedString =
			 * expression.substring(positionOfSubtract+1, end); extractedString
			 * = extractedString.replace("(", "").replace(")", ""); endNum =
			 * Double.parseDouble(extractedString); endChip = end; break; }
			 */
		}
		double subtractOutput = startNum - endNum;
		subtractOutput = Math.round(subtractOutput * 100.0) / 100.0;
		outputExpression = expression.substring(0, startChip) + subtractOutput
				+ expression.substring(endChip, lengthOfExpression);
		return outputExpression;
	}

}
