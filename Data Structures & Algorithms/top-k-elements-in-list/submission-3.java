//Input: Given an integer array nums and an integer k
// Return the k most frequent elements in the array
// Returning an array consisting of k most appearing elements in the original array
// As the question asks for element's frequency, we have an opportunity to build a map frequency of each element and its number of occurrences. 
// Then we have to sort the map in descending order, but as a hashmap is unordered we cannot sort it; so create a list equivalent of all the map entries and sort the list in descending order. 
// Then create a result array of size k, and then fill it up with the top k elements from the list and return the result array
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> lst = new ArrayList<>(map.entrySet());

        // sort our list in descending order
        lst.sort((a,b) -> b.getValue() - a.getValue());
        
        // Initialize our result array of size k
        int[] result = new int[k];

        for(int i=0; i<k; i++){
            result[i] = lst.get(i).getKey();
        }

        return result;
    }
}
