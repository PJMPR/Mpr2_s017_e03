/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author mati
 */
public class Sum implements Expression{

    public final Money augend;
    public final Money addend;
    
    
    public Sum(Money add1,Money add2) {
        this.augend=add1;
        this.addend=add2;
    }
    
    
    
}
