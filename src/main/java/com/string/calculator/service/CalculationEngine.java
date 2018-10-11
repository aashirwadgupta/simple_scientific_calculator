package com.string.calculator.service;

import java.util.Arrays;
import java.util.List;

public interface CalculationEngine {
	public static final List<Character> OPERAND_CHAR_LIST = Arrays.asList('+','-','/','*','^');
	public static final List<Character> NUMERICAL_CHAR_LIST = Arrays.asList('0','1','2','3','4','5','6','7','8','9','.');
	
	public String calculatePower(String expression, int lengthOfExpression, int positionOfOperand);
}
