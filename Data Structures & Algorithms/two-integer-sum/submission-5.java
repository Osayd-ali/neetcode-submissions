// Input: Array of integers nums and an integer target
// Output: return indices i and j such that nums[i] + nums[j] == target
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // {3,4,5,6} => target = 7. output: [0,1]
        // we would need to track two different elements which sum up to the target 7
        // so we would utilise an outer loop to track our first element
        // then through an inner loop, we visit all the remaining elements coming after our outer loop element
        // and then check if inner loop current element adds up with the outer loop current element to equate to the target. 
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // // if no two elements equate to target then return -1,-1
        // return new int[]{-1,-1};
        // Slightly optimal approach: using two pointers (convergent) approach
        // create a copy of the original array in a 2-dimensional array
        // 0th column will store value, 1st column will store the value's original index position from the original array
        // once we've built up our 2-d array then sort it based on 0th column's values
        // then apply convergent two pointer approach
        // left pointer will point to first index, right pointer will point to last index
        // while(i<j), for each iteration check if current element's sum is equal to target
        // if sum equals to target, return the indices of resultant values. return the smaller index first then the larger index
        // creating a copy of the array
        int[][] arr = new int[nums.length][2]; // rows should take the size of nums array and columns should be of size 2
        // now start filling up the values from our original array
        for(int i=0; i<nums.length; i++){
            arr[i][0] = nums[i]; //putting in the value
            arr[i][1] = i; //putting in the associated index.
        }
        // now we need to sort it with respect to the 0th column elements and that would be our array's values
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        // now that the array is sorted, apply our convergent two pointer approach
        int i=0, j=arr.length-1;
        while(i<j){
            int sum = arr[i][0] + arr[j][0];
            if(sum == target){
                return new int[]{Math.min(arr[i][1], arr[j][1]), Math.max(arr[i][1], arr[j][1])}; // returning smaller index first and then the larger index
            }
            else if(sum < target){ // this means we need to move towards a bigger value
                i++;
            } else { // if sum > target we need to move towards lesser value so shift our right pointer
                j--;
            }
        }
        return new int[0];
    }
}
