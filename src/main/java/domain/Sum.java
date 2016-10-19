/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

public class Sum implements Expression {

    public final Money augend;
    public final Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Currency currency) {

      if(addend.currency() == Currency.CHF){
          int amount1 = (addend.amount / 2)+ augend.amount;
          return new Money(amount1, currency);
      }
          int amount = augend.amount + addend.amount;

        return new Money(amount, currency);
    }

}
