package domain;

import org.junit.Test;

import junit.framework.TestCase;

public class MoneyTest extends TestCase {

	
	@Test
	public void testMultiplication(){
		Dollar five = new Dollar(5);
		Dollar product = five.times(2);
		assertEquals(10, product.amount);
		product = five.times(3);
		assertEquals(15, product.amount);
	} 
        
        
        @Test
	public void testEquality(){
		assertEquals(new Dollar(5), new Dollar(5));
	}
}