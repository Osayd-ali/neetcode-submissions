class Solution {
    public int longestConsecutive(int[] nums) {
        //brute force approach
        // for loop to track the starting element of our consecutive sequence
        int maxLength = 0;
        // try every element as a starting point
        for(int i=0; i<nums.length; i++){
            int current = nums[i];
            int length = 1;

            while(true){
                boolean found = false;
                
                // Search the entire elements for current + 1
                for(int j=0; j<nums.length; j++){
                    if(nums[j] == current + 1){
                        current++;
                        length++;
                        found = true;
                        break;
                    }
                }
                
                // no next consecutive element found
                if(!found){
                    break;
                }
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
