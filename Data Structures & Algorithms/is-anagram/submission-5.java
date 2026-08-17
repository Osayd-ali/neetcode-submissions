// Input: given two strings s and t
// output: return true if two strings are anagrams of each other
// What is an anagram?
// two strings are anagrams of each other if they have exactly the same characters but can be in different order
// two strings which are different in length can never be anagrams of each other (edge case)
// Brute force solution:
// first convert both of the strings into char arrays so that we can sort them 
// once after sorting, check of array equality between two character arrays
// return true if they are equal
class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] schar = s.toCharArray();
        // char[] tchar = t.toCharArray();
        // Arrays.sort(schar);
        // Arrays.sort(tchar);
        // return Arrays.equals(schar, tchar);
        // takes more memory and also more time O(n logn).
        // we need more efficiency, perhaps we can use a hashmap to build character frequencies for each string and then check for equality of these hashmaps
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c: s.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c: t.toCharArray()){
            map2.put(c, map2.getOrDefault(c,0) + 1);
        }
        return map1.equals(map2);
    }
}
