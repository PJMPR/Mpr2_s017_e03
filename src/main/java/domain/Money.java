package domain;

public class Money {
    enum Currency {
        CHF,
        USD
    };
    
    private int amount;
    private Currency currency;
    
    

    public int getAmount() {
        return amount;
    }

    public Money(int amount,Currency currency) {
        this.amount = amount;
        this.currency=currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount,Currency.USD);
    }

    public static Money franc(int amount) {
        return new Money(amount,Currency.CHF);
    }

    public Currency currency(){
        return currency;
    }
    public Money times(int multiplier){
        return new Money(this.getAmount() * multiplier,this.currency());
    }

    public boolean equals(Object other) {
        Money money = (Money) other;
        return money.amount == this.amount
                && ((Money)other).currency==this.currency();
    }

}
