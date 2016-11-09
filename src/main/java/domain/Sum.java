package domain;

import domain.model.Currency;

public class Sum implements Expression {


    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, Currency currency) {
        return new Money(
                addend.reduce(bank, currency).amount
                        + augend.reduce(bank, currency).amount
                , currency);
    }

    public Sum plus(Expression money) {
        return new Sum(this, money);
    }

    public Expression times(int multiplier) {
        return new Sum(
                this.augend.times(multiplier),
                this.addend.times(multiplier)
        );
    }

}
