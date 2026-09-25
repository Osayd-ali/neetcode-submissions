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
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[j] == nums[i]){
        //             return true;
        //         }
        //     }
        // }
        // return false; 
        // Optimal solution: 
        // This problem is essentially asking if the array has all distinct elements or not
        // We have HashSets that always store all distinct elements
        // What if we access each element from the array and add it into our hashset
        // But before adding, we can check if the element to be added is present or not
        // If its present, then that means duplicate exists and we can return true
        // If all elements are distinct, then we can return false, no duplicates exist
        // First initialize a hashset
        HashSet<Integer> set = new HashSet<>();
        // Now traverse through our array and access each element so that we can add each element into our hashset.
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true; // Duplicate has been found and return true
            }
            set.add(nums[i]); // otherwise keep adding elements into our set
        }
        return false;
    }
}