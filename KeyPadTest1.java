import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class KeyPadTest1 {
	
	private static Scanner sc;

	// left, up, right, down
	// move from current location
	ArrayList<Integer> str = new ArrayList<Integer>();
	static int row[] = {0, 0, -1, 0, 1};
	static int col[] = {0, -1, 0, 1, 0};

	// Returns count of numbers of length
	// n starting from starting digit.
	// (i, j) in a numeric keyboard.
	static int getNumberUtil(char keypad[][], int i, int j, int wordLength)
	{
	    if (keypad == null || wordLength <= 0)
	        return 0;

	    // From a given key, only one
	    // number is possible of length 1
	    /*if (n == 1)
	        return 1;*/

	    int k = 0, move = 0, ro = 0, co = 0, totalNumber = 0;
	    String numberCombination = "";
	    int currentNumber = 0;

	    // move left, up, right, down
	    // from current location and if
	    // new location is valid, then
	    // add number to current number combination.
	    
	    for (move=0; move<wordLength; move++) {
	        ro = i + row[move];
	        co = j + col[move];
	        if (ro >= 0 && ro <= 3 && co >=0 && co <= 2 && keypad[ro][co] != ' ' && keypad[ro][co] != ' ') {
	            //totalNumber += getNumberUtil(keypad, ro, co, wordLength - 1);
	            //numberCombination = numberCombination + numberCombination.substring(currentNumber);
	        	totalNumber = totalNumber + getNumberUtil(keypad, ro, co, wordLength - 1);
	        }
	    }
	    return totalNumber;
	}

	// Return count of all possible numbers of length n
	// in a given numeric keyboard
	static int getNumber(char keypad[][], int digit) {
	    // Base cases
	    if (keypad == null || digit <= 0)
	        return 0;

	    int i = 0, j = 0, totalNumber = 0;
	    for (i = 0; i < 4; i++) // Loop on keypad row
	    {
	        for (j=0; j<3; j++) // Loop on keypad column
	        {
	            // Process for 0 to 9 digits
	            if (keypad[i][j] != '*' && keypad[i][j] != '#')
	            {
	                // Get count when number is starting from key
	                // position (i, j) and add in count obtained so far
	                totalNumber += getNumberUtil(keypad, i, j, digit);
	            }
	        }
	    }
	    return totalNumber;
	}

	// Driver code
	public static void main(String[] args) throws Exception {
		
	    sc = new Scanner(System.in);
		System.out.print("Input starting digit: ");
		String digit = sc.nextLine().trim();
		System.out.print("Input word length: ");
		int wordLength = sc.nextInt();

		if(!digit.matches("\\d+") || digit.length() <= 0 || digit.contains("0") || digit.contains("1")) {
			throw new Exception("Please input a valid digit");
		}
		
	    char keypad[][] = {{'1','2','3'},
	                        {'4','5','6'},
	                        {'7','8','9'},
	                        {'*','0','#'}};
	    
	    //System.out.printf("List of number combinations: ", getNumber(keypad, digit));
	}
}
