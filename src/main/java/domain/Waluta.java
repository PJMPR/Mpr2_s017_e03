package domain;

public class Waluta {
	
	private int amount;
	
	public Waluta(int amount) {
		this.amount = amount;
	}

	public Waluta times(int multiplier) {
		return new Waluta( amount * multiplier);
	}
	
	public boolean equals(Object other){
		Waluta waluta = (Waluta) other;
		return waluta.amount==this.amount;
	}

}
