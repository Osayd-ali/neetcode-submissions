class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // // a nested loop of 3 loops where each loop helps us find the three individual elements.
        // // we will have an outer loop, which keeps track of our first element
        // // a first inner loop that will keep track of the second element 
        // // a second inner loop that will keep track of the third element
        // Set<List<Integer>> resultSet = new HashSet<>(); // using hashset to avoid duplicate pairs of indices
        // Arrays.sort(nums); // sorting the array and starting to find elements from the least element // to avoid duplicate triplet sets
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         for(int k=j+1; k<nums.length; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 resultSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(resultSet);
        // Optimal solution, running time O(nlogn) + O(n^2) = O(n^2).
        // We will first sort the array, which helps avoiding duplicate triplet sets
        // We will again use an outer for loop to track the current element which signifies the first element in our triplet set.
        // Approach, use a two pointer method(convergent) to identify the remaining two values.
        // we start traversing from i+1 for our left pointer and for our right pointer it starts at the end index of our array. 
        // in each iteration of our inner while loop, we track our sum by adding up all the triplets
        // if the sum is positive, then we decrement our right pointer as it moves towards a lesser value which might help us reach the 0 sum
        // if the sum is negative, then we increment our left pointer as it moves towards a higher value which helps us reach 0 sum
        // if the sum is equal to 0, then we return all the three elements that will be a pair existing in a list
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i<nums.length; i++){
            if(nums[i] > 0) break; // if our first element is positive, then break the loop entirely as all remaining values will also be positive and we can never reach a sum to 0
            if(i >0 && nums[i] == nums[i-1]) continue; // if we have found duplicate elements, then break the loop and go to the next iteration
            // now start processing our actual two pointer logic
            int left = i + 1;
            int right = nums.length - 1;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum>0){
                    right--;
                } else if(sum<0){
                    left++;
                } else { // in this case sum = 0 we found our elements
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]){ // if we found duplicate element while searching for 2nd element of our pair
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
