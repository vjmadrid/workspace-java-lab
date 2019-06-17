package com.acme.example.java8.functional;

import java.util.List;
import java.util.function.Predicate;

import com.acme.example.java8.entity.Account;

public class CustomCountFunctionalInterfaceImpl implements CustomCountFunctionalInterface {

	@Override
	public long count(List<Account> list, Predicate<Account> predicate) {
		long result = 0;
		for (Account a: list){
			if (predicate.test(a)){
				result++;
			}
		}
		return result;
	}
	
}
