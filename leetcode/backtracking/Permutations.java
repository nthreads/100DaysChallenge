/*
    46. Permutations
    https://leetcode.com/problems/permutations/
*/

import java.util.*;

public class Permutations {
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, nums, new ArrayList<Integer>(), new HashSet<Integer>());
        return result;
    }
    
    private static void backtrack(List<List<Integer>> result, int[] nums, List<Integer> curr, Set<Integer> set) {
        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) continue; // element already exists, skip
            
            curr.add(nums[i]);
            set.add(nums[i]);  // Redundant set to make lookup fast if element exisit
            
            backtrack(result, nums, curr, set);
            
                       
            set.remove(curr.get(curr.size()-1)); // Remove from set first
            curr.remove(curr.size() - 1); 
        }
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][]{{1, 2, 3}, {1}};
        
        // for (int i = 0; i < inputs.length; i++) {
        //     permute(inputs[i]);
        // }

        permute(new int[]{1, 2, 3});
        
    }

}
