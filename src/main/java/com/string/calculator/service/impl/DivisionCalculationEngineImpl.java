package com.string.calculator.service.impl;

import com.string.calculator.service.CalculationEngine;

public class DivisionCalculationEngineImpl extends CalculationEngine {
	
	public String calculateOperandExpression(String expression, int lengthOfExpression, int positionOfDivide) {
		String outputExpression;
		double startNum = 0;
		double endNum = 0;
		int startChip = 0, endChip = 0;
		for(int start = positionOfDivide-1;start>=0;start--){
			char startChar = expression.charAt(start);
			if(!(start==0 && startChar=='(')) {
				if(NUMERICAL_CHAR_LIST.contains(startChar) || startChar == '(' || startChar == ')'){
					if(start==0) {
						String extractedString = expression.substring(start, positionOfDivide);
						extractedString = extractedString.replace("(", "").replace(")", "");
						startNum = Double.parseDouble(extractedString);
						startChip = start;
						break;
					}
				} else {
					String extractedString = expression.substring(start+1, positionOfDivide);
					extractedString = extractedString.replace("(", "").replace(")", "");
					startNum = Double.parseDouble(extractedString);
					startChip = start+1;
					break;
				}
			} else {
				String extractedString = expression.substring(start, positionOfDivide);
				extractedString = extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start;
				break;
			}
			/*if(numericalCharList.contains(startChar) || startChar == '(' || startChar == ')'){
				
			} else {
				String extractedString = expression.substring(start+1, positionOfDivide);
				extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start+1;
				break;
			}*/
		}
		for(int end = positionOfDivide+1;end<lengthOfExpression;end++){
			char endChar = expression.charAt(end);
			if(!((end==lengthOfExpression-1) && endChar==')')){
				if(NUMERICAL_CHAR_LIST.contains(endChar) || endChar == '(' || endChar == ')'){

					if(end==lengthOfExpression-1){
						String extractedString = expression.substring(positionOfDivide+1, end+1);
						extractedString = extractedString.replace("(", "").replace(")", "");
						endNum = Double.parseDouble(extractedString);
						endChip = end+1;
					}
				} else {
					String extractedString = expression.substring(positionOfDivide+1, end);
					extractedString = extractedString.replace("(", "").replace(")", "");
					endNum = Double.parseDouble(extractedString);
					endChip = end;
					break;
				}
			} else { 
				String extractedString = expression.substring(positionOfDivide+1, end+1);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end+1;
				
			}
			/*if(numericalCharList.contains(endChar) || endChar == '(' || endChar == ')'){
				
			} else {
				String extractedString = expression.substring(positionOfDivide+1, end);
				extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end;
				break;
			}*/
		}
		double divideOutput = startNum/endNum;
		divideOutput = Math.round(divideOutput*100.0)/100.0;
		outputExpression = expression.substring(0, startChip)+divideOutput+expression.substring(endChip, lengthOfExpression);
		return outputExpression;
	}

}
