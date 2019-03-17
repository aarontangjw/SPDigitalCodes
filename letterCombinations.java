import java.io.*;
import java.util.*;
import java.util.ArrayList;

//Outputs the combinations of letters that can be formed from a given input digit.
class Solution {
    final static Map<Character, List<String>> map = new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        final List<String> resultLetters = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return resultLetters;
        }

        //Prepare map
        map.put('2', Arrays.asList("a","b","c"));
        map.put('3', Arrays.asList("d","e","f"));
        map.put('4', Arrays.asList("g","h","i"));
        map.put('5', Arrays.asList("j","k","l"));
        map.put('6', Arrays.asList("m","n","o"));
        map.put('7', Arrays.asList("p","q","r","s"));
        map.put('8', Arrays.asList("t","u","v"));
        map.put('9', Arrays.asList("w","x","y","z"));

        List<String> list = new ArrayList<>();
        dfs(resultLetters, list, digits.toCharArray(), 0);

        return resultLetters;
    }

    public static void dfs(List<String> resultLetters, List<String> list, char[] digit, int level) {
        if (list.size() == digit.length) {
            StringBuffer sb = new StringBuffer();
            sb.append("\"");
            for (String str : list) {
                sb.append(str);
            }
            resultLetters.add(sb.toString() + "\"");
            return;
        }

        List<String> letters = map.get(digit[level]);
        for (String letter : letters) {
            list.add(letter);
            dfs(resultLetters, list, digit, level + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digits: ");
        String inputDigits = sc.nextLine().trim();
        List<String> Result = letterCombinations(inputDigits);
        Collections.sort(Result);

        // Print all the possible words
        System.out.println(Result);
    }
}
