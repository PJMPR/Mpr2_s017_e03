package domain;

public class Bank {

	public Money reduce(Expression expression, Currency string) {
		return expression.operation();
	}

}
