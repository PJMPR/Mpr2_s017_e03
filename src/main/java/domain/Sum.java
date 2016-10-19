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

    public Money reduce( Currency currency) {

      if(addend.currency() != augend.currency()){
          Bank bank = new Bank();
          return new Money(bank.reduce(addend,augend.currency).getAmount(),currency);
      }
          int amount = augend.amount + addend.amount;
        return new Money(amount, currency);
    }


}
