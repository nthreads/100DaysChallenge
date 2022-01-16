import java.util.HashMap;

public class SubarrayWithSumZero {
    public static void main(String[] args) {    
        System.out.println(solution(new int[]{2, -2, 3, 0, 4, -7}));
    }

    public static int solution(int[] input) {
        
        
        HashMap<Integer, Integer> map = new HashMap<>();

        int currSum = 0;
        int count = 0;
        //boolean allZeros = true;
        map.put(0, 1);
        
        for(int i = 0; i < input.length; i++) {

            //if(input[i] != 0) allZeros = false;

            currSum += input[i];    

            if(map.containsKey(currSum)) {
                int lastCount = map.get(currSum);
                count += lastCount;
                map.put(currSum, lastCount + 1);
            } else {
                map.put(currSum, 1);
            }            
        }

        //return allZeros ? -1 :  count;
        return count;
    }
}