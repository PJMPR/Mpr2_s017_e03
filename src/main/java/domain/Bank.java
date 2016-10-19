package domain;

public class Bank {

	public Money reduce(Expression sum, Currency string) {
		Sum sum1 = (Sum) sum;
		int amount = sum1.augend.amount + sum1.addend.amount;
		return new Money(amount, string);
	}

}
