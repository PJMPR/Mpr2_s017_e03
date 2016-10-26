package domain.model;

/**
 * Created by L on 26.10.2016.
 */
public class Wallet {

    private int id;
    private double asset;
    private Currency currency;
    private Person personId;


    public Wallet(int id, double asset, Currency currency, Person personId) {
        this.id = id;
        this.asset = asset;
        this.currency = currency;
        this.personId = personId;
    }
}
