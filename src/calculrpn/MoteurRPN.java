package calculrpn;

import java.util.Stack;

public class MoteurRPN {
	private Stack <Double> operandes;
	public static int MIN_VALUE = 0;
	public static int MAX_VALUE = 31000;
	
	public MoteurRPN() {
		operandes = new Stack <Double> ();
	}
	
	/*Question a*/
	
	//@param double d : valeur à stocker dans la pile d'opérandes
	public void addOperande(double d) throws RPNException {
		int tmp = (int)((d < 0)? -d : d);
		if(tmp > MAX_VALUE || tmp < MIN_VALUE) throw new RPNException(tmp);
		operandes.push(d);
	}
	
	/*Question b*/
	
	//@param Opération o : opérateur pour le calcul entre les 2 opérandes en haut de la pile d'opérandes
	//@throws RPNException si le contenu de la pile d'opérandes n'est pas d'au moins 2 éléments
	public void operation(Operation o) throws RPNException {
		if(operandes.size() > 1) {
			double op2 = operandes.pop();
			double op1 = operandes.pop();
			double res = o.eval(op1,op2);
			System.out.println(" = " + res);
			operandes.push(res);
		}
		else throw new RPNException(operandes);
	}
	
	/*Question c*/
	
	//@return la pile d'opérandes
	public Stack <Double> getOperandes(){
		return operandes;
	}
}
