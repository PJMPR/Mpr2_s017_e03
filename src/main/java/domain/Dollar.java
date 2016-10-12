package domain;

public class Dollar {

	public int initialAmount;
        public int amount;

	public Dollar(int amount) {
		this.initialAmount = amount;
	}

	public Dollar times(int multiplier) {
		amount = initialAmount * multiplier;
		return this;
	}

}
