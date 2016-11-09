package domain;

import domain.model.Currency;

import java.util.Hashtable;

public class Bank {


    private Hashtable<Pair, Integer> rates = new Hashtable<Pair, Integer>();

    public Money reduce(Expression expression, Currency currency) {

        return expression.reduce(this, currency);

    }

    public void addRate(Currency currencyFrom, Currency currencyTo, int rate) {
        rates.put(new Pair(currencyFrom, currencyTo), rate);
    }

    public int rate(Currency currency, Currency to) {
        if (currency == to)
            return 1;
        return rates.get(new Pair(currency, to));
    }


}

class Pair {

    private Currency currencyFrom;
    private Currency currencyTo;

    Pair(Currency currencyFrom, Currency currencyTo) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        return currencyFrom == pair.currencyFrom && currencyTo == pair.currencyTo;

    }

    @Override
    public int hashCode() {
        return 0;
    }
}


