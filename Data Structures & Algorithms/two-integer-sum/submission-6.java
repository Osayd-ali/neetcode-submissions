// Input: an array of integers nums, and an integer target
// Output: Return the array of indices of two numbers that sum up to the target, i != j
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // {3,5,7,9,11}, target = 10. 3 + 7 = 10, output [0,2]
        // we need to find the indices of two such integers
        // For the basic approach, we can use a nested loop.
        // Through our outer loop, we will keep track of the first element 
        // Through the inner loop, we will visit all the reamining elements coming after the selected element in the outer loop which will give us the second element
        // Finally inside our inner loop, we will check if the selected elements sum up to the target
        // If they do, then we return the array of indices in the current iteration as our result
        // if not, we will keep traversing our array and keep comparing elements to check if they sum up to the target
        // else, return an empty array as no elements were found
        // Time complexity: O(n^2) as we have a nested loop containing 2 for loops
        // for(int i=0; i<nums.length; i++){
        //     for(int j = i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{-1,-1};
        // Slightly optimal approach
        // We could do this in O(n logn) instead of O(n^2).
        // Essentially reducing one for loop
        // we can use a convergent two pointer approach by first sorting the array
        // Once we have our array sorted, we we will have two pointers left and right
        // left pointer will look for the smaller value of the element pair that sums up to the target
        // right pointer will look for the larger value of the element pair that sums up to the target
        // So as long as left pointer is less than the right pointer we will keep running a while loop
        // If the current sum i.e. value pointer by left pointer + value pointer by right pointer for the current iteration is equal to our target then we return the immediate indices associated with those values 
        // if not, then we check if the current sum is less than the target. If it is, then we would need to add a bigger value in our current sum, that means we move or increment our left pointer
        // If the current sum if greater than the target, then we would need to move towards a smaller value to make our current sum equal to the target, i.e. decrementing our right pointer to move towards a smaller value. 
        // But, as we are supposed to return the original indices, we should store them somewhere to maintain the index order
        // That is why, we should make a new 2-d array which stores both index and its associated value and then sort it
        int[][] arr = new int[nums.length][2];
        // rows must be equal to the number of elements in our original array
        // column size must be 2, one column for our element and one column for the element's associated index
        // now start filling our 2 d aray
        for(int i=0; i<nums.length; i++){
            arr[i][0] = nums[i]; // this current row's 0th column should take in array's current value
            arr[i][1] = i; // this current row's 1st column should take in array's current index
        }
        // Now we've built our array with index order maintained for each element
        // now its time for us to sort it
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0])); // sort this on the basis of 0th column elements of our array arr.
        // Now apply convergent two pointer approach
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int cur = arr[left][0] + arr[right][0];
            if(cur == target){
                return new int[]{Math.min(arr[left][1], arr[right][1]),
                                Math.max(arr[left][1], arr[right][1])};
            } else if(cur < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
