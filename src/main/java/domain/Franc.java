package domain;

public class Franc extends Money {

    private Currency currency;
    public Franc(int amount) {
        super(amount);
    }

    public Franc times(int multiplier) {
        return new Franc(this.getAmount() * multiplier);
    }

    public Currency currency(){
        return currency.CHF;
    }
}
