/*
    26. Remove Duplicates from Sorted Array

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/
public class RemoveDuplicateNumbers {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2};

        System.out.print(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int p1 = 0;

        for(int p2 = 0; p2 < nums.length; p2++) {
            if(nums[p1] != nums[p2] ) {
                p1++;
                nums[p1] = nums[p2];
            }
        }

        return p1 + 1;
    }
}
