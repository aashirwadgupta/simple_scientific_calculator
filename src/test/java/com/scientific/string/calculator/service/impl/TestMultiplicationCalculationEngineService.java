package com.scientific.string.calculator.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMultiplicationCalculationEngineService {

	private MultiplicationCalculationEngineServiceImpl multiplicationService;

	@Before
	public void setUp() throws Exception {
		multiplicationService = new MultiplicationCalculationEngineServiceImpl();
	}

	@Test
	public void testCalculateOperandExpression() {
		String testExpression = "(5+(6*2)+2)+3-4)-4";
		int lengthOfExpression = testExpression.length();
		int positionOfMultiply = testExpression.indexOf('*');
		String resultExpression = multiplicationService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfMultiply);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("(5+12.0+2)+3-4)-4", resultExpression);
	}

	@Test
	public void testCalculateOperandExpressionAnother() {
		String testExpression = "(5+(9+(6*2))+2)+3-4)-4";
		int lengthOfExpression = testExpression.length();
		int positionOfMultiply = testExpression.indexOf('*');
		String resultExpression = multiplicationService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfMultiply);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("(5+(9+12.0+2)+3-4)-4", resultExpression);
	}

}
