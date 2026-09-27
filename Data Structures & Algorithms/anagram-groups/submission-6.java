// Input: array of strings strs
// Output: Group all anagrams together into sublists and return the list of anagram sublists
// We will maintain a hashmap which will have sorted version of each string and an empty list associated with it which will eventually have anagrams of sorted string existing in key for this particular list
// Approach: Traverse through our array of strings
// For each string; convert it into the sorted version of the string
// Then, if the sorted list does not exist in the map, then add it into our map as key and create an empty list as value associated with it
// If the string already exists, then just put the current string inside the list associated with the sorted version of current string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] chstr = s.toCharArray();
            Arrays.sort(chstr);
            String sortedstr = new String(chstr);

            if(!map.containsKey(sortedstr)){
                // if the sorted version of current string does not exist in our hashmap
                // then add it into our hashmap and create an empty list associated with it which will contain its anagrams
                map.put(sortedstr, new ArrayList<>());
            }
            // If the sorted version of current string already exists in map, then add the normal string into the list associated with it
            map.get(sortedstr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
