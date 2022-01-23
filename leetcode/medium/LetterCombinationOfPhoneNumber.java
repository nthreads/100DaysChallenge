import java.util.*;

public class LetterCombinationOfPhoneNumber {
    // 17. Letter Combinations of a Phone Number

    public static void main(String[] args) {
        String[] inputs = {"23", ""};

        for (String input : inputs) {
            System.out.println(letterCombinations(input));
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        
        if(digits == null || digits.length() == 0) return result;
        
        String[] map = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"    
        };
        
        
        
        backtrack(result, "", digits, 0, map);
        
        return result;
    }

    public static void backtrack(List<String> result, String curr, String digits, int index, String[] map) {
        
        // Base condition

        if(curr.length() == digits.length()) {
            result.add(curr);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++) {
            backtrack(result, curr + letters.charAt(index), digits, index + 1, map);
        }

    }
    
}
