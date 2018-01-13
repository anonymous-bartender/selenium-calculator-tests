package appModules;

import pageObjects.Calculator;

public class Operation {

	private static String ADDITION = "+";
	private static String SUBSTRACT = "-";
	private static String MULTIPLY = "*";
	private static String DEVIDE = "/";
	private static String EQUAL = "=";

	public static String MULTIPLY(Calculator calculator,String input1, String input2) {
		calculator.sendKeys(input1);
		calculator.setOperator(MULTIPLY);
		calculator.sendKeys(input2);
		calculator.sendKeys(EQUAL);

		return calculator.getOutput();		
	}
	public static String ADDITION(Calculator calculator,String input1, String input2) {		
		calculator.sendKeys(input1);
		calculator.setOperator(ADDITION);
		calculator.sendKeys(input2);
		calculator.sendKeys(EQUAL);

		return calculator.getOutput();	
	}

	public static String SUBSTRACT(Calculator calculator,String input1, String input2) {		
		calculator.sendKeys(input1);
		calculator.setOperator(SUBSTRACT);
		calculator.sendKeys(input2);
		calculator.sendKeys(EQUAL);

		return calculator.getOutput();	
	}

	public static String DEVISION(Calculator calculator,String input1, String input2) {		
		calculator.sendKeys(input1);
		calculator.setOperator(DEVIDE);
		calculator.sendKeys(input2);
		calculator.sendKeys(EQUAL);
		
		if(Integer.valueOf(input2)==0)
			return calculator.getAlertMessage();

		return calculator.getOutput();	
	}

}
