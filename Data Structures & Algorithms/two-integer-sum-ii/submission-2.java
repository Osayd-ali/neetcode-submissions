// Input: an array of integers numbers, and we have a target
// We need to find indices of two elements whose sum is equal to the target
// Array is sorted in increasing order
// we must return 1 indexed indices and not 0indexed indices
// Arrays in java are by default 0 indexed, so while returning the index of two numbers we could just return the indices with + 1 added to them
// Since the array is sorted, we have an opportunity to apply convergent two pointer approach
// where left pointer will look for the first element and the right pointer will look for the second  element of our two sum pair
// there must be exactly one solution
// and if the sum if less than target then left++
// if sum is greater than target then right--
class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int left = 0;
       int right = numbers.length-1;
       while(left<right){
        int sum = numbers[left] + numbers[right];
        if(sum == target){
            return new int[]{left+1, right+1};
        } else if(sum < target){
            left++;
        } else {
            right--;
        }
       }
       return new int[]{-1,-1};
    }
}
