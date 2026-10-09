//Input: Given two strings s and t
// Return true if both strings are anagrams of each other
// Anagram means, both strings contain the same characters but can be in different order
// The most brute force approach would be, convert the strings into the sorted versions of each of them, and check if both sorted strings are equal
// For ease of sorting, we convert strings into char arrays and sort them
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(schar, tchar);
    }
}
