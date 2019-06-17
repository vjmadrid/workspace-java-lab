package com.acme.example.java8.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.acme.example.java8.entity.Account;

public enum SortLambdaUtil {

	INSTANCE;
	
	public void sortUsingJava7ByIdDesc(List<Account> accountList){
		Collections.sort(accountList, new Comparator<Account>(){

			@Override
			public int compare(Account a1, Account a2) {
				return a2.getOwner().compareTo(a1.getOwner());
			}

		});
	}
	
	public void sortUsingJava8ByIdDesc(List<Account> accountList){
		Collections.sort(accountList, (a1, a2) -> a2.getOwner().compareTo(a1.getOwner()) );
	}
}
