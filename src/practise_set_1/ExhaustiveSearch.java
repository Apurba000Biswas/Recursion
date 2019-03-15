package practise_set_1;

import java.util.ArrayList;
import java.util.List;

public class ExhaustiveSearch {
	
	
	private int calls;
	
	public static void main(String[] args){
		ExhaustiveSearch obj = new ExhaustiveSearch();
		obj.run();
	}
	
	private void run(){
		// Binary
		System.out.println("printBinary(" + 4 + ")");
		printBinary(4);
		
		// dice roll
		System.out.println("diceRoll(3,7)");
		diceRoll(3,7);
		System.out.println("Toatal Calls : " + calls);
		
		// permute List
		System.out.println("Permute - " + "a, b, c, d");
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		permute(list);
		
		// sublist
		System.out.println("Sublist - " + "Jane, Bob, Matt, Sara");
		List<String> sList = new ArrayList<>();
		sList.add("Jane");
		sList.add("Bob");
		sList.add("Matt");
		sList.add("Sara");
		subList(sList);
	}
	
	/* [Jane, Bob, Matt, Sara]
	 * [Jane, Bob, Matt]
	 * [Jane, Bob, Sara]
	 * [Jane, Bob]
	 * [Jane, Matt]
	 * [Jane, sara]
	 * .......
	 * 
	 */
	
	private void subList(List<String> list){
		List<String> choosen = new ArrayList<>();
		subListHelper(list, choosen);
	}
	
	private void subListHelper(List<String> list, List<String> chooen){
		if(list.isEmpty()){
			// base case
		}else{
			// recursive case
		}
	}
	
	
	
	
	/* [a, b, c, d]
	 * [a, b, d, c]
	 * [a, d, b, c]
	 * ....
	 * 
	 */
	private void permute(List<String> list){
		List<String> chosen = new ArrayList<>();
		permuteHelper(list, chosen);
	}
	
	private void permuteHelper(List<String> list, List<String> chosen){
		if(list.isEmpty()){
			// base case
			System.out.println(chosen);
		}else{
			for(int i=0; i<list.size(); i++){
				// choose
				String str = list.get(i);
				chosen.add(str);
				list.remove(i);
				
				// explore
				permuteHelper(list, chosen);
				
				// un-choose
				int lastIndex = chosen.size()-1;
				chosen.remove(lastIndex);
				list.add(i,str);
			}
		}
	}
	
	
	
	
	/*printBinary(2)
	 * 00
	 * 01
	 * 10
	 * 11
	 * printBinary(3)
	 * 000
	 * 001
	 * 010
	 * 011
	 * 100
	 * 101
	 * 110
	 * 111
	 */
	private void printBinary(int digits){
		StringBuilder sbOutput = new StringBuilder();
		printAllBinaryHelper(digits, sbOutput);
	}
	
	private void printAllBinaryHelper(int digits, StringBuilder output){
		if(digits == 0){
			// base case nothing to do
			System.out.println(output.toString());
		}else{
			// recursive case
			String thisOutput = output.toString();
			printAllBinaryHelper(digits-1, output.append(0));
			
			output = new StringBuilder(thisOutput);
			printAllBinaryHelper(digits-1, output.append(1));
		}
	}
	
	
	
	/*diceRoll(2,7)
	 * [1, 6]
	 * [2, 5]
	 * [3, 4]
	 * [4, 3]
	 * [5, 2]
	 * [6, 1]
	 */
	private void diceRoll(int diceNum, int diceSum){
		List<Integer> chosen = new ArrayList<>();
		diceRollHelper(diceNum, diceSum, chosen);
	}
	
	private void diceRollHelper(int diceNum, int diceSum, List<Integer> chosen){
		calls ++;
		if(diceNum == 0){
			// base case - no dice to roll
			if(diceSum == 0){
				System.out.println(chosen);
			}
		}else if(diceSum >= diceNum *1 && diceSum <= diceNum*6){
			// for each rolling 1-6
			for(int i=1; i<=6; i++){
				chosen.add(i);
				diceRollHelper(diceNum-1, diceSum-i, chosen);
				
				int lastIndex = chosen.size()-1;
				chosen.remove(lastIndex);
			}
		}
	}
	
	
	
}
