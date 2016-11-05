package domain;


import domain.model.Currency;

public class Money implements Expression {

    protected int amount;
    protected Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Currency currency() {
        return this.currency;
    }

    public boolean equals(Object other) {
        Money money = (Money) other;
        return money.amount == this.amount
                && money.currency.equals(this.currency);
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

    public Sum plus(Expression money) {
        return new Sum(this, money);
    }


    public Money reduce(Bank bank, Currency to) {
        int rate = bank.rate(currency(), to);
        return new Money(amount / rate, to);
    }


}
