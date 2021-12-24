public class ReverseString {
    //https://leetcode.com/problems/reverse-string/
    
    /*
    Write a function that reverses a string. The input string is given as an array of characters s.

    You must do this by modifying the input array in-place with O(1) extra memory.

    Example 1:

    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]
    */

    public static void reverse(char[] s) {
        int start = 0;
        int end = s.length - 1;
        
        while(start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }        
    }
    

    //----------------------

    // https://leetcode.com/problems/reverse-string-ii/

    public String reverseStr(String s, int k) {
        if(s == null || s.length() <= 1) return s;
        
        char[] a = s.toCharArray();                    
        int left = 0;
        int size = a.length;
        
        while(left < size) {
            int right = Math.min(left + k - 1, size - 1);
            reverse(a, left, right);
            left += 2 * k;
        }
        
        return String.valueOf(a);
    }
    
    private char[] reverse(char[] a, int left, int right) {
        while(left < right) {
            char temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            
            left++;
            right--;
        }
        
        return a;
    }
}
