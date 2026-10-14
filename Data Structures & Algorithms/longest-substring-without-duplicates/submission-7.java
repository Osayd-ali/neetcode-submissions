class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Longest substring without repeating characters
        // Input: a string s
        // find the length of the longest substring without duplicate chars, aka longest substring with all distinct characters.
        // a substring is a contiguous sequence of characters in a substring
        // Since the problem is asking for distinct characters, we can store the chars of our longest substring in a hashset. As hashset only stores distinct elements and discards duplicates
        // For the brute force approach, we can use nested loops
        // we will try and make a sequence of distinct characters for every element of the string as the starting element of their corresponding sequence
        // An outer loop will select the element which will be the starting element of our seq
        // Through an inner loop, we visit all the remaining elements coming from the starting element element, and try to build the sequence
        // In each iteration of the inner loop, we will add elements into our hashset
        // If we come across a duplicate then we break the inner loop and start building next seq
        // A global variable to track the maxLength
        int maxLength = 0;
        for(int i=0; i<s.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j=i; j<s.length(); j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, set.size());
            }
        }
        return maxLength;
    }
}
