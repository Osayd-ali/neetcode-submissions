// Input: Given two strings s and t
// Output: Return true if strings s and t are anagrams of each other
// Two strings are anagrams of each other, if both of them contain same character appearing same number of times but can differ in order.
class Solution {
    public boolean isAnagram(String s, String t) {
        // Edge case:
        // if two are of different length, then they can never be anagrams of each other
        // if(s.length() != t.length()){
        //     return false;
        // }
        // // Brute force approach:
        // // Convert the two strings into char arrays so that we can sort them alphabetically 
        // // Once sorted, check if two sorted arrays are equal, if they are then return true
        // char[] schar = s.toCharArray();
        // char[] tchar = t.toCharArray();
        // Arrays.sort(schar);
        // Arrays.sort(tchar);
        // return Arrays.equals(schar, tchar);
        // Optimized solution: Use a hashmap
        // For both of the strings, build a frequency map of each character and its associated frequency count. If map equivalents of both strings are equal then they are anagrams of each other
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c: s.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c: t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        return map1.equals(map2);
    }
}
