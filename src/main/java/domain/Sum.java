package domain;

public class Sum implements Expression {

    public final Money augend;
    public final Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Currency currency) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, currency);
    }

}
