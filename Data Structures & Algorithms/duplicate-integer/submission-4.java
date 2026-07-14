class Solution {
    public boolean hasDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){ //outer loop where element at i index will be compared with all the other remaining elements
            for(int j=i+1; j<nums.length; j++){ // inner loop accessing all other remaining elements to compare with i value
                if(nums[i] == nums[j]){// finding out duplicate value condition
                    return true;
                }
            }
        }
        return false;
    }
}