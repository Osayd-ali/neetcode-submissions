class Solution {
    public boolean hasDuplicate(int[] nums) {
    // input: Array of integers
    // output: true if any value appears more than once, false otherwise
    // basically try to find out if the array has duplicate elements or not
    // for brute force approach, we will first traverse through the array
    // the approach here is, visit one element and compare its equality with all the other remaining elements
    // if at any point, the current element is equal to one of the remaining elements this means we now know our array contains duplicates and then return true
    // for(int i=0; i<nums.length; i++){ // this loop tracks our outer element which is being compared to all other elements
    //     for(int j=i+1; j<nums.length; j++){
    //         if(nums[i] == nums[j]){
    //             return true;
    //         }
    //     }
    // }
    // return false;
    // Optimal approach, use a hashset as it only stores unique elements. If our hashset already contains the element then return true
    // reducing our running time complexity from O(n^2) to O(n)
    HashSet<Integer> set = new HashSet<>();
    // now traverse through the array, access each element and add it to our set
    for(int x: nums){
        // before adding, check if set already contains the element, if it does then return true
        if(set.contains(x)){
            return true;
        }
        set.add(x);
    }
    return false;
    }
}