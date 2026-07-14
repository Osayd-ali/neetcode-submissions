class Solution {
    public boolean isAnagram(String s, String t) {
        // // Converting s into char array
        // char[] str1 = s.toCharArray();
        // // Converting t into char array
        // char[] str2 = t.toCharArray();
        // Arrays.sort(str1);
        // Arrays.sort(str2);
        // //check equality of char arrays and return boolean value
        // return Arrays.equals(str1, str2);

        // for optimal solution
        // what if we were able to build a map frequency of each string input and map the each character with their frequency of how many times that character is appearing
        //once we have built map frequencies for two strings we could just see if both map frequencies match each other exactly
        // this will be much quicker and happens in O(n) time
        // first convert our string s to char array
        // add an edge case, where if two strings are not matching in length, then they can never be anagrams
        if(s.length() != t.length()){
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        // now build char frequencies of each string by putting them into a hashmap
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c: str1){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c: str2){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        // check for hashmap equality
        return map1.equals(map2);
    }
}
