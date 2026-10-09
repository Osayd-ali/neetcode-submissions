// Input: integer array nums {3,5,7,9,11}
// Output: return true if the array contains any duplicate elements
// Brute force solution would be:
// Run a nested loop approach
// through the outer loop, select one element
// Then visit all the remaining elements coming after the outer loop's selected element and check for equality
// If any pair is found to be equal then return true
// At worst, the time complexity of this would be O(n^2)
// Because we are traversing the n elements of our array twice
class Solution {
    public boolean hasDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;   
    }
}