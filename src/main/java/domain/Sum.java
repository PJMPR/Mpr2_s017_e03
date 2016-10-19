package domain;

/**
 * Created by L on 19.10.2016.
 */
public class Sum implements Expression {


    public final Money augend;
    public final Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }
}
