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
    
}
