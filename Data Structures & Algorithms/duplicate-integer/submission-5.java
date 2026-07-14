class Solution {
    public boolean hasDuplicate(int[] nums) {
        // for(int i=0; i<nums.length; i++){ //outer loop where element at i index will be compared with all the other remaining elements
        //     for(int j=i+1; j<nums.length; j++){ // inner loop accessing all other remaining elements to compare with i value
        //         if(nums[i] == nums[j]){// finding out duplicate value condition
        //             return true;
        //         }
        //     }
        // }
        // return false;
        // for optimal approach use a hashset as it only stores unique elements
        // access each index value of the array
        // then start putting it into our hashset
        // before adding a value to the hashset, we keep a condition that if the set contains the current value already, then that means that the current value is a duplicate and we return true
        HashSet<Integer> set = new HashSet<>();
        for(int x: nums){
            if(set.contains(x)){
                return true;
            }
            //add new values into our set
            set.add(x);
        }
        return false;
    }
}