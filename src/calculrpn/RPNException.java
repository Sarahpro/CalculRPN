package calculrpn;

import java.util.Stack;

@SuppressWarnings("serial")
public class RPNException extends Exception{
	public RPNException() {
		System.out.println("\nException CalculRPN.RPNException: Invalid input.");
	}
	
	public RPNException(double d) {
		System.out.println("\nException CalculRPN.RPNException: " + d + " is out of range, he must be between " 
		+ MoteurRPN.MIN_VALUE + " and " + MoteurRPN.MAX_VALUE + ".");
	}
	
	public RPNException(Stack <Double> operandes) {
		int i = operandes.size();
		if(i == 0)
			System.out.println("\nException CalculRPN.RPNException: No operand found in MoteurRPN.operandes stack.");
		else if(i == 1)
			System.out.println("\nException CalculRPN.RPNException: found just one operand in MoteurRPN.operandes stack.");
		else
			System.out.println("\nException CalculRPN.RPNException: found " + i + " operands in MoteurRPN.operandes stack.\n"
			+ "There should only be one.");
	}
}
