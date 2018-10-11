package com.string.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final List<Character> OPERAND_CHAR_LIST = Arrays.asList('+','-','/','*','^');
	private static final List<Character> NUMERICAL_CHAR_LIST = Arrays.asList('0','1','2','3','4','5','6','7','8','9','.');
    public static void main( String[] args )
    {
        //System.out.println( "Welcome to Scientifc String Calculator" );
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
        	for(int i=0; i<testCases; i++) {
        		boolean validityFlag = true;
        		String expression = testCasesArr[i];
        		int index = 0;
        		int openingBrackets = 0;
        		int closingBrackets = 0;
        		char[] expressionArr = expression.toCharArray();
        		int len = expressionArr.length;
        		for(char c : expressionArr) {
					System.out.println(new Character(c));
            		if(OPERAND_CHAR_LIST.contains(c) || c == '(' || c==')'){
            			if(index!=len-1){
            				char nextChar = expressionArr[index+1];
        					System.out.println(new Character(nextChar));
            				if(c=='(' & (nextChar!=')' || !OPERAND_CHAR_LIST.contains(nextChar))){
            					openingBrackets++;
            				} else if(c==')' & (nextChar!='(' || !OPERAND_CHAR_LIST.contains(nextChar))) {
            					closingBrackets++;
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
        					System.out.println(new Character(nextChar));
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
            		}
            		index = index+1;
        		}
        		if(validityFlag && (openingBrackets == closingBrackets)) {
        			int lengthOfExpression = expression.length();
        			int position = 0;
        			int positionOfPow = 0;
        			int positionOfAdd = 0;
        			int positionOfSubtract = 0;
        			int positionOfMultiply = 0;
        			int positionOfDivide = 0;
        			int positionOfOpenBracket = 0;
        			int positionOfClosedBracket = 0;
        			outputMap.put(i, "Valid Expression");
        			positionOfOpenBracket = expression.indexOf('(');
        			int lastPositionOfOpenBracket = expression.lastIndexOf('(');
        			for(int s = 0; s<lengthOfExpression; s++){
        				if((s+1)==lengthOfExpression){
        					break;
        				}
        				char presentChar = expression.charAt(s+1);
        				if(NUMERICAL_CHAR_LIST.contains(presentChar)) {
        					positionOfPow = expression.indexOf('^');
        					positionOfDivide = expression.indexOf('/');
        					positionOfMultiply = expression.indexOf('*');
        					positionOfAdd = expression.indexOf('+');
        					positionOfSubtract = expression.indexOf('-');
        					
        					String outputExpression = "";
                			if(positionOfPow!=-1){
                				outputExpression = calculatePower(expression, lengthOfExpression, positionOfPow);
                    			System.out.println(outputExpression);
                    			/*positionOfPow = outputExpression.indexOf('^');
                				if(positionOfPow!=-1){
                    				lengthOfExpression = outputExpression.length();
                					outputExpression = calculatePower(expression, lengthOfExpression, positionOfPow);                				
                    			} else {
                    				positionOfDivide = outputExpression.indexOf('/');
                    			}*/
                			} else if(positionOfDivide!=-1) {
                				outputExpression = calculateDivision(expression, lengthOfExpression, positionOfDivide);
                    			System.out.println(outputExpression);                				
                			} else if(positionOfMultiply!=-1){
                				outputExpression = calculateMultiplication(expression, lengthOfExpression,
										positionOfMultiply);
                    			System.out.println(outputExpression);
                			} else if(positionOfAdd!=-1) {
                				outputExpression = calculateAddition(expression, lengthOfExpression, positionOfAdd);
                    			System.out.println(outputExpression);
                			} else if(!(positionOfSubtract==-1 || positionOfSubtract==0)){
                				outputExpression = calculateSubtraction(expression, lengthOfExpression,
										positionOfSubtract);
                    			System.out.println(outputExpression);
                			} else {
                				outputExpression = expression;
                				s=lengthOfExpression-1;
                				break;
                			}
                			//System.out.println("Expression is "+expression+" with length as "+lengthOfExpression);
                			expression = outputExpression;
                			lengthOfExpression = outputExpression.length();
                			//System.out.println("Expression after reassignement is "+expression+" with length as "+lengthOfExpression);
                			s=0;
            			}
        			}
        			System.out.println(expression);
        			
        			/*for(char c : expressionArr) {
        				System.out.println(new Character(c));
        				if(position==0){
        					if(numericalCharList.contains(c)){
        						
        					} else if(c=='(') {
        					}
        				} else if(c=='^'){
        					
        				} else if(c == '/'){
        					
        				} else if(c == '*'){
        					
        				} else if(c == '+'){
        					
        				} else if(c == '-'){
        					
        				}
        			}*/
        		} else {
        			outputMap.put(i, "Invalid Expression");
        		}
        		
        	}
        	for(int k=0; k<outputMap.size(); k++) {
        		System.out.println(testCasesArr[k]+" is "+outputMap.get(k));
        	}
        } catch (IOException iOEx) {
        	iOEx.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

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
			/*if(numericalCharList.contains(startChar) || startChar == '(' || startChar == ')'){
				
			} else {
				String extractedString = expression.substring(start+1, positionOfMultiply);
				extractedString = extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start+1;
				break;
			}*/
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
			/*if(numericalCharList.contains(startChar) || startChar == '(' || startChar == ')'){
				
			} else {
				String extractedString = expression.substring(start+1, positionOfAdd);
				extractedString = extractedString.replace("(", "").replace(")", "");
				startNum = Double.parseDouble(extractedString);
				startChip = start+1;
				break;
			}*/
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
			/*if(numericalCharList.contains(endChar) || endChar == '(' || endChar == ')'){
				
			} else {
				String extractedString = expression.substring(positionOfAdd+1, end);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end;
				break;
			}*/
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
			/*if(numericalCharList.contains(endChar) || endChar == '(' || endChar == ')'){
				
			} else {
				String extractedString = expression.substring(positionOfSubtract+1, end);
				extractedString = extractedString.replace("(", "").replace(")", "");
				endNum = Double.parseDouble(extractedString);
				endChip = end;
				break;
			}*/
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
