// Input: Given an array of strings strs
// Output: Return a list of anagram lists containing anagrams of each other
// To check whether a string is anagram of another string, the most straightforward way is to compare the sorted versions of both strings, if they are equal then they are anagrams. 
// We will use this similar logic in building our anagram lists. 
// Algorithm
// We build a hashmap for the sorted version of each string as key, and an anagram list as its value which will take in the strings which are anagrams of each other
// We will select each string by traversing the array of strings
// then we will build the sorted version of the current string
// then we will check if the sorted version of current string already exists in the map, if it does then we simply add the current string into the anagram list associated with this sorted string
// If the sorted version of current string does not exist in the map, then we add the sorted version of current string as key, and associate an empty list with it as value which will take in future anagrams of this sorted string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] chstr = s.toCharArray();
            Arrays.sort(chstr);
            String sortedstr = new String(chstr);
            if(!map.containsKey(sortedstr)){
                map.put(sortedstr, new ArrayList<>());
            }
            map.get(sortedstr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
