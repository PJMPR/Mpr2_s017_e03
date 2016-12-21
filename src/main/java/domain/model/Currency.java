package domain.model;

public enum Currency {
    USD(1,"Dolar",1.0364), CHF(2,"Frank",1.0687), PLN(3,"Złotówka",4.4095), JPN(4,"Jen",122.43);
    private String longName;
    private double rate;
    
    Currency(int intKey,String longName,double rate){
        this.longName=longName;
        this.rate=rate;
    }
    public String getLongName(){
        return longName;
    }
}
