package domain;

import domain.model.Currency;

public interface Expression {

    Money reduce(Bank bank, Currency currency);

    Money reduce(Currency currency);
}
