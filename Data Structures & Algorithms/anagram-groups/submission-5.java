// Input: array of strings strs
// Output: Group all anagrams together into sublists
// i.e. strings which are anagrams of each other should be combined into a sublist
// Then we are supposed to return the array of sublists
// What we can do is
// for each string in our array of strings
// We can turn each string into a char array and sort it
// then we build a map of the sorted version of a string as key and an empty list associated with it as value 
// Then we start creating sublists of similar anagrams
// We select each string and check if the sorted version of the current string is equal to the sorted string already existing in the map, if it is then we add the current string into the sub list associated with that particular sorted str
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] strchar = s.toCharArray();
            Arrays.sort(strchar);
            String sortedstr = new String(strchar);

            // Now add this sorted string as key into our map, and an empty list associated with it as value if our map does not contain it
            if(!map.containsKey(sortedstr)){
                map.put(sortedstr, new ArrayList<>());
            }
            // if our map does contain the sorted version of current string, then add the current string as value into the array list associated with the already existing sorted of this string. Here we are building our anagram strings list
            map.get(sortedstr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
