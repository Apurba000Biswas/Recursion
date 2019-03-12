package practise_set_1;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RecursionProb {
	
	private static final String FILE_NAME = "D:/Project/Recursion/cs106b-prereq.txt";
	
	public static void main(String[] args){
		RecursionProb obj = new RecursionProb();
		obj.run();
	}
	
	private void run(){
		System.out.println("Factorial of 5 : " + factorial(5));
		System.out.println("Double of 10 MnM in a bowl : " + doubleMnM(10));
		
		//System.out.println("Moving 5 Discs " );
		//moveDiscs(5, 1, 3);
		
		System.out.println("Greates Common Divisor(Ecluids Algorithm) of 42 & 24 : ");
		int gcd = findGCD(42, 24);
		System.out.println("GCD Result is: " + gcd + "\n\n");
		
		
		Map<String, List<String>> courseSeqMap = getCourseSeq();
		personalCurriculum(courseSeqMap, "dijkstra");
	}
	
	private Map<String, List<String>> getCourseSeq(){
		Map<String, List<String>> courseSeqMap = new HashMap<>();
		Path path = Paths.get(FILE_NAME);
		try{
			Scanner scanner = new Scanner(path);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				int keyBreakIndex = line.indexOf(':');
				String key = line.substring(0,keyBreakIndex);
				List<String> values = getValues(line.substring(keyBreakIndex+1));
				courseSeqMap.put(key, values);
			}
			scanner.close();
		}catch(IOException e){
			System.out.println("??? " + e.getMessage());
		}
		return courseSeqMap;
	}
	
	private List<String> getValues(String vStr){
		List<String> values = new ArrayList<>();
		StringBuilder strBuilder = new StringBuilder();
		for(int i=0; i < vStr.length(); i++){
			char ch = vStr.charAt(i);
			
			if(ch == ','){
				values.add(strBuilder.toString());
				strBuilder = new StringBuilder();
			}else{
				strBuilder.append(ch);
			}
		}
		values.add(strBuilder.toString());
		return values;
	}
	
	private void personalCurriculum(Map<String, List<String>> courseSeqMap, String goal){
		Set<String> window = new HashSet<>();
		if(!courseSeqMap.containsKey(goal)){
			System.out.println("No Sequence Found");
		}else{
			buildCurriculamMap(courseSeqMap, goal, window);
			System.out.println(goal);
		}
	}
	
	private void buildCurriculamMap(Map<String, List<String>> courseSeqMap,
			String goal, Set<String> window){
		window.add(goal); // make the goal visited
		if(courseSeqMap.containsKey(goal)){
			// recursive case
			List<String> squences = courseSeqMap.get(goal);
			for(String currSeq : squences){
				if(!window.contains(currSeq)){
					// its not visited before
					buildCurriculamMap(courseSeqMap, currSeq, window);
					System.out.println( currSeq);
				}
			}
		}// else base case
	}
	
	
	
	private int findGCD(int a, int b){
		return gcd(a, b);
	}
	
	private int gcd(int a, int b){
		System.out.print("gcd(" + a + ", " + b + ") = " );
		if(b == 0){
			// base case
			System.out.println(a);
			return a;
		}else{
			// recursive case
			int r = a%b;
			System.out.println("gcd(" + b + ", " + r + ")" );
			return gcd(b, r);
		}
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
	
	private void moveDiscs(int numOfDiscs, int startPeg, int endPeg){
		System.out.println("Num of Discs : " + numOfDiscs + " --- Start Peg : " + startPeg + " --- End Peg : " + endPeg);
		if(numOfDiscs == 0){
			
		}else{
			int thirdPeg = getThirdPeg(startPeg, endPeg);
			moveDiscs(numOfDiscs-1, startPeg, thirdPeg);
			moveDiscs(numOfDiscs-1, thirdPeg, endPeg);
		}
	}
	
	private int getThirdPeg(int startPeg, int endPeg){
		
		if(startPeg == 1 && endPeg == 2){
			return 3;
		}else if(startPeg == 1 && endPeg == 3){
			return 2;
		}else if(startPeg == 2 && endPeg == 1){
			return 3;
		}else if(startPeg == 2 && endPeg == 3){
			return 1;
		}else if(startPeg == 3 && endPeg == 1){
			return 2;
		}else if(startPeg == 3 && endPeg == 2){
			return 1;
		}else{
			return 0;
		}
	}
}
