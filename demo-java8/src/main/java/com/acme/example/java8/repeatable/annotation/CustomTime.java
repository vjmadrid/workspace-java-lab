package com.acme.example.java8.repeatable.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CustomTime {

	CustomDuration[] value();
}
