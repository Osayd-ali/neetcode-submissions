// Input: an integer array nums
// Output: return true if any value appears more than once in the array
// essentially, if the array contains duplicate, then return true else return false. 
class Solution {
    public boolean hasDuplicate(int[] nums) {
        // brute force approach 
        // use a nested loop, through the outer loop we select one element, then 
        // through the inner loop we visit all the other remaining elements coming after the outer loop's selected element
        // we compare each of this inner loop's element and see if any of the current inner loop element is equal to the outer loop's 
        // selected element, if there is an equality that means duplicates exist and then return true. 
        // {3,5,6,7,8,6,9}
        // {3}
        // {5,6,7,8,6,9}
        // compare if 5=3, or 6=3 and so on.....
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[j] == nums[i]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        // Optimal approach
        // We must use a hashset, as hashset only contains unique values
        // so access each element of the array and then add it to our hashset
        // before adding, check if our set already contains that element, if it does then return true else return false
        HashSet<Integer> set = new HashSet<>();
        for(int x: nums){
            if(set.contains(x)){
                return true;
            }
            set.add(x);
        }
        return false; 
    }
}