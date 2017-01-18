/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

/**
 * @author mati
 */
@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "walletTo.id", query = "SELECT h from History h where h.toWalletId.id = Wallet .id"),
        @NamedQuery(name= "walletFrom.id", query = "SELECT h from History h where h.fromWalletId.id = Wallet .id")
})
public class History implements IHaveId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Float amount;
    @OneToOne
    private Wallet fromWalletId;
    @OneToOne
    private Wallet toWalletId;
    private Double rate;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public void setFromWalletId(Wallet fromWalletId) {
        this.fromWalletId = fromWalletId;
    }

    public void setToWalletId(Wallet toWalletId) {
        this.toWalletId = toWalletId;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public History(Integer id, Date date, Float amount, Wallet fromWalletId, Wallet toWalletId, Double rate) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.rate = rate;
    }

    public History() {

    }

    public Wallet getFromWalletId() {
        return fromWalletId;
    }

    public Wallet getToWalletId() {
        return toWalletId;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }


    public Float getAmount() {
        return amount;
    }


    public Double getRate() {
        return rate;
    }


}
