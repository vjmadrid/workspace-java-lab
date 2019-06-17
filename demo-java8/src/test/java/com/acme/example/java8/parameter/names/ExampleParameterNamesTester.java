
package com.acme.example.java8.parameter.names;


import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.Before;
import org.junit.Test;

import com.acme.example.java8.entity.Bank;

public class ExampleParameterNamesTester {
	

	@Before
	public final void setUp() throws Exception {
		
	}
	
	@Test
    public final void shouldParametersNames() {
		Method[] methods = Bank.class.getMethods();
		
		for (Method method : methods){
			System.out.print(method.getName() + "(");
			Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType().getName() + " " + parameter.getName() + " ");
            }
	        System.out.println(")");
		}
		
		assertEquals(11, methods.length);
	}
	

}
