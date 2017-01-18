/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.App;
import domain.model.Currency;
import domain.model.EnumDictionary;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TemporaryCurrencyEnumHelper {

    public void insertCurrencyEnums() {
        
    	RepositoryCatalog repo = null;
        try {
            repo = new RepositoryCatalog(App.CONNECTION_STRING);
            EnumDictionaryRepository enumRepo = (EnumDictionaryRepository) repo.Dictionaries();

            for (int i=0 ;i<Currency.values().length;i++){
                
                EnumDictionary enumDict=new EnumDictionary();
                
                //enumDict.setId(i);
                enumDict.setEnumerationName("Currency");
                enumDict.setValue(Currency.values()[i].getLongName());
                enumDict.setIntKey(Currency.values()[i].getIntKey());
                enumDict.setStringKey(Currency.values()[i].toString());
                enumRepo.add(enumDict);
            }
            
            repo.saveAndClose();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
