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
        // Input: Integer array nums
        // Output: Return an array, where each index holds the product of all elements in the original array except the current element
        // So, for the brute force solution, We will have a nested loop approach
        // through the outer loop, we select an index whose product is supposed to be evaluated, through the inner loop, we visit each index element of the original array and build the product for the index selected through the outer loop, We will skip the elements at the outer loop selected index while building our product
        // Initialize the output array
        // int[] output = new int[nums.length];
        // // selecting the index whose product is supposed to be calculated
        // for(int i=0; i<nums.length; i++){
        //     int product = 1;
        //     // Now building the product for the selected index by actually visiting all the elements of original array, skip the element which is at currently selected index
        //     for(int j=0; j<nums.length; j++){
        //         if(j == i){
        //             continue; // skip the current iteration
        //         }
        //         product = product * nums[j];
        //     }
        //     output[i] = product;
        // }
        // return output;
        // Time complexity: O(n^2)
        // We can introduce the concept of prefix and suffix arrays
        // According to the question we must solve the problem in O(n) time 
        // So eliminate the need of nested loop
        // Prefix array will build the product for each index by computing the product of all values coming before the selected index
        // Eg: Input: {2,3,5,7,9}
        // Pref[2]= {1, 1*2; 3* (1*2)} for index 2 this would be the prefix array
        // Suffix array will build the product for each index by computing the product of all values coming after the selected index
        // Eg: Input: {2,3,5,7,9}
        // Suff[2]: {_, _, 7 *(9*1), 9*1 ,1}
        // Now the result array will just be multiplication of both prefix and suffix array elements and will gives us our required solution
        int n = nums.length;
        int[] result = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1; // Since there is no element on the left side of the first index of the original array
        suff[n-1] = 1; // Since there is no element on the right side of the last element of the original array
        // Build our pref array
        for(int i=1; i<n; i++){
            pref[i] = nums[i-1] * pref[i-1];
        }
        // build our suff array
        for(int i=n-2; i>=0; i--){
            suff[i] = nums[i+1] * suff[i+1];
        }
        // Now combine elements for each index at both prefix and suffix arrays and this gives us product of all elements for each index except the current index element of the original array
        for(int i=0; i<n; i++){
            result[i] = pref[i] * suff[i];
        }

        return result;
    }
}  
