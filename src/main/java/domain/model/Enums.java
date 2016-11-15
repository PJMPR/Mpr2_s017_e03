package domain.model;

import javax.persistence.*;

import dao.RepositoryBase;
import domain.model.Currency;

@Entity
@Table(name="enums")
public class Enums{
	private int id, intkey;
	private String stringKey, value, enumerationName;
	
	@Id
	@Column(name="currency", columnDefinition="enum", length = 20)
	@Enumerated(EnumType.STRING)
	
	private Currency currency;
	
	public Currency getCurrency(){
		return currency;
	}
	
	public void setCurrency(Currency cur){
		this.currency = currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIntkey() {
		return intkey;
	}

	public void setIntkey(int intkey) {
		this.intkey = intkey;
	}

	public String getStringKey() {
		return stringKey;
	}

	public void setStringKey(String stringKey) {
		this.stringKey = stringKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getEnumerationName() {
		return enumerationName;
	}

	public void setEnumerationName(String enumerationName) {
		this.enumerationName = enumerationName;
	}
	
	
}


