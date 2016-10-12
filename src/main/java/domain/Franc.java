package domain;

public class Franc extends Money {

    public Franc(int amount) {
        super(amount);
    }

    public Franc times(int multiplier) {
        return new Franc(this.getAmount() * multiplier);
    }
    
    {
        System.out.println( "test" );
    }

}
