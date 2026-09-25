// Input: We are given two strings s and t
// Output: Return true if two strings are anagrams of each other
// Anangram means, two strings contain the same characters with each character appearing same number of times but can be in different order
// With each character appearing same number of times?
// Frequency count of element associated
// We could use a hashmap and build a frequency map of each character and how many number of times its appearing in the string for each string. The key will be each character of string and the value will be the particular character's number of occurences.
// Now, as the problem is asking two strings must have same chars with each char appearing same number of times.
// If both string's map of character-frequency count are equal then they will be anagrams of each other. 
class Solution {
    public boolean isAnagram(String s, String t) {
        // Edge case: If two strings are not equal in length then they can never be anagrams
        // if(s.length() != t.length()){
        //     return false;
        // }
        // Now two compare two string's characters with each other
        // What if we had the sorted version of each string? then comparison between equality of chars between two strings would become much easier. 
        // First convert them into char arrays
        // Then sort both char arrays
        // If both char arrays are equal then both strings consist of same characters.
        // char[] sChar = s.toCharArray();
        // char[] tChar = t.toCharArray();
        // Arrays.sort(sChar);
        // Arrays.sort(tChar);
        // return Arrays.equals(sChar, tChar);
        // Time complexity: O(n logn) + O(m logm)
        HashMap<Character, Integer> map1 = new HashMap<>();
        // Build a frequency map of character and its count for string s
        for(char c: s.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        // Build a frequency map of character and its count for string t
        for(char c: t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        return map1.equals(map2);
    }
}
