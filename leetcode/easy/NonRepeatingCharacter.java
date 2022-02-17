import java.util.HashMap;

class NonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("aab"));
    }

    public static int firstUniqueChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if(!map.containsKey(current)) {
               map.put(current, i);
            } else {
                map.put(current, -1);
            }                
        }
        
        int min = Integer.MAX_VALUE;
        
        for(char c : map.keySet()) {
            int index = map.get(c);
            if(index != -1 && index < min) {
                min = index;
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}