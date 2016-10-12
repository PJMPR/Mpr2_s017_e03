package domain;

public class Dollar {

    private int initialAmount;
    public int amount;

    public Dollar(int amount) {
        this.initialAmount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        return this.amount == ((Dollar) obj).amount;
    }

    public Dollar times(int multiplier) {
        amount = initialAmount * multiplier;
        return this;
    }
}
