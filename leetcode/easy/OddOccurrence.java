import java.util.HashMap;

public class OddOccurrence {

    // Time Complexity O(n)
    // Auxiliary Space O(n)
    /**
     * @param s
     * @return char
     */
    public static char find(String s) {
        char[] cArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : cArray) {
            // If character is not present, store with 1
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1); // If character is present, increase the count
            }
        }

        // Traverse through map to check odd occurrence
        for (char c : map.keySet()) {
            if(map.get(c) % 2 == 1) return c;
        }

        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        String s1 = "abb";
        String s2 = "7c7@@@c7@";
        String s3 = "aab";

        System.out.println(find(s1));   // Expected result 'a'
        System.out.println(find(s2));   // Expected result '7'
        System.out.println(find(s3));   // Expected result 'a'
    }
}
