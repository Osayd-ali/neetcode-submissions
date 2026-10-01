// Input: an array of integers nums, and an integer target
// Output: Return the array of indices of two numbers that sum up to the target, i != j
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Use a nested loop approach
        // Through the outer loop track the first element of our pair that should sum up to the target
        // Through the inner loop we visit all the remaining elements and in each iteration we will sum the inner loop current element with outer loop current element and check if they sum up to the target
        // if they do, then we have found our pair and we return the indices
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{-1,-1};
        // Slightly optimized approach, using a convergent two pointer approach
        // We will first store the array elements along with their indices in a 2d array
        // then we will sort the 2d array based on the elements
        // Then we will use convergent two pointer approach
        // Basically if current sum = target, return indices
        // If < target; move towards a greater value to make the current sum larger
        // If > target; move towards a lesser value to make the current sum smaller
        // int[][] arr = new int[nums.length][2];
        // // Start filling up our 2d array
        // for(int i=0; i<nums.length; i++){
        //     arr[i][0] = nums[i];
        //     arr[i][1] = i;
        // }
        // // Now sort it
        // Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        // // Now start our convergent two pointer approach
        // int left = 0; int right = nums.length - 1;

        // while(left < right){
        //     int cur = arr[left][0] + arr[right][0];
        //     if(cur == target){
        //         return new int[]{Math.min(arr[left][1], arr[right][1]),
        //                         Math.max(arr[left][1], arr[right][1])};
        //     } else if(cur < target){
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }
        // return new int[0];
        // Even more optimal approach 
        // Using a HashMap
        // we store the value and its corresponding index of the array as a key value store in our hashmap
        // Then we iterate through the array and check if the complement of the current element i.e. difference = target - curr[i]. exists in the hashmap or not
        // the complement must be at a different index
        // if it does, then return the indices of current element and its complement
        HashMap<Integer, Integer> map = new HashMap<>();
        // Start filling up our hashmap
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        // Now traverse our original array and see if the current element's complement already exists in the array or not
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff) != i){
                return new int[]{i, map.get(diff)};
            }
        }
        return new int[]{-1,-1};
    }
}
