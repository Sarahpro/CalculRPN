package calculrpn;

public enum CalculatriceRPN {
	
	CALCULATRICE;
	
	public static void main(String[] args) throws RPNException {
		MoteurRPN.setMIN_VALUE(0);
		MoteurRPN.setMAX_VALUE(31000);
		SaisieRPN s = new SaisieRPN();
		double d = s.calcul();
		System.out.println("résultat : " + d);
	}
}
