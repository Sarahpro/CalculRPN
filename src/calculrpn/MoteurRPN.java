package calculrpn;

import java.util.Stack;

public class MoteurRPN {
	
	private Stack <Double> operandes;
	private static int MIN_VALUE = 0;
	private static int MAX_VALUE = 31000;
	
	public MoteurRPN() {
		operandes = new Stack <Double> ();
	}
	
	/**
	 * Question a
	 * @param d : opérande à stocker dans la pile d'opérandes
	 * @return void
	 * @throws RPNException si la valeur du double n'est pas compris dans l'intervalle [ MIN_VALUE, MAX_VALUE ] en valeur absolue
	 */
	public void addOperande(double d) throws RPNException {
		double tmp = Math.abs(d);
		if(tmp > MAX_VALUE || tmp < MIN_VALUE) throw new RPNException(d);
		operandes.push(d);
	}
	
	/**
	 * Question b
	 * @param o : opérateur pour le calcul entre les 2 opérandes en haut de la pile d'opérandes
	 * @throws RPNException si le contenu de la pile d'opérandes n'est pas d'au moins 2 éléments
	 */
	public void operation(Operation o) throws RPNException {
		if(operandes.size() > 1) {
			double op2 = operandes.pop();
			double op1 = operandes.pop();
			double res = o.eval(op1,op2);
			System.out.println(" = " + res);
			addOperande(res);
		}
		else throw new RPNException(operandes);
	}
	
	/**
	 * Question c
	 * @return la pile d'opérandes
	 */
	public Stack <Double> getOperandes(){
		return operandes;
	}
	
	public static int getMIN_VALUE() {
		return MIN_VALUE;
	}

	public static void setMIN_VALUE(int MIN_VALUE) {
		MoteurRPN.MIN_VALUE = Math.abs(MIN_VALUE);
	}

	public static int getMAX_VALUE() {
		return MAX_VALUE;
	}

	public static void setMAX_VALUE(int MAX_VALUE) {
		MoteurRPN.MAX_VALUE = Math.abs(MAX_VALUE);
	}

}
