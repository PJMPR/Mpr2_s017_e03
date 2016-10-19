package domain;

public class Bank {

	public Money reduce(Expression expression, Currency string) {
		if(expression instanceof Sum){
			Sum sum1 = (Sum) expression;
			int amount = sum1.augend.amount + sum1.addend.amount;
			return new Money(amount, string);
		}
		if(expression instanceof Money)
			return (Money)expression;
		
		return null;
	}

}
