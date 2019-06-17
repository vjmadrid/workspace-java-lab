package com.acme.example.java8.lambda.service;


public class CustomOperation {
	
	//SIN declaración del tipo en el parametro
	public static CustomOperationInterface ADD = (num1 , num2) -> num1 + num2;
	
	//CON declaración del tipo en el parametro
	public static CustomOperationInterface SUBTRACTION = (long num1 , long num2) -> num1 - num2;
	
	//CON sentencia de rentorno y corchetes corchetes
	public static CustomOperationInterface MULTIPLICATION = (long num1 , long num2) -> { return num1 * num2;};
	
	public long operate(long param1, long param2, CustomOperationInterface type){
		return type.operation(param1, param2);
	}

}
