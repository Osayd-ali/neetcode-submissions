class Solution {
    public boolean isAnagram(String s, String t) {
        // input is two strings s and t
        // output: return true if two strings are anagrams
        // anagram means two strings have same characters but can be in different order
        // brute force approach, convert both strings into char arrays then sort those arrays
        // now check for equality of arrays, if both are equal then they are anagrams
        // edge case: if two strings are different in lengths, then they can never be anagrams
        // if(s.length() != t.length()){
        //     return false;
        // }
        // char[] schar = s.toCharArray();
        // char[] tchar = t.toCharArray();
        // Arrays.sort(schar);
        // Arrays.sort(tchar);
        // return Arrays.equals(schar, tchar);
        // optimal approach: build a map of each character and their frequency for each string
        // if both maps are equal then they are anagrams
        if(s.length() != t.length()){
            return false;
        }
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
