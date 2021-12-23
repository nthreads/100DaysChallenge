/*

9. Palindrome Number
https://leetcode.com/problems/palindrome-number/

Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.

*/

public class Palindrom {
    public boolean isPalindrome(int x) {
        if(x  < 0) return false;
        
        int remainder = 0, reversed = 0, original = x;    
         
        while(x != 0) {
            remainder = x % 10; // reversed integer is stored in variable
            reversed = reversed * 10 + remainder; //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
            x = x / 10;   //the last digit is removed from num after division by 10.     
        }
        
        return (reversed == original);
    }
}


/*
Complexity Analysis

Time complexity : O(log10(n)). We divided the input by 10 for every iteration, so the time complexity is O(log10(n))

Space complexity : O(1).

*/