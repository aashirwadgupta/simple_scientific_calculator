package com.scientific.string.calculator.service.impl;

import org.apache.commons.lang3.StringUtils;

import com.scientific.string.calculator.service.CalculationEngineService;

public class PowerCalculationEngineServiceImpl extends CalculationEngineService {
	
	/**
	 * Exponential/Power Engine Function to perform exponent/power in the expression at
	 * places wherever the '^' sign occurs. This function overrides base
	 * function of the {@com.string.calculator.service.CalculationEngine} Class
	 * which uses BODMAS rule to solve the expression equation
	 * 
	 * @param expression
	 *            The expression in which the division between digits is to
	 *            be performed
	 * @param lengthOfExpression
	 *            length of the provided expression.
	 * @param positionOfDivide
	 *            first position of the '^' sign, in the expression to be
	 *            calculated.
	 * @return the output expression post the calculation being done, replacing
	 *         the multiple brackets enclosed, with the result of the expression
	 *         on which exponent/power was performed.
	 */
	public String calculateOperandExpression(String expression, int lengthOfExpression, int positionOfPow) {
		System.out.println("Expression within power is "+expression);
		double startNum = 0;
		double endNum = 0;
		int startChip = 0, endChip = 0;
		for(int start = positionOfPow-1;start>=0;start--){
			char startChar = expression.charAt(start);
			if(!(start==0 && startChar=='(')) {
				if(NUMERICAL_CHAR_LIST.contains(startChar) || startChar == '(' || startChar == ')'){
					if(start==0) {
						System.out.println(start);
						String extractedString = expression.substring(start, positionOfPow);
						extractedString = extractedString.replaceFirst("(", "").replaceFirst(")", "");
						startNum = Double.parseDouble(extractedString);
						startChip = start;
						break;
					}
					if(startChar==')') {
						int cascadeSplitIndex = 0;
						for(int startCascade=start; startCascade>=0;startCascade--) {
							char cascadedChar = expression.charAt(startCascade);
							if(cascadedChar=='(') {
								cascadeSplitIndex = startCascade;
								break;
							}
						}
						String extractedPartialExpression = expression.substring(cascadeSplitIndex, positionOfPow);
						System.out.println("printing extractedPartialExpression");
						System.out.println(extractedPartialExpression);
						String resultExpression = invokeCalculationEngine(extractedPartialExpression);
						System.out.println("printing resultExpression");
						System.out.println(resultExpression);
						expression = expression.replace(extractedPartialExpression, resultExpression);
						System.out.println("printing finalExpression");
						System.out.println(expression);
						//expression = invokeCalculationEngine(expression);
						return expression;
						
					}
				} else {
					String extractedString = expression.substring(start+1, positionOfPow);
					System.out.println("extracted String "+extractedString);
					if(extractedString.indexOf('(')!=-1) {
						extractedString = StringUtils.replaceOnce(extractedString, "(", "");
						//extractedString = extractedString.replaceFirst("(", "");
					} 
					if (extractedString.indexOf(')')!=-1) {
						extractedString = StringUtils.replaceOnce(extractedString, ")", "");
						//extractedString = extractedString.replaceFirst(")", "");
					}
					//extractedString = extractedString.replaceFirst("(", "").replaceFirst(")", "");
					startNum = Double.parseDouble(extractedString);
					startChip = start+1;
					break;
				}
			} else {
				System.out.println(start);
				String extractedString = expression.substring(start, positionOfPow);
				extractedString = extractedString.replaceFirst("(", "").replaceFirst(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start;
				break;
			}
		}
		
		for(int end = positionOfPow+1;end<lengthOfExpression;end++){
			char endChar = expression.charAt(end);
			if(!((end==lengthOfExpression-1) && endChar==')')){
				if(NUMERICAL_CHAR_LIST.contains(endChar) || endChar == '(' || endChar == ')'){
					if(end==lengthOfExpression-1){
						String extractedString = expression.substring(positionOfPow+1, end+1);
						extractedString = extractedString.replaceFirst("(", "").replaceFirst(")", "");
						endNum = Double.parseDouble(extractedString);
						endChip = end+1;
					}
					
				} else {
					String extractedString = expression.substring(positionOfPow+1, end);
					//String extractedString = expression.substring(start+1, positionOfPow);
					System.out.println("extracted String "+extractedString);
					if(extractedString.indexOf('(')!=-1) {
						extractedString = StringUtils.replaceOnce(extractedString, "(", "");
						//extractedString = extractedString.replaceFirst("(", "");
					} 
					if (extractedString.indexOf(')')!=-1) {
						extractedString = StringUtils.replaceOnce(extractedString, ")", "");
						//extractedString = extractedString.replaceFirst(")", "");
					}
					//extractedString = extractedString.replaceFirst("(", "").replaceFirst(")", "");
					endNum = Double.parseDouble(extractedString);
					endChip = end;
					break;
				}
			} else {
				String extractedString = expression.substring(positionOfPow+1, end+1);
				extractedString = extractedString.replaceFirst("(", "").replaceFirst(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end+1;
			}
			/*if(numericalCharList.contains(expression.charAt(end))){
				
			} else {
				endNum = Double.parseDouble(expression.substring(positionOfPow+1, end));
				endChip = end;
				break;
			}*/
		}
		double powerOutput = Math.pow(startNum, endNum);
		powerOutput = Math.round(powerOutput*100.0)/100.0;
		String outputExpression = expression.substring(0, startChip)+powerOutput+expression.substring(endChip, lengthOfExpression);
		return outputExpression;
	}

}
