class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Input: We are given a string s
        // Output: Return the length of the longest sequence of characters without duplicate elements and the sequence must be contiguous. Longest substring without repeating characters
        // S = {zxyzxy}
        // length = 3, {zxy}
        // Try to build the longest sequence of contiguous characters with each character in the string as the starting element and keep building the substring until we find a duplicate character
        // But the substring that we just built, could still contain duplicates inside them, to address that, when we are building the substring we must add each character in a hashset if that character wasnt already in the set, this way we are avoiding duplicates inside our substring
        // So, Outer for loop for selecting each character as the starting element of our contiguous substring 
        // Then inner loop, to visit all the remaining characters to build upon our substring, and each current character will be added into our set, then we record that particular set's size and assign that size or maxLength which ever is greater
        int maxLength = 0;
        for(int i = 0; i<s.length(); i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = i; j<s.length(); j++){
                if(set.contains(s.charAt(j))){
                   break; // duplicate found there is no reason to keep building the substring 
                }
                set.add(s.charAt(j));
            }
            // Now compare and add which ever is maximum bw set size and max length
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
