package domain;

public class Dollar extends Money {

	private Currency currency;
    public Dollar(int amount) {
        super(amount);
    }

    public Dollar times(int multiplier) {
        return new Dollar(this.getAmount() * multiplier);
    }

    public Currency currency(){
		return currency.USD;
	}
}
