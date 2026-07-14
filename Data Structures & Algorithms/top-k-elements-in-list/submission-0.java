class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //access each element of our array
        for(int x: nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // Initializing an array list which will contain a map of integer and integer. and then passing in
        // our previous hash map's entry set into the array list
        List<Map.Entry<Integer, Integer>> arrlst = new ArrayList<>(map.entrySet());
        // Once our list contains our map's entry set values, we will then sort it based on value in descending order
        arrlst.sort((a,b) -> b.getValue() - a.getValue());
        // if you want to sort list containing map in descending order do the above logic.
        // collect the first k elements
        int[] result = new int[k]; // basically this is our result array which will be the size of provided k, this means k values will be filled in the array
        // access our list up until k and get their keys
        for(int i=0; i<k; i++){
            result[i] = arrlst.get(i).getKey();
        }
        return result;
    }
}
