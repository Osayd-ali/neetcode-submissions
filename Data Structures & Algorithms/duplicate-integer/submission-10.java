// Input: An array of integers nums. 
// Output: Return true if any value appears more than once in the array
// Basically return true if the input array has duplicates 
class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Brute force approach: 
        // we will use a nested loop approach
        // Through the outer loop we will select one element 
        // then through the inner loop, we will visit all the remaining elements coming after the selected element in the outer loop
        // Then we will start comparing, the current inner loop element and the current outer loop element.
        // If at any iteration, they are equal then we return true as a duplicate has been found
        // Time complexity: O(n^2) as there are two loops
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] == nums[i]){
                    return true;
                }
            }
        }
        return false; 
    }
}