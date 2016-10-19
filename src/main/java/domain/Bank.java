package domain;

public class Bank {

    public Money reduce(Expression sum, String string) {
        return sum.executeExpression();
    }

}
