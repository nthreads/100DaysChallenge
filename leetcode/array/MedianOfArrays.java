/*
    4.  Median of Two Sorted Arrays
        https://leetcode.com/problems/median-of-two-sorted-arrays/

        Given two sorted arrays nums1 and nums2 of size m and n respectively, 
        return the median of the two sorted arrays.

        The overall run time complexity should be O(log (m+n)).
*/

public class MedianOfArrays {
  
    public static void main(String[] args) {
        double mean = findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        System.out.println(mean);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        
        int i = 0, j = 0, k = 0;
        
        while(i < nums1.length && j < nums2.length) {
            
            if(nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }
        
        while(i < nums1.length ) {
            mergedArray[k++] = nums1[i++];
        }
        
        while(j < nums2.length ) {
            mergedArray[k++] = nums2[j++];
        }
        
        
        double median = 0;
        int mid = mergedArray.length / 2;
        
        if (mergedArray.length % 2 == 0) {
            double a1 = mergedArray[mid];
            double a2 = mergedArray[mid - 1];
            median = (a1 + a2) / 2;
        } else {
            median = mergedArray[mid];
        }
        
        return median;
    
    }
}
