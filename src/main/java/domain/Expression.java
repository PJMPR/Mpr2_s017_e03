package domain;

public interface Expression {
	Money reduce(Currency currency);
}
