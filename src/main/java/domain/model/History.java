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
public class History {
    
    private Integer id;
    private Date date;
    private Integer operationId;
    private Float amount;
    private Integer fromWalletId;
    private Integer toWalletId;
    private Double rate;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setFromWalletId(Integer fromWalletId) {
        this.fromWalletId = fromWalletId;
    }

    public void setToWalletId(Integer toWalletId) {
        this.toWalletId = toWalletId;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public History(Integer id, Date date, Integer operationId, Float amount, Integer fromWalletId, Integer toWalletId, Double rate) {
        this.id = id;
        this.date = date;
        this.operationId = operationId;
        this.amount = amount;
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.rate = rate;
    }

    public History() {
        
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public Float getAmount() {
        return amount;
    }

    public Integer getFromWalletId() {
        return fromWalletId;
    }

    public Integer getToWalletId() {
        return toWalletId;
    }

    public Double getRate() {
        return rate;
    }
    

    
    
    
}
