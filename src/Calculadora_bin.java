
public class Calculadora_bin {
	
	public Calculadora_bin() {
	}
	
	public String sumar(String a, String b) {
		int n1 = Integer.parseInt(a, 2);
		int n2 = Integer.parseInt(b, 2);
		int r = n1+n2;
		return Integer.toBinaryString(r);
	}
	public String restar(String a, String b) {
		int n1 = Integer.parseInt(a, 2);
		int n2 = Integer.parseInt(b, 2);
		int r = n1-n2;
		return Integer.toBinaryString(r);
	}
	public String multiplicar(String a, String b) {
		int n1 = Integer.parseInt(a, 2);
		int n2 = Integer.parseInt(b, 2);
		int r = n1*n2;
		return Integer.toBinaryString(r);
	}

}
