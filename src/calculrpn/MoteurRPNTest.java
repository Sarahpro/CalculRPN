package calculrpn;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoteurRPNTest{

	@Test
	public void testAjoutOperandes() throws RPNException {
		MoteurRPN.MIN_VALUE = 0;
		MoteurRPN.MAX_VALUE = 31000;
		MoteurRPN m = new MoteurRPN();
		m.addOperande(145);
		m.addOperande(123);
		assertEquals(m.getOperandes().toString(), "[145.0, 123.0]");
	}
	
	@Test
	public void testCalcul() throws RPNException {
		MoteurRPN.MIN_VALUE = 0;
		MoteurRPN.MAX_VALUE = 31000;
		MoteurRPN m = new MoteurRPN();
		m.addOperande(5);
		m.addOperande(3);
		m.addOperande(4);
		m.operation(Operation.PLUS);
		m.operation(Operation.MULT);
		double d = m.getOperandes().pop();
		assertTrue(d == 35.0);
	}
	
	@Test(expected=RPNException.class)
	public void testCalculFail() throws RPNException {
		MoteurRPN.MIN_VALUE = 0;
		MoteurRPN.MAX_VALUE = 31000;
		MoteurRPN m = new MoteurRPN();
		m.addOperande(5);
		m.addOperande(3);
		m.operation(Operation.PLUS);
		m.operation(Operation.MULT);
		//exception
	}
	
	@Test(expected=RPNException.class)
	public void testCalculFail2() throws RPNException {
		MoteurRPN.MIN_VALUE = 0;
		MoteurRPN.MAX_VALUE = 31000;
		MoteurRPN m = new MoteurRPN();
		m.operation(Operation.MULT);
		//exception
	}
	
	@Test(expected=RPNException.class)
	public void testMAX_VALUE() throws RPNException {
		MoteurRPN.MIN_VALUE = 0;
		MoteurRPN.MAX_VALUE = 31000;
		MoteurRPN m = new MoteurRPN();
		m.addOperande(31001);
		//exception
	}
	
	@Test(expected=RPNException.class)
	public void testMIN_VALUE() throws RPNException {
		MoteurRPN.MIN_VALUE = 5;
		MoteurRPN.MAX_VALUE = 31000;
		MoteurRPN m = new MoteurRPN();
		m.addOperande(-4);
		//exception
	}
	
	@Test
	public void testGreat_VALUE() throws RPNException {
		MoteurRPN.MIN_VALUE = 5;
		MoteurRPN.MAX_VALUE = 31000;
		MoteurRPN m = new MoteurRPN();
		m.addOperande(-6);
	}
}