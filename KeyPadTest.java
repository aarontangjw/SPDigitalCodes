import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class KeyPadTest {
	private static Scanner sc;
	
	public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
		System.out.print("Input starting digit: ");
		String digit = sc.nextLine().trim();
		System.out.print("Input word length: ");
		int wordLength = sc.nextInt();

		if(!digit.matches("\\d+") || digit.length() <= 0 || digit.contains("0") || digit.contains("1")) {
			throw new Exception("Please input a valid digit");
		}
		List<String> result = letterCombinations(digit, wordLength);
		java.util.Collections.sort(result);
		System.out.println("Output: " + Arrays.toString(result.toArray()));
		//System.out.println(result.size());
    }
	public static List<String> letterCombinations(String digit, int wordLength) {
	    List<String> results = new ArrayList<String>();
	    int keypadDigit = Integer.parseInt(digit);
	    //System.out.println(keypadDigit);
	    
	    int keypadTraversal1 = keypadDigit - 3; //upwards
	    int keypadTraversal2 = keypadDigit + 3; //downwards
	    int keypadTraversal3 = keypadDigit - 1; //left
	    int keypadTraversal4 = keypadDigit + 1; //right
	    
	    //String letters2 = map.get(Integer.toString(keypadTraversal1).charAt(0)); //Testing the output letters for traversal.
	    //System.out.println(letters2);    
	    
	    //This solution would have provided me with wordlength > 2. No time to continue.
	    /*
	    for(int i=0; i < wordLength; i++) {
	    	List<String> nextResults = new ArrayList<>();
	    	for (String str : results) {
	            for (int j = 0; j < letters.length(); j++) {
	                nextResults.add(str + letters.charAt(j));
	            }
	        }
	    	results = nextResults;
	    }*/
	    
	    //Same digit with same digit
        String letters1 = map.get(digit.charAt(0));
        String startingLetters1 = map.get(digit.charAt(0));
        for(int k = 0; k < letters1.length(); k++) {
        	for(int l = 0; l < startingLetters1.length(); l++){
        		results.add(String.format("%s%s", "\"" + letters1.charAt(k), startingLetters1.charAt(l) + "\""));
        	}
        }
	    
        //Starting digit with upwards digit
	    if(keypadTraversal1 > 0) {
        	String letters2 = map.get(Integer.toString(keypadTraversal1).charAt(0));
        	String startingLetters2 = map.get(digit.charAt(0));
        	for(int k = 0; k < startingLetters2.length(); k++) {
        		for(int l = 0; l < letters2.length(); l++){
        			results.add(String.format("%s%s", "\"" + startingLetters2.charAt(k), letters2.charAt(l) + "\""));
        		}
        	}
	    }
	    
	    //Starting digit with downwards digit
	    if(keypadTraversal2 < 10) {
        	String letters3 = map.get(Integer.toString(keypadTraversal2).charAt(0));
        	String startingLetters3 = map.get(digit.charAt(0));
        	for(int k = 0; k < startingLetters3.length(); k++) {
        		for(int l = 0; l < letters3.length(); l++){
        			results.add(String.format("%s%s", "\"" + startingLetters3.charAt(k), letters3.charAt(l)+ "\""));
        		}
        	}
	    }
	    
	    //Starting digit with left digit
	    if((keypadTraversal3 > 1) && ((keypadTraversal3 != 3) && (keypadTraversal3 != 6))) {
        	String letters4 = map.get(Integer.toString(keypadTraversal3).charAt(0));
        	String startingLetters4 = map.get(digit.charAt(0));
        	for(int k = 0; k < startingLetters4.length(); k++) {
        		for(int l = 0; l < letters4.length(); l++){
        			results.add(String.format("%s%s", "\"" + startingLetters4.charAt(k), letters4.charAt(l) + "\""));
        		}
        	}
	    }
	    
	    
	    //Starting digit with right digit
	    if((keypadTraversal4 != 4) && (keypadTraversal4 != 7)) {
        	String letters5 = map.get(Integer.toString(keypadTraversal4).charAt(0));
        	String startingLetters5 = map.get(digit.charAt(0));
        	for(int k = 0; k < startingLetters5.length(); k++) {
        		for(int l = 0; l < letters5.length(); l++){
        			results.add(String.format("%s%s", "\"" + startingLetters5.charAt(k), letters5.charAt(l) + "\""));
        		}
        	}
	    }
	    
	    return results;
	}
	private static final HashMap<Character, String> map = new HashMap<>(8);
	static {
	    map.put('2', "abc");
	    map.put('3', "def");
	    map.put('4', "ghi");
	    map.put('5', "jkl");
	    map.put('6', "mno");
	    map.put('7', "pqrs");
	    map.put('8', "tuv");
	    map.put('9', "wxyz");
	};


}
