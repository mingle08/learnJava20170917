package algoDemo.recursion;

public class CalNFact {

	public static void main(String[] args) {
		int result = factorial(5);
		System.out.println(result);

	}
	
	public static int factorial(int n) {
		if(n == 1) {
			return n;
		}else {
			return n * factorial(n - 1);
		}
	}

}
