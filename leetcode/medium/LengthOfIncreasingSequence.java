import java.util.Arrays;
import java.util.List;

public class LengthOfIncreasingSequence {

    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }


        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{10,9,2,5,3,7,101,18};
        int[] arr2 = new int[]{0,1,0,3,2,3};
        int[] arr3 = new int[]{7,7,7,7,7,7,7};

        System.out.println(lengthOfLIS(arr1)); // 4
        System.out.println(lengthOfLIS(arr2)); // 4
        System.out.println(lengthOfLIS(arr3)); // 1
    }
}
