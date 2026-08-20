class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        // apply convergent two pointer
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            } else if(sum < target){ // should try to increase our sum and hence look for greater value that means shift our left pointer towards greater value
                left++;
            } else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
