package domain;

public class Dollar extends Currency{

    public Dollar(int amount) {
        super(amount);
    }

    
	public Dollar times(int multiplier) {
		return new Dollar( this.getAmount() * multiplier);
	}

}
