package com.acme.example.java8.nashorn;


import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Before;
import org.junit.Test;

public class ExampleNashornTester {

	private final String NASHORN_JAVASCRIPT_ENGINE = "nashorn";
	
	private final String DEFAULT_VALUE = "test";
		
	private ScriptEngineManager scriptEngineManager; 
	
	private ScriptEngine nashorn;
	
	@Before
	public final void setUp() throws Exception {
		scriptEngineManager = new ScriptEngineManager();
		nashorn = scriptEngineManager.getEngineByName(NASHORN_JAVASCRIPT_ENGINE);
	}
	
	@Test
    public final void shouldCallJavascriptFromJava() {
		Integer result = null;
		try {
			nashorn.eval("print('***Test call Javascript from Java***')");
			result = (Integer) nashorn.eval("3+2");		
		} catch (ScriptException e) {
			System.out.println("Error ejecutando script : "+ e.getMessage());
		}
		
		assertEquals("5",result.toString());
	}
	
	@Test
    public final void shouldCallJavascriptFileFromJava() {
		Path path = Paths.get("C:/ejemplo.js");
		try {
			nashorn.eval(new FileReader(path.toString()));
		} catch (ScriptException e) {
			System.out.println("Error ejecutando script : "+ e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Error leyendo fichero de script : "+ e.getMessage());
		}
	}
	
	@Test
    public final void shouldCallJavascriptWithJavaResources() {
		String result = null;
		try {
			nashorn.eval("print('***Test call Javascript with resources Java***')");
			nashorn.put("defaultKey",DEFAULT_VALUE);
			nashorn.eval("var dk = defaultKey");
			
			result = (String) nashorn.eval("dk");
		} catch (ScriptException e) {
			System.out.println("Error ejecutando script : "+ e.getMessage());
		}
		
		assertEquals(DEFAULT_VALUE,result.toString());
	}

}
