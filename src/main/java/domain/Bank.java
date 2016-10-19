package domain;

public class Bank {

    public Money reduce(Expression sum, Currency currency) {
        return sum.executeExpression();
    }

}
