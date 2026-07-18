class Solution {
    public boolean hasDuplicate(int[] nums) {
       // input is array of integer nums
       // return true if a value appears more than once 
       // basically return true for an array with duplicate elements
       // brute force approach
       // use a nested loop, use the outer loop tracker to select one element
       // then an inner loop tracker to visit all the remaining elements after the outer current element index.
       // compare all the remaining elements in j index with the element in i index
       // if they are equal then a duplicate is found a return true
    //    for(int i=0; i<nums.length; i++){
    //     for(int j = i+1; j<nums.length; j++){
    //         if(nums[j] == nums[i]){
    //             return true;
    //         }
    //     }
    //    }
    //    return false;
    // try for an optimal approach to reduce the time complexity from O(n^2) to O(n).
    // duplicate elements should be find, whenever you come across unique elements or duplicates, use a hashset to store elements
    // through an outer loop i we start traversing our array and track the current element in each iteration
    // then in every iteration we will look to add that current element into our hashset
    // we use hashset as it only adds unique elements
    // before we add an element into our set, we keep a check if that element already exists in the set
    // if it does, then the array does in fact contain duplicate elements and return false, other wise keep adding
        Set<Integer> set = new HashSet<>();
        for(int x: nums){
            if(set.contains(x)){
                return true; // this means array does contain duplicate elements
            }
            set.add(x);
        }
        return false;
    }
}