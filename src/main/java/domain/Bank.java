package domain;

import java.util.HashMap;

public class Bank {

    private HashMap<Currency, HashMap<Currency, Integer>> rateMap;

    public Bank() {
        this.rateMap = new HashMap<Currency, HashMap<Currency, Integer>>();
    }

    public Boolean addRate(Currency baseCurrency, Currency toCurrency, Integer value) {
        if (rateMap.get(baseCurrency) != null) {
            rateMap.get(baseCurrency).put(toCurrency, value);
            return true;
        } else {
            rateMap.put(baseCurrency, new HashMap<Currency, Integer>());
            rateMap.get(baseCurrency).put(toCurrency, value);
            return true;
        }
    }



    public Money reduce(Expression expression, Currency currency) {
        if (rateMap.containsKey(expression.reduce(currency).currency)
                && rateMap.get(expression.reduce(currency).currency).containsKey(currency)) {
            return new Money(
                    ((Money) expression).getAmount()
                    / rateMap.get(((Money) expression).currency).get(currency), currency);
        } 
            else {
            return expression.reduce(currency);
        }
    }

    public HashMap<Currency, HashMap<Currency, Integer>> getRateMap() {
        return rateMap;
    }
}
