//Input: given an integer array nums
// Find the longest consecutive sequence of elements where each element is exactly one greater than the previous element. 
// The elements do not have to be consecutive in the original array
// Brute force approach
// Use a nested loop approach, where the outer loop selects the starting element of our supposed sequence, and the inner loop visits each element in the array repeatedly as long as we keep extending our longest consecutive sequence
// To repeatedly search the array to keep buuilding our sequence using the inner loop, we can use a while loop saying that as long the the next value is found keep searching for the next element
class Solution {
    public int longestConsecutive(int[] nums) {
        // A global maxlength variable to keep track of the maximum length in  multiple sequences
        // int maxLength = 0;
        
        // for(int i = 0; i<nums.length; i++){
        //     int length = 1;
        //     boolean found = true;
        //     int curr = nums[i];
        //     while(found){
        //         found = false;
        //         // now start building our sequence 
        //         for(int j = 0; j<nums.length; j++){
        //             if(nums[j] == curr + 1){
        //                 length++;
        //                 curr = nums[j];
        //                 found = true;
        //                 break;
        //             }
        //         }
        //         maxLength = Math.max(maxLength, length);
        //     }
        // }
        // return maxLength;
        // O(n^2)
        // We need to complete this in O(n) time
        // We could use a set that avoids duplicate elements and stores unique elements
        // The problem requires that we build a sequence of increasing elements greater by 1
        // We should also avoid adding in duplicate values into our sequence
        // We will have a streak variable which keeps incrementing as long as we are finding elements greater by 1 than the previous element and keep building our longest consecutive sequence
        // To avoid the problem of adding in duplicates or double counting duplicates, we will use a hashset to keep building our longest consecutive sequence
        // So we would traverse the entire input array and visit each element
        // We will first build a hashset by putting in all the values from the original array so this way we would be creating a set of all distinct elements. 
        // After that we initialize a variable that will hold in the length of longest consecutive sequence 
        // Now, only start extending our length of consectuive sequence, or start building our sequence for only those values that are for sure the starting element of the sequence, this way we avoid recounting the same sequences 
        // We can know that if a value is the starting element of a sequence if num - 1 does not exits in the set
        // Create a global variable which will holds max length of longest consecutive sequence
        int longest = 0;
        HashSet<Integer> set = new HashSet<>();
        // Start filling in our hashset
        for(int num: nums){
            set.add(num);
        }
        // Now, start the algorithm for building our sequence
        // Only start building the sequence if we know for sure that the current element is the starting of the sequence
        // i.e. num-1 should not exist in the set
        for(int num: nums){
            if(!set.contains(num - 1)){
                int length = 1;
                while(set.contains(num + length)){ // as long as set contains the value which is greater than one from previous element.
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
