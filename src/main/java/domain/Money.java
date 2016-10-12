package domain;

public class Money {

    private int amount;

    public int getAmount() {
        return amount;
    }

    
    public Money(int amount) {
        this.amount = amount;
    }

    

    public boolean equals(Object other) {
        
        if(!other.getClass().equals(this.getClass())) return false;

        Money money = (Money) other;
        return money.amount == this.amount;
    }

}
