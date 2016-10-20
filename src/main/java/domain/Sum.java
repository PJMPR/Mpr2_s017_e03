/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

public class Sum implements Expression {

    public final Expression augend;
    public final Expression addend;
    public ArrayList<Expression> additions; 
    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank,Currency currency) {
        int amount = bank.reduce(augend, currency).amount + bank.reduce(addend, currency).amount;
        if(additions!=null){
            for (Expression expression:additions){
                amount=amount+expression.reduce(bank, currency).amount;
            }
        }
        return new Money(amount, currency);
    }
    
    public Expression plus(Expression expression){
        //Inicializujemy tablicę kolejnych
        if(additions==null){
            additions=new ArrayList<Expression>();
        }
        //Dodajemy nowy element
        additions.add(expression);
        
        return this;
    }

}
