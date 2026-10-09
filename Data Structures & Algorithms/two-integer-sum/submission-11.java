class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Nested loop approach
        // Outer loop selects first element
        // Inner loop visits all the remaining elements coming after, and will look for the second element of the two sum pair, 
        // This way, we are creating pairs for each value appearing in the array
        // Then check if the sum of the element pair equates to the target
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{-1,-1};
        // This is a bit slow approach, as array is being traversed twice for creating the element pair so it equates to O(n^2)
        // A more optimal approach would be
        // To first sort the array, and use a convergent two pointer approach to find the element pair, as convergent two pointer is generally useful for sorted arrays
        // But, here we also need to record the original indices associated with each value as we are returning indices as part of our result
        // so, we will create a 2 dimensional array, where 0th column will take in the elements and the 1st column would store the index associated with the element
        // sort the 2dimensional array based on 0th column elements
        // then apply our convergent two pointer approach
        // left pointer will look for the first element and right pointer will look for the second element of our pair, if the sum is < target, then we move left pointer and if sum > target then we need to make our sum smaller to go near the target so we decrement right pointer
        // If sum is equal to target then we return the indices associated with the values, selecting the min index first and max index later
        int[][] arr = new int[nums.length][2];
        // filling up our 2 d array
        for(int i=0; i<nums.length; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        // Now sort the array
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        // Apply convergent two pointer approach
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int sum = arr[left][0] + arr[right][0];
            if(sum == target){
                return new int[]{Math.min(arr[left][1], arr[right][1]),
                                Math.max(arr[left][1], arr[right][1])};
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
