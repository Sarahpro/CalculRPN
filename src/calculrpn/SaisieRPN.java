package CalculRPN;

import java.util.Scanner;

public class SaisieRPN {
	private Scanner s;
	
	public SaisieRPN() {
		s = new Scanner(System.in);
	}
	
	/*Saisie morceau par morceau des éléments de calcul.
	et s'arrete lorsque l'utilisateur entre 'f' ou en cas de saisie invalide.*/
	public void input(MoteurRPN m) throws RPNException {
		double d;
		boolean continuer = true;
		System.out.print("Saisissez votre calcul dans cet ordre :\n" 
		+ "- un nombre (un par un)\n"
		+ "- une opération parmis {+,-,*,/} (un par un)\n"
		+ "- \"exit\" pour terminer\n>");
		while(continuer) {
			try {
				d = s.nextDouble();
				m.addOperande(d);
				System.out.print("\nExpression : "+ m.getOperandes() + "\n>");
			}
			catch(java.util.InputMismatchException e) {
				continuer = false;
			}
		}
		String line = s.nextLine();
		if(line.length() > 1 && !line.equalsIgnoreCase("exit")) throw new RPNException(line);
		while(line.length() == 1) {
			if     (line.equalsIgnoreCase("+")) m.operation(Operation.PLUS);
			else if(line.equalsIgnoreCase("-")) m.operation(Operation.MOINS);
			else if(line.equalsIgnoreCase("*")) m.operation(Operation.MULT);
			else if(line.equalsIgnoreCase("/")) m.operation(Operation.DIV);
			else if(line.equalsIgnoreCase("exit"));
			else throw new RPNException(line);
			System.out.print("\nExpression : "+ m.getOperandes() + "\n>");
			line = s.nextLine();
		}
	}
}
