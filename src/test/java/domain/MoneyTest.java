package domain;


import domain.model.Currency;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MoneyTest {

	@Test
	public void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}

	@Test
	public void testfrancMultiplication() {
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	}

	@Test
	public void testEquality() {
		assertEquals(Money.dollar(5), Money.dollar(5));
		assertNotEquals(Money.dollar(5), Money.dollar(6));
		assertEquals(Money.franc(5), Money.franc(5));
		assertNotEquals(Money.franc(5), Money.franc(6));
		assertNotEquals(Money.dollar(5), Money.franc(5));
	}

	@Test
	public void testCurrency() {
		assertEquals(Currency.USD, Money.dollar(1).currency());
		assertEquals(Currency.CHF, Money.franc(1).currency());
	}

	@Test
	public void testSimpleAddition() {
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money result = bank.reduce(sum, Currency.USD);
		assertEquals(Money.dollar(10), result);
	}

	@Test
	public void testPlusReturnSumExpression() {
		Money five = Money.dollar(5);
		Money ten = Money.dollar(10);
		Sum sum = five.plus(ten);
		assertEquals(five, sum.augend);
		assertEquals(ten, sum.addend);
	}

	@Test
	public void testReduceSum() {
		Sum sum = new Sum(Money.dollar(5), Money.dollar(2));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, Currency.USD);
		assertEquals(result, Money.dollar(7));
	}

	@Test
	public void testReduceMoney() {
		Money five = Money.dollar(5);
		Bank bank = new Bank();
		Money result = bank.reduce(five, Currency.USD);
		assertEquals(five, result);
	}

	@Test
	public void testReduceMoneyDefferentCurrency() {
		Bank bank = new Bank();
		bank.addRate(Currency.CHF, Currency.USD, 2);
		Money result = bank.reduce(Money.franc(2), Currency.USD);
		assertEquals(result, Money.dollar(1));
	}

	//1
	@Test
	public void testMixedAddition() {
		Money fiveBucks = Money.dollar(5);
		Money tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate(Currency.CHF, Currency.USD, 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), Currency.USD);
		assertEquals(Money.dollar(10), result);
	}

	//2
	@Test
	public void testSumPlusMoney() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate(Currency.CHF, Currency.USD, 2);
		Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
		Money result = bank.reduce(sum, Currency.USD);
		assertEquals(Money.dollar(15), result);
	}


	//3
	@Test
	public void testSumTimes(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate(Currency.CHF,Currency.USD,2);
		Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
		Money result = bank.reduce(sum, Currency.USD);
		assertEquals(Money.dollar(20), result);
		
	}

}























