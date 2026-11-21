package com.ioc.beans.bank_ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Transaction {
	public void debit() {
		System.out.println("debited from A");
	}
	public void credit() {
		System.out.println("Credited to B");
	}
}

@Component
class Account  {
	
	//Account has-A Transaction
	private Transaction transaction;

	//Constructor Injection
	//Best and safe practice recommended approach
	//It's default Injection (no need of Autowired )
	public Account(Transaction transaction) {
		this.transaction = transaction;
	}
	
	public void transferMoney() {
		transaction.debit();
		transaction.credit();
	}
}
public class BankController {

	public static void main(String[] args) {

		ApplicationContext context
			= new AnnotationConfigApplicationContext(BankAppConfig.class);
		
		Account account = context.getBean("account", Account.class);
		account.transferMoney();
	}

}
