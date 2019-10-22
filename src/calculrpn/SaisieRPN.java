package calculrpn;

import java.util.Scanner;

public class SaisieRPN {
	private Scanner s;
	
	public SaisieRPN() {
	}
	
	/**
	 * Saisie morceau par morceau des éléments de calcul.
	 * s'arrete lorsque l'utilisateur entre "exit" ou en cas de saisie invalide.
	 * @return double correspondant au résultat du calcul
	 * @throws RPNException si les entrées clavier ne respectent pas le calcul RPN
	 */
	public double calcul() throws RPNException {
		s = new Scanner(System.in);
		MoteurRPN m = new MoteurRPN();
		
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
				//si ce n'est plus/pas un nombre, on arrête de tenter de récuperer un nombre et on vérifie si c'est un opérateur ou "exit"
			}
		}
		
		//lis l'entrée clavier qui n'était pas un nombre
		String line = s.nextLine();
		
		//ce n'est ni un opérateur, ni une demande pour quitter ("exit")
		if(line.length() > 1 && !line.equalsIgnoreCase("exit")) throw new RPNException(line);
		
		//s'arrête si ce n'est pas un opérateur qui est écrit
		while(line.length() == 1) {
			
			if     (line.equalsIgnoreCase("+")) m.operation(Operation.PLUS);
			else if(line.equalsIgnoreCase("-")) m.operation(Operation.MOINS);
			else if(line.equalsIgnoreCase("*")) m.operation(Operation.MULT);
			else if(line.equalsIgnoreCase("/")) m.operation(Operation.DIV);
			else if(line.equalsIgnoreCase("exit"));
			
			//si c'est autre chose que "exit ou un opérateur, on fait appel à l'exception RPNException"
			else throw new RPNException(line);
			
			System.out.print("\nExpression : "+ m.getOperandes() + "\n>"); //affichage de l'expression
			
			line = s.nextLine(); //lecture de la prochaine entrée clavier
		}
		
		s.close();
		
		//si on a pas un seul opérande, alors on ne peut pas déterminer le résultat
		if(m.getOperandes().size() != 1) throw new RPNException(m.getOperandes().size());
		
		//retourne le résultat (vide la pile pour effectuer un nouveau calcul si voulu
		return m.getOperandes().pop();
	}
}

/*
 * liste des différents cas d'erreur possibles :
 * 		- le total d'opérandes à la fin du calcul diffère de 1   exemple : "" ou "145, 13"
 * 		- l'entrée clavier n'est pas un nombre, un opérateur parmis {+,-,*,/} ou encore "exit"
 */
