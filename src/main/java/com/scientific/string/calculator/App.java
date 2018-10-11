package com.scientific.string.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

import com.scientific.string.calculator.service.CalculationEngineService;

public class App 
{
	
    public static void main( String[] args )
    {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = 0;
        
        try {
        	testCases = Integer.parseInt(inputReader.readLine());
        	String[] testCasesArr = new String[testCases];
        	for(int i=0; i<testCases; i++) {
        		testCasesArr[i] = inputReader.readLine();
        	}
        	CalculationEngineService calculationEngine = new CalculationEngineService();
        	TreeMap<Integer, String> resultMap = calculationEngine.startCalculationEngine(testCases, testCasesArr);
        	for(int insertionOrder : resultMap.keySet()) {
        		//System.out.println(testCasesArr[k]+" is "+resultMap.get(k));
        		System.out.println(resultMap.get(insertionOrder));
        	}
        } catch (IOException iOEx) {
        	iOEx.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
}
