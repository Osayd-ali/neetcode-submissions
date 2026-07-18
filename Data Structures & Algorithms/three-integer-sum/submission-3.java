class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     // input: array of integers
     // output: a list of triplet pairs containing numbers that sum up to 0. 
     // our list should not contain any duplicate triplet pairs
     // we could do this using a 3 nested loop approach
     // one way of making sure that a triplet pair thats going into our list as a result in unique
     // is by adding first the triplet pairs into a hashset, as hashset only contains unique elements
     // to avoid duplicate pairs lets sort the array, so that values are always visited by our loop in ascending order
    //  Arrays.sort(nums);
    //  Set<List<Integer>> resultSet = new HashSet<>();
    //  // we will now start our looping to traverse the array
    //  for(int i=0; i<nums.length; i++){
    //     for(int j = i+1; j<nums.length; j++){
    //         for(int k = j+1; k<nums.length; k++){
    //             if(nums[i] + nums[j] + nums[k] == 0){
    //                 resultSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
    //             }
    //         }
    //     }
    //  }
    //  return new ArrayList<>(resultSet);
    // now let's build the optimal solution
    // we will use two pointer method
    // once we have selected the current element i
    // we will point the left pointer towards i+1
    // right pointer towards nums.length - 1
    // we will again sort
    // and add our triplet pairs into a hashset
    // what would be the condition for our pointers to change direction right
    // so if the sum of triplet pairs is positive, that means we move towards a lesser value that would make our sum to 0
    // if the sum of triplet pairs is negative, then we move towards a greater value that would make our sum to 0;
    // if sum>0; then right--; i.e. decrement the right pointer
    // if sum<0; then left++; i.e. increment the left pointer
    Arrays.sort(nums);
    Set<List<Integer>> resultSet = new HashSet<>();
    for(int i =0; i<nums.length; i++){
        int left = i+1;
        int right = nums.length-1;
        
        while(left < right){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum == 0){
                resultSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
            } else if(sum < 0){
                left++;
            } else {
                right--;
            }
        }
    }
    return new ArrayList<>(resultSet);
    }
}
