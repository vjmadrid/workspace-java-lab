package com.acme.example.java8.functional;

import java.util.List;
import java.util.function.Predicate;

import com.acme.example.java8.entity.Account;

@FunctionalInterface
public interface CustomCountFunctionalInterface {

	long count(List<Account> list, Predicate<Account> predicate);
	
	default long defaultCount() {
		return 0;
	}
	
	static long defaultCountStatic() {
		return 0;
	}
}
