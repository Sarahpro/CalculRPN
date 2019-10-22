package calculrpn;

public enum Operation {
	PLUS ('+'){
		public double eval(double op1, double op2) {
			System.out.print(op1 + " + " + op2);
			return (op1 * 1000 + op2 * 1000) / 1000;
		}
	},
	MOINS ('-'){
		public double eval(double op1, double op2) {
			System.out.print(op1 + " - " + op2);
			return (op1 * 1000 - op2 * 1000) / 1000;
		}
	},
	MULT ('*'){
		public double eval(double op1, double op2) {
			System.out.print(op1 + " * " + op2);
			return op1 * op2;
		}
	},
	DIV ('/'){
		public double eval(double op1, double op2) {
			if(op2 == 0.0) {
				System.out.println("Error : / by zéro");
				throw new ArithmeticException ();
			}
			System.out.print(op1 + " / " + op2);
			return op1 / op2;
		}
	};
	
	private char symbole;
	
	Operation(char operateur){
		symbole = operateur;
	}
	
	public String toString() {
		return "" + symbole;
	}
	
	public abstract double eval(double op1, double op2);
}
