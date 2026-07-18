class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      // input: an array of strings
      // output: a List of multiple string lists that are anagrams of each other
      // we would need to access each string and convert into char array so that it can be sorted
      // we would need to sort each char array and convert it back to sorted string
      // the logic of comapring if two strings are anagrams. we will build a hashmap with a sorted string as key and an empty list as its value
      // then for every current string, we will see if the sorted current string already exists in the map, if it does then the current string is the anagram of another string and we add our current string into the list associated with that particular sorted string key. here we are basically building common anagrams list
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
