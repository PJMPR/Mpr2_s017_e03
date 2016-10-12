package domain;

import com.amazonaws.services.cloudfront.model.UpdateStreamingDistributionRequest;

public abstract class Money {

    private int amount;

    public int getAmount() {
        return amount;
    }
    
    public Money(int amount) {
        this.amount = amount;
    }

    public static Dollar dollar(int amount){
        return new Dollar(amount);
    }
    
    public static Franc franc(int amount){
        return new Franc(amount);
    }
   
    public abstract Money times(int multiplier);
    
    public boolean equals(Object other) {
        Money money = (Money) other;
        return money.amount == this.amount 
        		&& other.getClass().equals(this.getClass());
    }





}
