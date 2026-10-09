// Input: an integer array nums and an integer k
// Output: Return the k most frequent elements within the array
// To return the k most frequent elements in the array, we need to know about frequencies or number of occurrences of each element in the array
// One way to do that would be to build a frequency map of each element and its frequency
// Once we've done that, we would typically need to sort the map in decreasing order, but as hashmaps and sets are unordered we really cant sort them
// So build an array list of the existing map and sort it
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        //Start building our map
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Now convert this existing map into an array list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // now sort our list in descending order
        list.sort((a,b) -> b.getValue() - a.getValue());

        // Now return the k most frequent elements from top from our list
        // To store our result, initialize an array of size k 
        int[] result = new int[k];

        for(int i=0; i<k; i++){
            result[i] = list.get(i).getKey();
        }

        return result;
              
    }
}
