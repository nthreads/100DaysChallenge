/*

    8. https://leetcode.com/problems/string-to-integer-atoi/

    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
    
*/

public class StringToInteger {
    
    public static void main(String[] args) {
        String[] inputs = new String[]{"450", "-258",".1", "   58", "56461614564", "455   aa", "aa  aasds 33"};

        for (String string : inputs) {
            System.out.println(myAtoi(string));
        }

    }

    public static int myAtoi(String s) {
        char[] cArray = s.toCharArray();
        
        int currResult = 0, index = 0;
        int sign = 1, n = cArray.length;
        
        while(index < n && cArray[index] == ' ') {
            index++;
        }
        
        if(index < n && cArray[index] == '-') {
            sign = -1;
            index++;
        }
            
        else if(index < n && cArray[index] == '+') index++;
        
        
        while(index < n && Character.isDigit(cArray[index])) {
            int digit = Character.getNumericValue(cArray[index]);
            
            // Check overflow and underflow conditions
            if((currResult > Integer.MAX_VALUE / 10) || (currResult == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)){

                // If integer overflowed return 2^31-1, otherwise if underflowed return -2^31
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            currResult = currResult * 10 + digit;
            index++;
        }            
        
        return sign * currResult;
    }
}
