class Solution {
    public int[] productExceptSelf(int[] nums) {
        // input: an integer array nums
        // output: return an array where output[i] is the product of all elements of nums except nums[i]
        // first we will have a for loop which is used to track the current element
        // then we will have another inner loop that visits all  elements and computes the product for the current i
        // but the catch here is, we must not include the value at the current index (where i is pointing to) in our product
        int[] output = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int product = 1;  //by declaring product inside our outer loop, we reset the product after every iteration once the product is computed for each index.
            for(int j = 0; j<nums.length; j++){
                if(j == i){ // not including nums[i] in building our product
                    continue;
                }
                product *= nums[j];
            }
            output[i] = product;
        }
        return output;
    }
}  
