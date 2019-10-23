package calculrpn;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Test;

public class SaisieRPNTest {
	
	InputStream stdin = System.in;
	
	@After
	public void tearDown() throws Exception {
		System.setIn(stdin);
	}

	@Test
	public void testcalculreussi() throws RPNException {
		String e = "8\n4\n15\n12\n2\n+\n-\n*\n/\nexit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		assertTrue(s.calcul() == 2.0);
	}
	
	@Test
	public void test1operande() throws RPNException {
		String e = "8\nexit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		assertTrue(s.calcul() == 8.0);
	}
	
	@Test(expected = RPNException.class)
	public void testecheccalcul1() throws RPNException {
		String e = "8\n+\nexit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
		//exception
	}
	
	@Test(expected = RPNException.class)
	public void testPasD_operandes() throws RPNException {
		String e = "+\nexit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
		//exception
	}
	
	@Test(expected = RPNException.class)
	public void testOperandeApresOperateur() throws RPNException {
		String e = "8\n7\n+\n6\nexit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
		//exception
	}
	
	@Test(expected = RPNException.class)
	public void testlettres() throws RPNException {
		String e = "salut\nexit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
		//exception
	}
	
	@Test(expected = RPNException.class)
	public void testlettresApresOperandes() throws RPNException {
		String e = "8\n7\n+\nz\nexit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
		//exception
	}
	
	@Test(expected = RPNException.class)
	public void testExit() throws RPNException {
		String e = "exit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
		//exception
	}
	
	@Test(expected = RPNException.class)
	public void test2OperandesFin() throws RPNException {
		String e = "2\n3\nexit\n";
		System.setIn(new ByteArrayInputStream(e.getBytes()));
		SaisieRPN s = new SaisieRPN();
		s.calcul();
		//exception
	}

}
