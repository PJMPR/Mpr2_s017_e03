package domain.model;

public enum Currency {
    USD(1,"Dolar"), CHF(2,"Frank"), PLN(3,"Złotówka"), JPN(4,"Jen"), EUR(5,"Euro");
    private String longName;
    private int intKey;
    Currency(int intKey,String longName){
        this.longName = longName;
        this.intKey = intKey;
    }
    public String getLongName(){
        return longName;

    }
    
    public int getIntKey(){
    	return intKey;
    }
}
