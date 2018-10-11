package com.string.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*import java.util.Arrays;
import java.util.List;*/
import java.util.Map;
import java.util.TreeMap;

import com.string.calculator.service.CalculationEngineService;

public class App 
{
	//Commented as not being used now.
	//private static final List<Character> OPERAND_CHAR_LIST = Arrays.asList('+','-','/','*','^');
	//private static final List<Character> NUMERICAL_CHAR_LIST = Arrays.asList('0','1','2','3','4','5','6','7','8','9','.');
	
    public static void main( String[] args )
    {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = 0;
        Map<Integer, String> outputMap = new TreeMap<Integer, String>();
        try {
        	testCases = Integer.parseInt(inputReader.readLine());
        	String[] testCasesArr = new String[testCases];
        	for(int i=0; i<testCases; i++) {
        		testCasesArr[i] = inputReader.readLine();
        	}
        	System.out.println("Validating and calculating Result");
        	CalculationEngineService calculationEngine = new CalculationEngineService();
        	calculationEngine.startCalculationEngine(testCases, outputMap, testCasesArr);
        	for(int k=0; k<outputMap.size(); k++) {
        		System.out.println(testCasesArr[k]+" is "+outputMap.get(k));
        	}
        } catch (IOException iOEx) {
        	iOEx.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
	/*private static void startCalculationEngine(int testCases, Map<Integer, String> outputMap, String[] testCasesArr) {
		for(int i=0; i<testCases; i++) {
			boolean validityFlag = true;
			String expression = testCasesArr[i];
			System.out.println("initial expression is "+expression);
			int index = 0;
			int openingBrackets = 0;
			int closingBrackets = 0;
			char[] expressionArr = expression.toCharArray();
			int len = expressionArr.length;
			for(char c : expressionArr) {
				System.out.println("char is "+new Character(c));
				System.out.println("index is "+index);
				if(OPERAND_CHAR_LIST.contains(c) || c == '(' || c==')'){
					if(index!=len-1){
						char nextChar = expressionArr[index+1];
						System.out.println("next char in operand is "+new Character(nextChar));
						if(c=='(' & (nextChar!=')' || !OPERAND_CHAR_LIST.contains(nextChar))){
							openingBrackets++;
						} else if(OPERAND_CHAR_LIST.contains(c) && (nextChar!=')' || !OPERAND_CHAR_LIST.contains(nextChar))) {
							
						} else if(c==')' && nextChar!='(') {
							closingBrackets++;
						} else if(c!=')' && nextChar=='(') {
							openingBrackets++;
						} else if(!OPERAND_CHAR_LIST.contains(nextChar) && nextChar!=')') {
							
						} else {
							validityFlag = false;
		    				//System.out.println("Invalid Expression");
		    				break;
						}
					} else {
						if(c==')'){
							closingBrackets++;
						} else if (c=='(' || OPERAND_CHAR_LIST.contains(c)){
							validityFlag = false;
		    				//System.out.println("Invalid Expression");
		    				break;
						}
					}
				} else if(NUMERICAL_CHAR_LIST.contains(c)) {
					if(index!=len-1){
						char nextChar = expressionArr[index+1];
						System.out.println("next char in numerical is "+new Character(nextChar));
						//System.out.println(new Character(nextChar));
						if(NUMERICAL_CHAR_LIST.contains(nextChar) || OPERAND_CHAR_LIST.contains(nextChar) || nextChar == ')'){
							
						} else {
							validityFlag = false;
		    				//System.out.println("Invalid Expression");
		    				break;
						}
					} else if (c=='(' && OPERAND_CHAR_LIST.contains(c)){
						validityFlag = false;
						//System.out.println("Invalid Expression");
						break;
					}
					//System.out.println("Invalid Expression");
				} else {
					validityFlag = false;
					break;
				}
				index = index+1;
			}
			if(validityFlag && (openingBrackets == closingBrackets)) {
				//System.out.println("Starting now in Valid expression");
				outputMap.put(i, "Valid Expression");
				CalculationEngine calculationEngine = new CalculationEngine();
				expression = calculationEngine.invokeCalculationEngine(expression);
				//System.out.println(expression);
				outputMap.put(i, expression);
			} else {
				outputMap.put(i, "Invalid Expression");
			}
			
		}
	}*/

/*	
	private static String calculateDivision(String expression, int lengthOfExpression, int positionOfDivide) {
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
			if(numericalCharList.contains(startChar) || startChar == '(' || startChar == ')'){
				
			} else {
				String extractedString = expression.substring(start+1, positionOfDivide);
				extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start+1;
				break;
			}
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
			if(numericalCharList.contains(endChar) || endChar == '(' || endChar == ')'){
				
			} else {
				String extractedString = expression.substring(positionOfDivide+1, end);
				extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end;
				break;
			}
		}
		double divideOutput = startNum/endNum;
		divideOutput = Math.round(divideOutput*100.0)/100.0;
		outputExpression = expression.substring(0, startChip)+divideOutput+expression.substring(endChip, lengthOfExpression);
		return outputExpression;
	}

	private static String calculateMultiplication(String expression, int lengthOfExpression, int positionOfMultiply) {
		String outputExpression;
		double startNum = 0;
		double endNum = 0;
		int startChip = 0, endChip = 0;
		for(int start = positionOfMultiply-1;start>=0;start--){
			char startChar = expression.charAt(start);
			if(!(start==0 && startChar=='(')) {
				if(NUMERICAL_CHAR_LIST.contains(startChar) || startChar == '(' || startChar == ')'){
					if(start==0) {
						String extractedString = expression.substring(start, positionOfMultiply);
						extractedString = extractedString.replace("(", "").replace(")", "");
						startNum = Double.parseDouble(extractedString);
						startChip = start;
						break;
					}
				} else {
					String extractedString = expression.substring(start+1, positionOfMultiply);
					extractedString = extractedString.replace("(", "").replace(")", "");
					startNum = Double.parseDouble(extractedString);
					startChip = start+1;
					break;
				}
			} else {
				String extractedString = expression.substring(start, positionOfMultiply);
				extractedString = extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start;
				break;
			}
			if(numericalCharList.contains(startChar) || startChar == '(' || startChar == ')'){
				
			} else {
				String extractedString = expression.substring(start+1, positionOfMultiply);
				extractedString = extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start+1;
				break;
			}
		}
		for(int end = positionOfMultiply+1;end<lengthOfExpression;end++){
			char endChar = expression.charAt(end);
			if(!((end==lengthOfExpression-1) && endChar==')')){
				if(NUMERICAL_CHAR_LIST.contains(endChar) || endChar == '(' || endChar == ')'){
					if(end==lengthOfExpression-1){
						String extractedString = expression.substring(positionOfMultiply+1, end+1);
						extractedString = extractedString.replace("(", "").replace(")", "");
						endNum = Double.parseDouble(extractedString);
						endChip = end+1;
					}
				} else {
					String extractedString = expression.substring(positionOfMultiply+1, end);
					extractedString = extractedString.replace("(", "").replace(")", "");
					endNum = Double.parseDouble(extractedString);
					endChip = end;
					break;
				}
			} else {
				String extractedString = expression.substring(positionOfMultiply+1, end+1);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end+1;
			}
		}
		double multiplyOutput = startNum*endNum;
		multiplyOutput = Math.round(multiplyOutput*100.0)/100.0;
		outputExpression = expression.substring(0, startChip)+multiplyOutput+expression.substring(endChip, lengthOfExpression);
		return outputExpression;
	}

	private static String calculateAddition(String expression, int lengthOfExpression, int positionOfAdd) {
		String outputExpression;
		double startNum = 0;
		double endNum = 0;
		int startChip = 0, endChip = 0;
		for(int start = positionOfAdd-1;start>=0;start--){
			char startChar = expression.charAt(start);
			if(!(start==0 && startChar=='(')) {
				if(NUMERICAL_CHAR_LIST.contains(startChar) || startChar == '(' || startChar == ')'){
					if(start==0) {
						String extractedString = expression.substring(start, positionOfAdd);
						extractedString = extractedString.replace("(", "").replace(")", "");
						startNum = Double.parseDouble(extractedString);
						startChip = start;
						break;
					}
				} else {
					String extractedString = expression.substring(start+1, positionOfAdd);
					extractedString = extractedString.replace("(", "").replace(")", "");
					startNum = Double.parseDouble(extractedString);
					startChip = start+1;
					break;
				}
			} else {
				String extractedString = expression.substring(start, positionOfAdd);
				extractedString = extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start;
				break;
			}
			if(numericalCharList.contains(startChar) || startChar == '(' || startChar == ')'){
				
			} else {
				String extractedString = expression.substring(start+1, positionOfAdd);
				extractedString = extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start+1;
				break;
			}
		}
		for(int end = positionOfAdd+1;end<lengthOfExpression;end++){
			char endChar = expression.charAt(end);
			if(!((end==lengthOfExpression-1) && endChar==')')){
				if(NUMERICAL_CHAR_LIST.contains(endChar) || endChar == '(' || endChar == ')'){
					if(end==lengthOfExpression-1){
						String extractedString = expression.substring(positionOfAdd+1, end+1);
						extractedString = extractedString.replace("(", "").replace(")", "");
						endNum = Double.parseDouble(extractedString);
						endChip = end+1;
					}
				} else {
					String extractedString = expression.substring(positionOfAdd+1, end);
					extractedString = extractedString.replace("(", "").replace(")", "");
					endNum = Double.parseDouble(extractedString);
					endChip = end;
					break;
				}
			} else {
				String extractedString = expression.substring(positionOfAdd+1, end+1);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end+1;
			}
			if(numericalCharList.contains(endChar) || endChar == '(' || endChar == ')'){
				
			} else {
				String extractedString = expression.substring(positionOfAdd+1, end);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end;
				break;
			}
		}
		double addOutput = startNum+endNum;
		addOutput = Math.round(addOutput*100.0)/100.0;
		outputExpression = expression.substring(0, startChip)+addOutput+expression.substring(endChip, lengthOfExpression);
		return outputExpression;
	}

	private static String calculateSubtraction(String expression, int lengthOfExpression, int positionOfSubtract) {
		String outputExpression;
		double startNum = 0;
		double endNum = 0;
		int startChip = 0, endChip = 0;
		for(int start = positionOfSubtract-1;start>=0;start--){
			char startChar = expression.charAt(start);
			if(!(start==0 && startChar=='(')) {
				if(NUMERICAL_CHAR_LIST.contains(startChar) || startChar == '(' || startChar == ')'){
					if(start==0) {
						System.out.println(start);
						String extractedString = expression.substring(start, positionOfSubtract);
						extractedString = extractedString.replace("(", "").replace(")", "");
						startNum = Double.parseDouble(extractedString);
						startChip = start;
						break;
					}
				} else {
					String extractedString = expression.substring(start+1, positionOfSubtract);
					extractedString = extractedString.replace("(", "").replace(")", "");
					startNum = Double.parseDouble(extractedString);
					startChip = start+1;
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
		for(int end = positionOfSubtract+1;end<lengthOfExpression;end++){
			char endChar = expression.charAt(end);
			if(!((end==lengthOfExpression-1) && endChar==')')){
				if(NUMERICAL_CHAR_LIST.contains(endChar) || endChar == '(' || endChar == ')'){
					if(end==lengthOfExpression-1){
						String extractedString = expression.substring(positionOfSubtract+1, end+1);
						extractedString = extractedString.replace("(", "").replace(")", "");
						endNum = Double.parseDouble(extractedString);
						endChip = end+1;
					}
				} else {
					String extractedString = expression.substring(positionOfSubtract+1, end);
					extractedString = extractedString.replace("(", "").replace(")", "");
					endNum = Double.parseDouble(extractedString);
					endChip = end;
					break;
				}
			} else {
				String extractedString = expression.substring(positionOfSubtract+1, end+1);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end+1;
			}
			if(numericalCharList.contains(endChar) || endChar == '(' || endChar == ')'){
				
			} else {
				String extractedString = expression.substring(positionOfSubtract+1, end);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end;
				break;
			}
		}
		double subtractOutput = startNum-endNum;
		subtractOutput = Math.round(subtractOutput*100.0)/100.0;
		outputExpression = expression.substring(0, startChip)+subtractOutput+expression.substring(endChip, lengthOfExpression);
		return outputExpression;
	}
    
	private static String calculatePower(String expression, int lengthOfExpression, int positionOfPow) {
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
						extractedString = extractedString.replace("(", "").replace(")", "");
						startNum = Double.parseDouble(extractedString);
						startChip = start;
						break;
					}
				} else {
					String extractedString = expression.substring(start+1, positionOfPow);
					extractedString = extractedString.replace("(", "").replace(")", "");
					startNum = Double.parseDouble(extractedString);
					startChip = start+1;
					break;
				}
			} else {
				System.out.println(start);
				String extractedString = expression.substring(start, positionOfPow);
				extractedString = extractedString.replace("(", "").replace(")", "");
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
						extractedString = extractedString.replace("(", "").replace(")", "");
						endNum = Double.parseDouble(extractedString);
						endChip = end+1;
					}
					
				} else {
					String extractedString = expression.substring(positionOfPow+1, end);
					extractedString = extractedString.replace("(", "").replace(")", "");
					endNum = Double.parseDouble(extractedString);
					endChip = end;
					break;
				}
			} else {
				String extractedString = expression.substring(positionOfPow+1, end+1);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end+1;
			}
			if(numericalCharList.contains(expression.charAt(end))){
				
			} else {
				endNum = Double.parseDouble(expression.substring(positionOfPow+1, end));
				endChip = end;
				break;
			}
		}
		double powerOutput = Math.pow(startNum, endNum);
		powerOutput = Math.round(powerOutput*100.0)/100.0;
		String outputExpression = expression.substring(0, startChip)+powerOutput+expression.substring(endChip, lengthOfExpression);
		return outputExpression;
	}
	*/
}
