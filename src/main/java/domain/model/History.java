/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

import java.sql.Date;

/**
 *
 * @author mati
 */
public class History implements IHaveId{
    
    private Integer id;
    private Date date;
    private Double amount;
    private Wallet From;
    private Wallet To;
    private Double rate;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public void setRate(Double rate) {
        this.rate = rate;
    }

    public History(Integer id, Date date, Integer operationId, Double amount, Integer fromWalletId, Integer toWalletId, Double rate) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.rate = rate;
    }

    public History() {
        
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }


    public Double getRate() {
        return rate;
    }

	public Wallet getFrom() {
		return From;
	}

	public void setFrom(Wallet from) {
		From = from;
	}

	public Wallet getTo() {
		return To;
	}

	public void setTo(Wallet to) {
		To = to;
	}
    

    
    
    
}
