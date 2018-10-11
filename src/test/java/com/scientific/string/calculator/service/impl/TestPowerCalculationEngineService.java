package com.scientific.string.calculator.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPowerCalculationEngineService {

	private PowerCalculationEngineServiceImpl powerService;

	@Before
	public void setUp() throws Exception {
		powerService = new PowerCalculationEngineServiceImpl();
	}

	@Test
	public void testCalculateOperandExpression() {
		String testExpression = "(5+(6^2)+2)+3-4)-4";
		int lengthOfExpression = testExpression.length();
		int positionOfPow = testExpression.indexOf('^');
		String resultExpression = powerService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfPow);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("(5+36.0+2)+3-4)-4", resultExpression);
	}

	@Test
	public void testCalculateOperandExpressionAnother() {
		String testExpression = "(5+(9+(6^2))+2)+3-4)-4";
		int lengthOfExpression = testExpression.length();
		int positionOfPow = testExpression.indexOf('^');
		String resultExpression = powerService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfPow);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("(5+(9+36.0+2)+3-4)-4", resultExpression);
	}
}
