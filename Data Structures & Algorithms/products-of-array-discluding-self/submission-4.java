// Input: Given an integer array nums
// Output: return an array output where output[i] (i.e. the element at each index of our output array) is the product of all elements of nums except the current element nums[i]
// Input: {1,2,3,4}
//Output: {(2*3*4), (1*3*4), (1*2*4), (1*2*3)} -> {24, 12, 8, 6}

// We should have a product tracker, which calculates the product for each index of our output array
// Initially the product tracker will have the value 1
// But then, how to avoid the element at current index and NOT consider it in computing our product?
// So we start by traversing the original array
// Through the outer loop we select the element at current index
// Then we initialize our product tracker, which resets after the product is computer for each current element
// Then, through an inner loop we again visit all the elements and here we are actually building our product for each outer loop selected element. How to avoid considering the outer loop selected index in building our product?
// In the inner loop, we will keep a condition saying, if the inner loop index is equal to the outer loop index, skip the current value in this iteration of inner loop, and go to the next iteration of the inner loop. This is done using "continue" keyword.
// Once the product is built for each index, we keep adding it into our output array
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // // Initialize an output array which has the same size as nums
        // int[] output = new int[nums.length];

        // // Start with out outer loop, this is used for selecting the index whose product is supposed to be built
        // for(int i=0; i<nums.length; i++){
        //     // Initialize a product tracker
        //     int product = 1;
        //     // Use an inner loop, visit all the elements of the array and build the product for the selected index of outer loop, if index in inner loop is equal to index in outer loop, then skip that iteration in inner loop and dont include that value into the product, and continue with the next iteration of inner loop.
        //     for(int j=0; j<nums.length; j++){
        //         if(j == i){
        //             continue;
        //             // Skip this iteration and go to next iteration.
        //         }
        //         product = product * nums[j];
        //     }
        //     // Once product for current selected index is built, we add it into our output array
        //     output[i] = product;
        // }
        // return output;

        // Optimal approach with time complexity O(n).
        // Instead of repeatedly visiting all elements through the inner loop to build the product of selected index
        // We will maintain two arrays
        // A prefix array, that builds the product of elements before the current selected index
        // A suffix array, that builds the product of elements after the current selected index
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1; // the prefix product for the first index would be nothing as there is no value on the left side of 0th index so we just default it to 1.
        suff[n-1] = 1; // Similarly the suffix product for the last index of array would be nothing as there is no value on the right side of last index so we just default it to 1. 
        // Now building our prefix product array
        for(int i=1; i<n; i++){
            pref[i] = nums[i-1] * pref[i-1]; // the previous value of current index in original array multiplied by the previous value of current index in prefix array. 
        }
        // Now building our suffix product array
        for(int i=n-2; i>=0; i--){
            suff[i] = nums[i+1] * suff[i+1];
        }
        for(int i=0; i<n; i++){
            res[i] = pref[i] * suff[i];
        }
        return res;
    }
}  
