public class ReverseKString {

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
            a[left++] = a[right];
            a[right--] = temp;
        }
        
        return a;
    }
}
