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

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class TemporaryCurrencyEnumHelper {

    public static void insertCurrencyEnums() {
        RepositoryCatalog repo = null;
        try {
            repo = new RepositoryCatalog(App.CONNECTION_STRING);
            EnumDictionaryRepository enumRepo = (EnumDictionaryRepository) repo.Dictionaries();

            for (int i=0 ;i<Currency.values().length;i++){
                
                EnumDictionary enumDict=new EnumDictionary();
                
                //enumDict.setId(i);
                enumDict.setEnumerationName(Currency.class.toString());
                enumDict.setValue(Currency.values()[i].getLongName());
                enumDict.setIntKey(i);
                enumDict.setStringKey(Currency.values()[i].toString());
                enumRepo.add(enumDict);
            }
            
            repo.save();
            repo.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
