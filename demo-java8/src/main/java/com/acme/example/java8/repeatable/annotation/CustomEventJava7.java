package com.acme.example.java8.repeatable.annotation;

@CustomTime({
	@CustomDuration,
	@CustomDuration (hour=2)
})
public class CustomEventJava7 {

}
