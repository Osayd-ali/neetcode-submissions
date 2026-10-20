// Input: Given two strings s and t
// Output: Return boolean true or false, true if both strings are anagrams of each other
// False otherwise 
// Two Strings are anagrams of each other if they contain the same characters but can be in different order, Two strings MUST be of same length
// A brute force approach would be, Compare the equality for the sorted versions of both strings
// It takes O(n logn) time as there is a sorting step involved
class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] schar = s.toCharArray();
        // char[] tchar = t.toCharArray();

        // Arrays.sort(schar);
        // Arrays.sort(tchar);

        // return Arrays.equals(schar, tchar);
        // Brute force approach too slow, takes O(n logn) time. 
        // Another approach would be to build a frequency map of each character and their count for both of the input strings
        // Check if the map equivalents of both strings are equal
        // If they are anagrams, then they have to be equal, as both strings will have same characters repeating same number of times regardless of their original order in their strings
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
