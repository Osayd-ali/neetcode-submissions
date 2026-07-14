class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //First initialize a hashmap where we are gonna map sorted string with their respective anagram list
        HashMap<String, List<String>> map = new HashMap<>();
        // iterate through the array and access each string
        for(String str: strs){
            // convert each string into char array
            char[] chstr = str.toCharArray();
            Arrays.sort(chstr);
            String strsorted = new String(chstr);
            // Build a map with this sorted string as key and a list containing similar anagrams with this sorted string
            if(!map.containsKey(strsorted)){
                map.put(strsorted, new java.util.ArrayList<>());
            }
            map.get(strsorted).add(str); 
        }
        return new ArrayList<>(map.values());
    }
}
