package practise_set_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyPractise {
	
	private static String BOARD_DATA = "ABCDEFGHIJKLMNOP";
	
	private String[][] board;
	
	
	public static void main(String[] args){
		MyPractise obj = new MyPractise();
		obj.run();
	}
	
	private void run(){
		board = getBoard();
		printBoard();
		
		/*
		String UsersWord = "FINK";
		if(searchHumanWord(UsersWord)){
			System.out.println("Found");
		}else{
			System.out.println("Not Found");
		}*/
		computerSearch(BOARD_DATA);
	}
	
	private void computerSearch(String word){
		computerSearchHelper(word);
		
	}
	
	private void computerSearchHelper(String word){
		if(word.length() == 4){
			//System.out.println("*BASE Calling Permutation for : " + word);
			//permute(word);
		}else{
			//System.out.println("Calling Permutation for : " + word);
			//permute(word);
			word = cutOffTheFirstLetter(word);
			computerSearchHelper(word);
			
		}
	}
	
	

	
	private boolean searchHumanWord(String word){
		boolean result = false;
		Set<String> usedIndecies = new HashSet<>();
		for(int row=0; row < board.length; row++){
			for(int col=0; col < board.length; col++){
				usedIndecies.add("" + row + "" + col);
				result = searchHumanWordHelper(word, row, col, usedIndecies);
				if(result){
					return result;
				}
				usedIndecies.clear();
			}
		}
		return result;
	}

	private boolean searchHumanWordHelper(String word, int row, int col, Set<String> usedIndecies){
		System.out.println("Word : " + word + " Comapre Index " + row + col + " Value " 
				+ board[row][col] + " Used Index : " + usedIndecies);
		usedIndecies.add(row + "" + col);
		boolean result = false;
		if(word.length() == 0){
			result = true;
		}else{
			String firstLetter = word.charAt(0) + "";
			if(firstLetter.equals(board[row][col])){
				word = cutOffTheFirstLetter(word);
				for(int i=-1; i<2; i++){
					for(int j=-1; j<2; j++){
						if(!usedIndecies.contains((row+i) + "" + (col+j))){
							//System.out.println("Index: " + row + col + " Exploring Index : " + (row+i) + (col+j));
							result = chekThisLetter(word, row+i, col+j, usedIndecies);
							if(result){
								return result;
							}
						}
					}
				}
			}
		}
		return result;
	}
	private boolean chekThisLetter(String word, int row, int col, Set<String> usedIndecies){
		boolean result = false;
		if(word.length() != 0){
			String firstLetter = word.charAt(0) + "";
			if(row>=0 && col >= 0 && row<4 && col<4){
				if(firstLetter.equals(board[row][col])){
					result = searchHumanWordHelper(word, row, col, usedIndecies);
				}
			}
			
		}else{
			result = true;
		}
		return result;
	}
	
	
	private String cutOffTheFirstLetter(String word){
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<word.length(); i++){
			sb.append(word.charAt(i));
		}
		return sb.toString();
	}
	
	
	
	
	private void printBoard(){
		for(int row =0; row < board.length; row ++){
			for(int col=0; col < board.length; col++){
				System.out.print("  " + board[row][col]);
			}
			System.out.println();
		}
	}
	private String[][] getBoard(){
		int row = 0;
		int col = 0;
		String[][] board = new String[4][4];
		for(int i=0; i<16; i++){
			if(col > 3){
				col = 0;
				row ++;
			}
			board[row][col] = BOARD_DATA.charAt(i) + "";
			col++;
		}
		return board;
	}
}

