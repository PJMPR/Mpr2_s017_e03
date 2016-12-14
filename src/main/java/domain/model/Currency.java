package domain.model;

public enum Currency {
    USD("Dolar"), CHF("Frank"), PLN("Złotówka"), JPN("Jen");
    private String longName;
    Currency(String longName){
        this.longName=longName;
    }
    public String getLongName(){
        return longName;
    }
}
