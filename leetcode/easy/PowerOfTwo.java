/*
    231. Power of Two
    https://leetcode.com/problems/power-of-two/

    Given an integer n, return true if it is a power of two. Otherwise, return false.

    An integer n is a power of two, if there exists an integer x such that n == 2x.
*/

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
                    
        while (n != 1) {
            // if its odd
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        
        return true;
    }
}
