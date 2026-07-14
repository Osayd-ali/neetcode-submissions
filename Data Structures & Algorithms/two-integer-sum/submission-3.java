class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int difference = target - num;
            
            // now we look if the difference value exists in the map or not
            if(map.containsKey(difference)){
                return new int[]{map.get(difference), i}; // returning indices of two numbers
            }
            map.put(num,i);
        }
        return new int[]{-1,-1};
    }
}
