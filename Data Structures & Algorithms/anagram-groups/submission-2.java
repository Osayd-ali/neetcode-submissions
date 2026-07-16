class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      // we will need to return a list which contains a list of similar anagrams
      // first we would need to access each string from our string array
      // so we will create a loop for accessing each individual string
      HashMap<String, List<String>> map = new HashMap<>();
      for(String s : strs){
        // we will get the sorted version of each string
        // then we will build a map by inserting the string as key and associate it with a list which will hold its anagrams
        char[] chstr = s.toCharArray();
        // sort the converted char array
        Arrays.sort(chstr);
        // store it in a new variable called as sorted string
        String sortedstr = new String(chstr);
        // we will start adding this sorted string into our hashmap 
        // we will keep a check, if the sorted string does not exist , then only we add it into our hashmap, if it does, then we just add the original string into the list associated with the existing sorted string in the map
        if(!map.containsKey(sortedstr)){
            map.put(sortedstr, new ArrayList<>());
        }
        map.get(sortedstr).add(s);
      }
      return new ArrayList<>(map.values());
    }
}
