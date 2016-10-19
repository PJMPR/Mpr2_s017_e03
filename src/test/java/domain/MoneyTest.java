package domain;


import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void testMultiplication(){
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	} 
	
	@Test
	public void testfrancMultiplication(){
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	} 

	@Test
	public void testEquality(){
		assertEquals(Money.dollar(5), Money.dollar(5));
		assertNotEquals(Money.dollar(5), Money.dollar(6));
		assertEquals(Money.franc(5), Money.franc(5));
		assertNotEquals(Money.franc(5), Money.franc(6));
		assertNotEquals(Money.dollar(5), Money.franc(5));
	}
	
	@Test
	public void testCurrency(){
		assertEquals(Currency.USD, Money.dollar(1).currency());
		assertEquals(Currency.CHF, Money.franc(1).currency());
	}
	
	@Test
	public void testSimpleAddition(){
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10), result);
	}
	
	@Test
	public void testPlusReturnSumExpression(){
		Money five = Money.dollar(5);
		Money ten = Money.dollar(10);
		Sum sum = five.plus(ten);
		assertEquals(five, sum.augend);
		assertEquals(ten, sum.addend);
	}
	
	@Test
	public void testReduceSum(){
		Sum sum = new Sum(Money.dollar(5),Money.dollar(2));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
		assertEquals(result, Money.dollar(7));
	}
	
	
}























