// Input: Given an integer array nums
// Output: Return the top k most frequently occuring elements in the array
// Create a frequency map of each element and its number of occurrences
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // start filling the map
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // HashMap cannot be sorted, so convert it into an array list
        List<Map.Entry<Integer, Integer>> lst = new ArrayList<>(map.entrySet());
        // sort the list in descending order based on frequency count of elements
        lst.sort((a,b) -> b.getValue() - a.getValue());
        // create our result array of size k
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = lst.get(i).getKey();
        }
        return result;
    }
}
