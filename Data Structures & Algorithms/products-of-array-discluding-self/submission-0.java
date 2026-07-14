class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        // Outer loop for tracking the current element of nums
        for(int i=0; i<nums.length; i++) {
            // we will initialize a product tracker for current index
            int product = 1;
            // in the following nested loop, we will visit all the remaining elements except current element and build a product by multiplying all the visited elements for this current index of our output array
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                    //The continue keyword in the selected line is used to skip the current iteration
                    // of the inner for loop when the condition j == i is true.
                    // This ensures that the current element of the nums array (at index i) is not
                    // included in the product calculation for that iteration.
                    // The loop then proceeds with the next value of j.
                }
                product *= nums[j];
            }
            output[i] = product;
        }
        return output;
    }
}  
