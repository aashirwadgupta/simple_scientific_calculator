package com.scientific.string.calculator.service;

/*import com.string.calculator.service.impl.AdditionCalculationEngineImpl;
import com.string.calculator.service.impl.DivisionCalculationEngineImpl;
import com.string.calculator.service.impl.MultiplicationCalculationEngineImpl;
import com.string.calculator.service.impl.PowerCalculationEngineImpl;
import com.string.calculator.service.impl.SubtractionCalculationEngineImpl;*/

//@FunctionalInterface
public interface CalculationBasicFunctionInterface {
	/**
	 * Somehow this code is not working in Spring tool suite. 
	 * TODO : Look into making the calculationEngine as a functional Interface
	 */
	
	/*static String calculationEngine(String expression) {
		int lengthOfExpression = expression.length();
		System.out.println("supplied expression is "+expression);
		int position = 0;
		int positionOfPow = 0;
		int positionOfAdd = 0;
		int positionOfSubtract = 0;
		int positionOfMultiply = 0;
		int positionOfDivide = 0;
		int positionOfOpenBracket = 0;
		int positionOfClosedBracket = 0;
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
					PowerCalculationEngineImpl exponentEngine = new PowerCalculationEngineImpl();
					//outputExpression = calculatePower(expression, lengthOfExpression, positionOfPow);
					outputExpression = exponentEngine.calculateOperandExpression(expression, lengthOfExpression, positionOfPow);
					System.out.println(outputExpression);
					positionOfPow = outputExpression.indexOf('^');
					if(positionOfPow!=-1){
						lengthOfExpression = outputExpression.length();
						outputExpression = calculatePower(expression, lengthOfExpression, positionOfPow);                				
					} else {
						positionOfDivide = outputExpression.indexOf('/');
					}
				} else if(positionOfDivide!=-1) {
					DivisionCalculationEngineImpl divisionEngine = new DivisionCalculationEngineImpl();
					//outputExpression = calculateDivision(expression, lengthOfExpression, positionOfDivide);
					outputExpression = divisionEngine.calculateOperandExpression(expression, lengthOfExpression, positionOfDivide);
					System.out.println(outputExpression);                				
				} else if(positionOfMultiply!=-1){
					MultiplicationCalculationEngineImpl multiplicationEngine = new MultiplicationCalculationEngineImpl();
					outputExpression = calculateMultiplication(expression, lengthOfExpression,
							positionOfMultiply);
					outputExpression = multiplicationEngine.calculateOperandExpression(expression, lengthOfExpression, positionOfMultiply);
					System.out.println(outputExpression);
				} else if(positionOfAdd!=-1) {
					AdditionCalculationEngineImpl additionEngine = new AdditionCalculationEngineImpl();
					//outputExpression = calculateAddition(expression, lengthOfExpression, positionOfAdd);
					outputExpression = additionEngine.calculateOperandExpression(expression, lengthOfExpression, positionOfAdd);
					System.out.println(outputExpression);
				} else if(!(positionOfSubtract==-1 || positionOfSubtract==0)){
					SubtractionCalculationEngineImpl subtractionEngine = new SubtractionCalculationEngineImpl();
					//outputExpression = calculateSubtraction(expression, lengthOfExpression, positionOfSubtract);
					outputExpression = subtractionEngine.calculateOperandExpression(expression, lengthOfExpression, positionOfSubtract);
					System.out.println(outputExpression);
				} else {
					outputExpression = expression;
					s=lengthOfExpression-1;
					break;
				}
				System.out.println("Expression is "+expression+" with length as "+lengthOfExpression);
				expression = outputExpression;
				lengthOfExpression = outputExpression.length();
				System.out.println("Expression after reassignement is "+expression+" with length as "+lengthOfExpression);
				s=0;
			}
		}
		return expression;
	}*/
}
