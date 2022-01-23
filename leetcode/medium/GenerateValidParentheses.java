import java.util.*;

public class GenerateValidParentheses {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);

        for (String string : res) {
            System.out.print(string);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(0, 0, n, new String(), result);
        return result;
    }

    public static void backtrack(int open, int close, int max, String curr, List<String> result) {
        // Base condition

        if(curr.length() == max * 2) {
            result.add(curr);
            return;
        }

        if(open < max) {
            backtrack(open + 1, close, max, curr + "(", result);
        } 
        
        if(close < open) {
            backtrack(open, close + 1, max, curr + ")", result);
        }
    }
}
