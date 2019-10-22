package calculrpn;

import java.util.Stack;

@SuppressWarnings("serial")
public class RPNException extends Exception{
	
	//erreur non indiqué
	public RPNException() {
		System.out.println("\nException CalculRPN.RPNException: Invalid input.");
	}
	
	//problème concernant la valeur du double choisit
	public RPNException(double d) {
		System.out.println("\nException CalculRPN.RPNException: " + d + " is out of range, he must be between " 
		+ MoteurRPN.getMIN_VALUE() + " and " + MoteurRPN.getMAX_VALUE() + " (absolute value).");
	}
	
	//la taille de la pile des opérandes n'est pas correcte pour effectuer le calculRPN
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
	
	//lorsque l'entrée utilisateur n'est ni un nombre ni un opérateur ni "exit"
	public RPNException(String s) {
		System.out.println("\nException CalculRPN.RPNException: \"" + s + "\" is not a number or an operator.");
	}
}
