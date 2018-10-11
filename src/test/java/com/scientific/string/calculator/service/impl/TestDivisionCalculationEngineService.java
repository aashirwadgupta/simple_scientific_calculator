package com.scientific.string.calculator.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDivisionCalculationEngineService {

	private DivisionCalculationEngineServiceImpl divisionService;
	
	@Before
	public void setUp() throws Exception {
		divisionService = new DivisionCalculationEngineServiceImpl();
	}

	@Test
	public void testCalculateOperandExpression() {
		String testExpression = "(5+((12/3)+2)+3-4)-4";
		int lengthOfExpression = testExpression.length();
		int positionOfDivide = testExpression.indexOf('/');
		String resultExpression = divisionService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfDivide);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("(5+4.0+2)+3-4)-4", resultExpression);
	}

	@Test
	public void testCalculateOperandExpressionMultipleTimes() {
		String testExpression = "(5+((12/3)/2)/3-4)-4";
		int lengthOfExpression = testExpression.length();
		int positionOfDivide = testExpression.indexOf('/');
		String resultExpression = divisionService.calculateOperandExpression(testExpression, lengthOfExpression, positionOfDivide);
		assertNotEquals(testExpression, resultExpression);
		assertEquals("(5+4.0/2)/3-4)-4", resultExpression);
		lengthOfExpression = resultExpression.length();
		positionOfDivide = resultExpression.indexOf('/');
		resultExpression = divisionService.calculateOperandExpression(resultExpression, lengthOfExpression, positionOfDivide);
		System.out.println(resultExpression);
		assertEquals("(5+2.0/3-4)-4", resultExpression);
		lengthOfExpression = resultExpression.length();
		positionOfDivide = resultExpression.indexOf('/');
		resultExpression = divisionService.calculateOperandExpression(resultExpression, lengthOfExpression, positionOfDivide);
		System.out.println(resultExpression);
		assertEquals("(5+0.67-4)-4", resultExpression);
	}

}
