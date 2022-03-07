/*
    7. Reverse Integer
    https://leetcode.com/problems/reverse-integer/

    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

*/
public class ReverseInteger {

    public static void main(String[] args) {
        int[] inputs = new int[]{123, -123, 120, -89798712};

        for (int i : inputs) {
            System.out.println(i + " => " + reverse(i));
        }
    }

    public static int reverse(int x) {
        
        int result= 0;
        int sign = 1;

        if(x < 0) {
            sign = -1;
        }

        String str = String.valueOf(Math.abs(x));
        int len = str.length();        
        
        for(int i = len-1; i >= 0; i--){
            int digit = Character.getNumericValue(str.charAt(i));
            
            //Check if overflow or underflow then return 0
            if((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE && digit > Integer.MAX_VALUE % 10)) return 0;
            
            result = result * 10 + digit;
        }
        
        return sign * result;            
    }
}
