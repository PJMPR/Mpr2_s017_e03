/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

public class Sum implements Expression {

    public final Money augend;
    public final Money addend;
    private final Money[] augs;

    public Sum(Money... augs) {
        this.augend = augs[0];
        this.addend = augs[1];
        this.augs = augs;
    }

    public Money executeExpression() {
        int returnValue = 0;
        for (Money money : augs) {
            returnValue = returnValue + money.getAmount();
        }
        return new Money(returnValue, augend.currency());
    }

}
