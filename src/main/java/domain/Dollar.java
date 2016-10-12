package domain;

public class Dollar {

	private int initialAmount;
    public int amount;

	public Dollar(int amount) {
		this.initialAmount = amount;
	}

	public Dollar times(int multiplier) {
		amount = initialAmount * multiplier;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		Dollar other = (Dollar) obj;
		if (amount != other.amount)
			return false;
		if (initialAmount != other.initialAmount)
			return false;
		return true;
	}	

}
