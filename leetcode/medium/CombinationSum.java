/*
    //Combination Sum

    39 : https://leetcode.com/problems/combination-sum/
*/


import java.util.*;
public class CombinationSum {
    
    public static void main(String[] args) {
        System.out.print(combinationSum(new int[] {2, 3, 6, 7}, 7).toString());
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(candidates.length == 0) return result;
        backtrack(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public static void backtrack(int[] cand, int target, int start, List<Integer> curr, List<List<Integer>> result) { 
        if(target < 0) return;

        if(target == 0) result.add(new ArrayList(curr));

        for (int i = start; i < cand.length; i++) {
            curr.add(cand[i]);
            backtrack(cand, target - cand[i], i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    
}
