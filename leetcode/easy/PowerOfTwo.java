/*
    231. Power of Two
    https://leetcode.com/problems/power-of-two/

    Given an integer n, return true if it is a power of two. Otherwise, return false.

    An integer n is a power of two, if there exists an integer x such that n == 2x.
*/

public class PowerOfTwo {
    
    public static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
                    
        while (n != 1) {
            // if it's odd e.g 3 is an odd number, so we will return false immediately
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Power of two " + isPowerOfTwo(1));  // True
        System.out.println("Power of two " + isPowerOfTwo(2));  // True
        System.out.println("Power of two " + isPowerOfTwo(16)); // True
        System.out.println("Power of two " + isPowerOfTwo(3));  // False
    }
}
