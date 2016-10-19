package domain;

public class Money {

    private final int amount;
    protected Currency currency;

    public int getAmount() {
        return amount;
    }

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, Currency.USD);
    }

    public static Money franc(int amount) {
        return new Money(amount, Currency.CHF);
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    public boolean equals(Object other) {
        Money money = (Money) other;
        return money.amount == this.amount
                && money.currency.equals(this.currency);
    }

    public Currency currency() {
        return this.currency;
    }

    public Money plus(Money money) {
        if (!(this.currency() == money.currency())) {
            return null;
            //throw new Exception("Niezgodna waluta");
        } else {
            return new Money(this.getAmount() + money.getAmount(), this.currency());
        }
    }
}
