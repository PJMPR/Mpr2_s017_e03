package domain;

public class Franc extends Currency{

	public Franc(int amount) {
		super(amount);
	}

	public Object times(int multiplier) {
		return new Franc(getAmount() * multiplier);
	}

}
