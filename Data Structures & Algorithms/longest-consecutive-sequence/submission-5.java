// Input: an array of integers nums
// Output: return the length of the longest consecutive sequence of elements that can be formed

// Consecutive sequence means: a sequence of elements where each element is exactly one greater than the previous element, but they dont have to be in the same sequence in the original array

// {2,20,4,10,3,4,5}
// Output: {2,3,4,5} length = 4

// so create a sequence where each element is exactly one greater than the previous element
// Then record its length
// We also need to avoid duplicate elements into being added into our sequence. We could use a hashset for that

// Brute force approach:
// Since we would want the consecutive sequence in increasing order we can sort the input array first

class Solution {
    public int longestConsecutive(int[] nums) {
        // brute force approach:
        // We can use a hashset to avoid duplicate elements in the array first,
        // so first add all elements of input array into a hashset, now we will have a set of all distinct elements
        // Now, we start the algorithm of actually building our streak of longest consecutive sequence. So we initialize a streak variable, where we keep track of the length of the longest sequence
        // The algorithm to actually build the longest sequence where the next element is exactly 1 greater than the current element would be:
        // firstly, we will have a curr variable which signifies the starting element of our sequence. Through a for loop, we visit each element in the set, and treat it as our supposed starting element of consecutive sequence/
        // The curr will point to the first element of the set initially.
        // Now, we keep running a while loop as long as the curr element exists in the set
        // In this loop, as long as current element exists in the set, we increment our streak and then we increment our current value
        // This way we are building the streak for consecutive sequence of elements as the streak is only incremented if the next greater element exists in the set. 
        //Initializing result variable which will ultimately hold our longest streak
        // int result = 0;
        // Set<Integer> set = new HashSet<>();
        // for(int num: nums){
        //     set.add(num);
        // }
        // Now our set of all distinct elements is created
        // Now access each element and assume it would be the starting element of our sequence
        // for(int num: nums){
        //     int streak =0; 
        //     int curr = num;
            // Now we run the logic of actually building our sequence of increasing elements by 1
            // while(set.contains(num)){ // as long as our set contains this num
            //     streak++;
            //     num++; // increment the previous num by 1, and in the next iteration of this while loop, the incremented num should exist in the set so we keep building our streak of longest consecutive sequence of elements
        //     }
        //     result = Math.max(result, streak); // To keep updating our final result so that it can hold the maximum of the streak. 
        // }
        // return result;

        // Time complexity: O(n^2)

        // More optimized solution
        // Instead of recounting the same sequences, we would only want to start counting when we find the beginning of a consecutive sequence
        // A number is the start of a sequence, if num-1 is not in the set. 
        // This guarantees that each consecutive sequence is counted exactly once

        // Once we identify such a starting number, we simply keep checking if num + 1, num + 2, ... exist in the set and extend the streak as far as possible. 
        int result = 0;
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        for(int num: nums){
            // Try to build the streak only if the current num's num-1 does not exist in the set, this makes sure that there is only one unique consecutive sequence for this current num as our starting element
            if(!set.contains(num-1)){
                int length = 1; // since the current num is the starting element of our sequence
                while(set.contains(num + length)){
                    length++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
