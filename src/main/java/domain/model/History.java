package domain.model;

import java.math.BigDecimal;
import java.sql.Date;

public class History {

    private int id;
    private Date date;
    private Operation operation;
    private BigDecimal amount;
    private Wallet from;
    private Wallet to;
    private double rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Wallet getFrom() {
        return from;
    }

    public void setFrom(Wallet from) {
        this.from = from;
    }

    public Wallet getTo() {
        return to;
    }

    public void setTo(Wallet to) {
        this.to = to;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


}
