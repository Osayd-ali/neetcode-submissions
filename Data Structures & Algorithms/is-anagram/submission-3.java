class Solution {
    public boolean isAnagram(String s, String t) {
        // strings s and t should have the same characters but can be in different order.
        // brute force, if we are checking for equality of characters in both strings
        // we cna just convert the strings into character array and then sort them and then compare if they are equal
        // return true if they are equal 
        // char[] sarr = s.toCharArray();
        // char[] tarr = t.toCharArray();
        // Arrays.sort(sarr);
        // Arrays.sort(tarr);
        // return Arrays.equals(sarr, tarr);
        // build a map of each character and their frequency count for each of the strings and compare if both maps are equal
        // base condition if both string's length is not equal then they can never be anagrams so return false 
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        // building frequency map for each character in s
        for(char c: s.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        // building frequency map for each character in s
        for(char c: t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        return map1.equals(map2);
    }
}
