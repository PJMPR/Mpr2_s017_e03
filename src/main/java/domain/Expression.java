package domain;

import domain.model.Currency;

public interface Expression {

    Money reduce(Currency currency);
    Money reduce(Bank bank, Currency currency);

}
