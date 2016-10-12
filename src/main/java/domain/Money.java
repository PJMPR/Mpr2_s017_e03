package domain;

public class Money {

	private int amount;
	
	public Money(int amount) {
		this.amount = amount;
	}

	public Money times(int multiplier) {
		return new Money(amount * multiplier);
	}
	
	public boolean equals(Object other){
		Money money = (Money) other;
		return money.amount==this.amount;
	}
	
}
