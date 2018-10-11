package com.scientific.string.calculator.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAdditionCalculationEngineService {
	
	private AdditionCalculationEngineServiceImpl additionService;

	@Before
	public void setUp() throws Exception {
		additionService = new AdditionCalculationEngineServiceImpl();
	}

	@Test
	public void testCalculateOperandExpression() {
		String testExpression = "(5+((1+6)+2)+3-4)-4";
		int lengthOfExpression = testExpression.length();
		int positionOfAdd = testExpression.indexOf('+');
		String resultExpression = additionService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfAdd);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("6.0+6)+2)+3-4)-4", resultExpression);
	}

	@Test
	public void testCalculateOperandExpressionMultipleIterations() {
		String testExpression = "(5+((1+6)+2)+3-4)-4";
		int lengthOfExpression = testExpression.length();
		int positionOfAdd = testExpression.indexOf('+');
		String resultExpression = additionService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfAdd);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("6.0+6)+2)+3-4)-4", resultExpression);
		lengthOfExpression = resultExpression.length();
		positionOfAdd = resultExpression.indexOf('+');
		resultExpression = additionService.calculateOperandExpression(resultExpression, lengthOfExpression, positionOfAdd);
		assertEquals("12.0+2)+3-4)-4", resultExpression);
		lengthOfExpression = resultExpression.length();
		positionOfAdd = resultExpression.indexOf('+');
		resultExpression = additionService.calculateOperandExpression(resultExpression, lengthOfExpression, positionOfAdd);
		assertEquals("14.0+3-4)-4", resultExpression);
		lengthOfExpression = resultExpression.length();
		positionOfAdd = resultExpression.indexOf('+');
		resultExpression = additionService.calculateOperandExpression(resultExpression, lengthOfExpression, positionOfAdd);
		assertEquals("17.0-4)-4", resultExpression);
		//Now there will not be any change
		lengthOfExpression = resultExpression.length();
		positionOfAdd = resultExpression.indexOf('+');
		resultExpression = additionService.calculateOperandExpression(resultExpression, lengthOfExpression, positionOfAdd);
		assertEquals("17.0-4)-4", resultExpression);
	}

}
