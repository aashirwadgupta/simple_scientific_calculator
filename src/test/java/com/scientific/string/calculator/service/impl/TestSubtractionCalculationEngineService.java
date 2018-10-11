package com.scientific.string.calculator.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSubtractionCalculationEngineService {
	
	private SubtractionCalculationEngineServiceImpl subtractionService;

	@Before
	public void setUp() throws Exception {
		subtractionService = new SubtractionCalculationEngineServiceImpl();
	}

	@Test
	public void testCalculateOperandExpression() {
		String testExpression = "(5-2)+(4-3)";
		int lengthOfExpression = testExpression.length();
		int positionOfSubtract = testExpression.indexOf('-');
		String resultExpression = subtractionService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfSubtract);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("3.0+(4-3)", resultExpression);
	}

	@Test
	public void testCalculateOperandExpressionMultiple() {
		String testExpression = "(5-2)+(4-3)";
		int lengthOfExpression = testExpression.length();
		int positionOfSubtract = testExpression.indexOf('-');
		String resultExpression = subtractionService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfSubtract);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("3.0+(4-3)", resultExpression);
		lengthOfExpression = resultExpression.length();
		positionOfSubtract = resultExpression.indexOf('-');
		resultExpression = subtractionService.calculateOperandExpression(resultExpression, lengthOfExpression, positionOfSubtract);
		assertEquals("3.0+1.0", resultExpression);
	}

}
