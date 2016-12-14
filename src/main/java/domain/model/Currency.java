package domain.model;

public enum Currency {
    USD(1,"Dolar"), CHF(2,"Frank"), PLN(3,"Złotówka"), JPN(4,"Jen");
    private String longName;
    
    Currency(int intKey,String longName){
        this.longName=longName;
    }
    public String getLongName(){
        return longName;

    }
}
