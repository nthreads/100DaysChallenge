// https://leetcode.com/problems/reverse-words-in-a-string-iii/
/*
    Example 1:

    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if(s == null || s.length() <= 1) return s;
        
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < words.length; i++) {
            sb.append(reverse (words[i])).append(" ");
        }
        
        return sb.toString().trim();
    }
    
    private String reverse(String s) {
        if(s == null || s.length() <= 1) return s;
        
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            char temp = charArray[left];
            charArray[left++] = charArray[right];
            charArray[right--] = temp;
        }
        
        return String.valueOf(charArray);
    }
}
