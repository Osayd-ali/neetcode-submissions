// Integer array nums {-1,0,1,2,-1,4}
// Return a list of all triplets, such that the sum of each triplet equals to 0
// The output should not contain any DUPLICATE triplets, we can return the triplets in any order
// Sort the input array before starting to compute the triplets that equate to 0
// Now when looking for values for our triplets, if we traverse the sorted version of the input array then we can easily identify duplicate triplets, because the duplicate triplets will almost always be in same order if they were organised from a sorted array. This way we are essentially making our duplicate triplets identical
// Now to avoid, adding the identical duplicate triplet into our result set, what we will do is, we will store the result of all triplets in a hashset, so that it only stores unique triplets
// Now we solved the problem of duplicate triplets
// Then use a 3 nested loop to look for 3 different values of triplet and inside the inner most nested loop keep a condition if the sum of all values equate to 0
// then add it into our set
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Arrays.sort(nums);
        // HashSet<List<Integer>> result = new HashSet<>();

        // for(int i=0; i<nums.length; i++){
            
        //     for(int j=i+1; j<nums.length; j++){
        //         for(int k = j+1; k<nums.length; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j],nums[k]));
        //                 result.add(triplet);
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(result);
        // The above brute force solution is really inefficient because it take O(n logn) + O(n^3)
        // There is a possibility for us to write a solution which takes in O(n logn) + O(n) time
        // Basically, removing the inner loops by introducing convergent two pointer approach to look for the second and third value of our triplet
        // Again, sort the array to make it easy for us to make identical duplicates
        // Then store our triplets into a hashset to discard duplicate triplets
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();
        // Use a for loop to select the first/starting element of each triplet, then we use convergent two pointer approach to find the other two elements
        for(int i=0; i<nums.length; i++){
            // if we found the first element to be a positive, then there is no reason to continue the loop
            if(nums[i] > 0){
                break;
            }
            // If we have found the first element of this current triplet sequence to be a duplicate then skip this iteration and go to the next one
            if(i>0 && nums[i] == nums[i-1]){
                continue; // skip this iteration
            }
            int left = i+1;
            int right = nums.length - 1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    result.add(triplet);
                    left++;
                    right--;
                    // If we found a duplicate element while searching for the second element of our pair
                    //while(left<right && nums[left] == nums[left-1]){
                    //    left++;
                    //}
                } else if(sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
