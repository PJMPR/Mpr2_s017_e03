package rest.dto;

import domain.model.Currency;
import domain.model.Person;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * @author L on 25.01.2017.
 */
public class WalletDto {

    private int id;
    private Currency currency;
    private BigDecimal asset;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAsset() {
        return asset;
    }

    public void setAsset(BigDecimal asset) {
        this.asset = asset;
    }

}
