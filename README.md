# SPDigitalCodes
This project is the pre-interview test for Singapore Power iGrad programme. 

To run the program simply run KeyPadTest.java in any IDE or Command Line.

# My review

Program uses String to represent keypad sequences.
I used hashmap as the choice for data structure for quicker computation of sequence combinations.

Encountered time constraint in doing the question (within 4 hours). Only able to work on Question 1.

For letterCombinations.java, it uses dfs to output the letter combinations for the given input digits.
For KeyPadTest1.java, it is supposed to find all the possible number combinations recursively given a starting digit and word length.
The function in letterCombinations.java will run through all the number combinations and output the letter combinations of the entire list of numbers. However, not able to get the recursive function to work.

# How I would have done Question 2 

Continue the code from Question 1, add the position input parameter,
removing all but the letter combinations with the specific letter in that position.
