package domain;

import java.util.HashMap;

public class Bank {

    HashMap<Currency, HashMap<Currency, Integer>> rateMap;

    public Bank() {
        this.rateMap = new HashMap<Currency, HashMap<Currency, Integer>>();
    }

    /**
     * Dodanie nowego przelicznika
     * @param baseCurrency - bazowa waluta
     * @param toCurrency - docelowa waluta
     * @param rate - przelicznik
     * @return 
     */
    public Boolean addRate(Currency baseCurrency, Currency toCurrency, Integer rate) {
        //Sprawdzenie czy już ustawiona bazowa waluta
        if (rateMap.get(baseCurrency) != null) {
            //Ustawienie przelicznika 
            rateMap.get(baseCurrency).put(toCurrency, rate);
            return true;
        } else {
            //Ustawienie w mapie nowej bazowej waluty
            rateMap.put(baseCurrency, new HashMap<Currency, Integer>());
            //Dodanie przelicznika
            rateMap.get(baseCurrency).put(toCurrency, rate);
            return true;
        }
    }

    public Money reduce(Expression expression, Currency currency) {
        //Sprawdzamy czy jest przelicznik dla danej waluty
        if(rateMap.containsKey(expression.reduce(this, currency).currency())){
            //Sprawdzamy czy jest przeliczenie na daną walutę
            if(rateMap.get(expression.reduce(this, currency).currency()).containsKey(currency)){
                //Pobieramy przelicznik
                Integer reducer=rateMap.get(expression.reduce(this, currency).currency()).get(currency);
                //Zwracamy przeliczony banknot z nową walutą
                return new Money(expression.reduce(this, currency).amount/reducer, currency);
            }
            else{
                //Brak przelicznika więc zwracamy siebie 
                //TODO jakis exception?
                return expression.reduce(this, currency);
            }
        }else
        {
            //Brak przelicznika dla danej waluty więc zwracamy siebie
            //TODO jakiś exception
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
//    public Money reduce(Money money, Currency currency) {
//        //Sprawdzamy czy jest przelicznik dla danej waluty
//        if(rateMap.containsKey(money.currency)){
//            //Sprawdzamy czy jest przeliczenie na daną walutę
//            if(rateMap.get(money.currency).containsKey(currency)){
//                //Pobieramy przelicznik
//                Integer reducer=rateMap.get(money.currency).get(currency);
//                //Zwracamy przeliczony banknot z nową walutą
//                return new Money(money.amount/reducer, currency);
//            }
//            else{
//                //Brak przelicznika więc zwracamy siebie 
//                //TODO jakis exception?
//                return money;
//            }
//        }else
//        {
//            //Brak przelicznika dla danej waluty więc zwracamy siebie
//            //TODO jakiś exception
//            return money;
//        }
//    }

}
