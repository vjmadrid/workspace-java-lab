package com.acme.example.java8.repeatable.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(CustomTime.class)
public @interface CustomDuration {

	int hour() default 1;
}
