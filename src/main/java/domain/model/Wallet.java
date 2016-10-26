package domain.model;

import java.math.BigDecimal;

import domain.Currency;

public class Wallet {

	private int id;
	private int personId;
	private Currency currency;
	private BigDecimal asset;
	private Person person;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	
	
}