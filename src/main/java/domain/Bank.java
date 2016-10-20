package domain;

import java.util.HashMap;

public class Bank {

    HashMap<Currency, HashMap<Currency, Integer>> rateMap;

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
        if (rateMap.containsKey(expression.reduce(this, currency).currency)
                && rateMap.get(expression.reduce(this, currency).currency).containsKey(currency)) {
            return new Money(
                    ((Money) expression).getAmount()
                    / rateMap.get(((Money) expression).currency).get(currency), currency);
        } else {
            return expression.reduce(this, currency);
        }
    }

    /**
     * Zmiana banknotu na inna walute
     *
     * @param money Banknot
     * @param currency waluta na którą ma być przeliczone
     * @return
     */
    public Money reduce(Money money, Currency currency) {
        //Sprawdzamy czy jest przelicznik dla danej waluty
        if(rateMap.containsKey(money.currency)){
            //Sprawdzamy czy jest przeliczenie na daną walutę
            if(rateMap.get(money.currency).containsKey(currency)){
                //Pobieramy przelicznik
                Integer reducer=rateMap.get(money.currency).get(currency);
                //Zwracamy przeliczony banknot z nową walutą
                return new Money(money.amount/reducer, currency);
            }
            else{
                //Brak przelicznika więc zwracamy siebie 
                //TODO jakis exception?
                return money;
            }
        }else
        {
            //Brak przelicznika dla danej waluty więc zwracamy siebie
            //TODO jakiś exception
            return money;
        }
    }

}
