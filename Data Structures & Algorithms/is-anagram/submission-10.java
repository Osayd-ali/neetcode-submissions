//Input: Given two strings s and t
// Return true if both strings are anagrams of each other
// Anagram means, both strings contain the same characters but can be in different order
// The most brute force approach would be, convert the strings into the sorted versions of each of them, and check if both sorted strings are equal
// For ease of sorting, we convert strings into char arrays and sort them
class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] schar = s.toCharArray();
        // char[] tchar = t.toCharArray();
        // Arrays.sort(schar);
        // Arrays.sort(tchar);
        // return Arrays.equals(schar, tchar);
        // // time complexity: O(n logn) + O(n logn) = O(n logn)
        // A faster approach would be, 
        // to build a frequency map of each character of both strings and their number of occurrences
        // if both string's frequency map equivalents are equal then we can say that they are anagrams of each other
        // This way we are reducing the time complexity from O(n logn) to O(n)
        // As we just need to traverse both strings through for loop and fill in our maps 
        Map<Character, Integer> map1 = new HashMap<>();
        for(char c: s.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for(char c: t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        return map1.equals(map2);
    }
}
