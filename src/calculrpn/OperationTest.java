package calculrpn;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperationTest {

	@Test
	public void testPLUS() {
		Operation o = Operation.PLUS;
		System.out.println();
		assertTrue(o.eval(5.1, 2.6) == 7.7);
	}

	@Test
	public void testMOINS() {
		Operation o = Operation.MOINS;
		System.out.println();
		assertTrue(o.eval(5.1, 2.6) == 2.5);
	}
	
	@Test
	public void testMULT() {
		Operation o = Operation.MULT;
		System.out.println();
		assertTrue(o.eval(5.1, 2.6) == 13.26);
	}
	
	@Test
	public void testDIV() {
		Operation o = Operation.DIV;
		System.out.println();
		assertTrue(o.eval(5.1, 2) == 2.55);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testDIV_by_zero() {
		Operation o = Operation.DIV;
		System.out.println();
		o.eval(5.1, 0);
		//exception
	}
}
