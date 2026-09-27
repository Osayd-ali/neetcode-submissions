// Input: An array of integers nums. 
// Output: Return true if any value appears more than once in the array
// Basically return true if the input array has duplicates 
class Solution {
    public boolean hasDuplicate(int[] nums) {
        //Return true if the array has duplicates
        // brute force: use a nested loop
        // Through outer loop select one element.
        // Through nested inner loop, visit all the remaining elements coming after the outer selected element and compare each element in the inner loop with the outer loop element, for each iteration
        // If two elements become equal, then duplicate exists and return true
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        // Optimal approach:
        // Use a hashset as hashset stores only unique elements
        // Program flow: visit each element through a for loop in the given array
        // And store the selected element into our hashset
        // If that element already exists in our hashset, then duplicate exists and return true
        Set<Integer> set = new HashSet<>();
        for(int x: nums){
            if(set.contains(x)){
                return true;
            }
            set.add(x);
        }
        return false;
    }
}