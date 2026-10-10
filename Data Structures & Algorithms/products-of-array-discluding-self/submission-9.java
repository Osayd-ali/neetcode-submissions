//Input: Given an integer array nums
// Output: Return an array output where each index in the output array is the product of all elements of nums except the element at that particular index in nums
// Basically product of all elements in the array nums except self index
// basically build the product of all elements for each index visited 
// That means, visit each index once, then through an inner loop visit all the indexes of nums array and keep building the product for the outerloop's selected index
// {1,2,4,6}
// {1}
// product = 1;
// {2}
// product = product * nums[i] -> product = 1*2
// {4} -> product = (1*2) * 4
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //int[] output = new int[nums.length];
        // Outer loop to select each index of output array
        // for(int i=0; i<nums.length; i++){
        //     int product = 1;
        //     for(int j=0; j<nums.length; j++){
        //         if(i == j){
        //             continue;
        //         }
        //         product = product * nums[j];
        //     }
        //     output[i] = product;
        // }
        // return output;
        // But O(n^2) time complexity. 
        // Use a prefix array and suffix array approach to reduce the time complexity
        // For each index in our output array
        // We will build a prefix array, that computes the product of all elements coming in the left hand side of the selected index
        // We will also build a suffix array, that computer the product of all elements coming in the right hand side of the selected index
        // Initially, before we start computing the product and build our prefix and suffix arrays
        // The first index of our prefix array should contain element 1, as there is no element on the left hand side of the first index in our original array as well
        // The last index in the suffix array should contain element 1, as there is no element on the right hand side of the last index in our original array as well
        int n = nums.length;
        int[] output = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];
        // Initially the element at 0th index of our prefix array will take in the value 1 as there is nothing on the left hand side of the 0th index of nums array as well
        pref[0] = 1;
        // Initially the element at last index of our suffix array will take in the value 1 as there is nothing on the right hand side of the last index of nums array as well
        suff[n-1] = 1;
        // Start building the product of our prefix array for each index
        for(int i=1; i<n; i++){
            pref[i] = nums[i-1] * pref[i-1];
        }
        // Start building the product of our suffix array for each index
        for(int i=n-2; i>=0; i--){
            suff[i] = nums[i+1] * suff[i+1];
        }
        // Now build our output array just by multiplying both our prefix and suffix arrays
        for(int i=0; i<n; i++){
            output[i] = pref[i] * suff[i];
        }

        return output;
    }
}  
