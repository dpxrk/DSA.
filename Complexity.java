//First day of class. Introduction to DSA.


public class Complexity {
	//Complexity : O(n), O(n^2);
	
	//O(n) complexity;
	public void numbers(int num1) {
		for (int i = 0; i < num1; i++) {
			System.out.println(i);
		}
	}
	
	
	//O(n^2) complexity
	public void numbers1(int num1) {		
	for (int i = 0; i < num1; i++) {
		for( int k =0; k < num1; k++) {
			System.out.println(k);
			}
		}
	}
	
	
	//O(n) complexity still.
	public void test(int n) {
		for (int i = 0 ; i < n ; i++) {
			// piece of code.
		}
		
		for (int j = 0; j < n; j++) {
			// piece of code.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Complexity test = new Complexity();
		
		test.numbers1(5);
	}

}
