class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Input: Input array nums
        // Output: return all triplets (a list of of 3 numbers), where these three numbers add up to 0.
        // Output should not contain any duplicate triplets. 
        // Like, we must not return {-1,0,1} and {1,0,-1} or {1,-1,0} as all these lists contain same numbers but in different order so these can be classified as duplicate triplets
        // The logic for finding the numbers that equate to 0 will be, use a nested loop approach. Through the outer most loop, select one index and its value, this will be the first element of our triplet.
        // Through the second inner loop, We look for the second element of our triplet, by visiting all remaining elements coming after the outer loop's selected index
        // Through our third inner loop, we look for the third element of our triplet, by visiting all the remaining elements coming after the second inner loop's selected index. In this loop, we actually put the condition that the 3 selected elements must equate to 0, and then we add it into our list of result list. 
        // How to avoid duplicate triplets?
        // Sort the nums array to avoid considering the same triplets that might be in different order
        // Arrays.sort(nums);
        // List<List<Integer>> result = new ArrayList<>();

        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         for(int k=j+1; k<nums.length; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 // Add this triplet to our result only if the result does not contain already contain this triplet, this way we are avoiding duplicate triplets
        //                 if(!result.contains(triplet)){
        //                     result.add(triplet);
        //                 }
        //             }
        //         }
        //     }
        // }
        // return result;
        // Too inefficitent, time complexity: O(n^3), and doesnt work for a very large input
        // We might need to reduce one loop to make time complexity go from O(n^3) to O(n^2)
        // We could use a convergent two pointer approach to look for the second and third elements of our triplets
        // So select the first element through the traditional outer loop, left pointer of our convergent algorithm will point to i+1 the element just coming after the selected element of our outer loop, and then the right pointer will point to the last index of our array
        // To avoid duplicate triplets, we will sort the array, and we must also sort the array to be able to use the convergent two pointer approach. 
        // Now to avoid duplicate elements existing in the array, we will skip the iteration if we come across a value which is equal to the value at preceding index
        // Once we select the first value of our triplet,
        // We will check if sum >0, sum<0 or sum == 0
        // if sum is greater than 0, then we must make our total sum small, so we decrement our right pointer
        // if sum is less than 0, then we must make our total sum bigger, so we increment our left pointer
        // if sum is equal to 0, then we add the numbers pointer by left and right pointer to our triplet result along with the first element which was selected through the outer loop, and increment left pointer and decrement right pointer to look for the next triplet
        // And while left is less than right, and current element is equal to the previous element i.e. duplicate value is encountered, just increment the left pointer
        Arrays.sort(nums); // To avoid duplicate triplets and to apply convergent two pointer approach
        List<List<Integer>> result = new ArrayList<>();
        // Start with selecting the first element of our triplet
        for(int i=0; i<nums.length; i++){
            // If we are starting out two pointer approach with our first element as positive, then break the entire loop, as we can never reach the sum of triplets being 0
            if(nums[i] > 0){
                break;
            }
            // if the next element of our array (while selecting first element of our triplet) is equal to the value at its previous index, then skip this iteration as we found duplicate of the first element of our triplet
            if(i>0 && nums[i] == nums[i-1]){
                continue; // Skip this iteration and continue with other iterations 
            }
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0){
                    left++;
                } else if(sum > 0){
                    right--;
                } else { // sum == 0
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // if we found a duplicate while searching for our second and third element of our triplet then, 
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
