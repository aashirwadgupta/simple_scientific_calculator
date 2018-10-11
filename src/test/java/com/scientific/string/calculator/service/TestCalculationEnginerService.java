package com.scientific.string.calculator.service;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;


public class TestCalculationEnginerService {
	
	private CalculationEngineService calculationEngineService;

	@Before
	public void setUp() throws Exception {
		calculationEngineService = new CalculationEngineService();
	}

	@Test
	public void testCalculateOperandExpression() {
		String testExpression = "(8*5/8)-(3/1)-5)";
		int testExprLen = testExpression.length();
		String outputExpression = calculationEngineService.calculateOperandExpression(testExpression, testExprLen, 2);
		assertEquals(testExpression, outputExpression);
		assertEquals(testExprLen, outputExpression.length());
		
	}

	@Test
	public void testValidateSuppliedExpression() {
		//The below expressions are already tested in multiple iterations of this test case. 
		String[] testExpressionArr = {"(8*5/8)-(3/1)-5)", "7+6*5^2+3-4/2", "(5+((1+6)^2)+3-4)-4"};
		TreeMap<Integer, String> responseMap = calculationEngineService.validateSuppliedExpression(3, testExpressionArr);
		assertEquals(3, responseMap.size());
		assertEquals("Invalid Expression", responseMap.get(0));
		assertEquals("Valid Expression", responseMap.get(1));
		assertEquals("Valid Expression", responseMap.get(2));
	}

}
