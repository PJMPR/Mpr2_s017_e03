package domain.model;

import java.util.Date;

/**
 * Created by L on 26.10.2016.
 */
public class History {

    private int id;
    private Date date;
    private Operation operation;
    private double amount;
    private Wallet from;
    private Wallet to;
    private int rate;

    public History(int id, Date date, Operation operation, double amount, Wallet from, Wallet to, int rate) {
        this.id = id;
        this.date = date;
        this.operation = operation;
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
}
