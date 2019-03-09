package practise_set_1;

public class RecursionProb {
	
	public static void main(String[] args){
		RecursionProb obj = new RecursionProb();
		obj.run();
	}
	
	private void run(){
		System.out.println("Factorial of 5 : " + factorial(5));
		System.out.println("Double of 10 MnM in a bowl : " + doubleMnM(10));
	}
	
	private int factorial(int n){
		if(n == 0 || n == 1){
			// base case
			return 1;
		}else{
			// recursive case
			return n * factorial(n-1);
		}
	}
	
	private int doubleMnM(int bowl){
		if(bowl == 0){
			// base case
			return 0; // bowl is empty so pass it back
		}else{
			// recursive case
			bowl = doubleMnM(bowl-1); // pick one MnM then pass it to next
			return bowl + 2; // when bowl comes back put two MnM in it and then pass it back
		}
	}
}
