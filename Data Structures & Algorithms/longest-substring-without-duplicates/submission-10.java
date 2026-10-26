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
        // int maxLength = 0;
        // for(int i=0; i<s.length(); i++){
        //     Set<Character> set = new HashSet<>();
        //     for(int j=i; j<s.length(); j++){
        //         if(set.contains(s.charAt(j))){
        //             break;
        //         }
        //         set.add(s.charAt(j));
        //         maxLength = Math.max(maxLength, set.size());
        //     }
        // }
        // return maxLength;
        // But too slow, takes O(n^2) running time complexity
        // Since the problem asks for longest contiguous sequence we have an opportunity to use dynamic sliding window approach -> time complexity of O(n)
        // a global variable to track the max length of the sequence
        // left pointer points to 0th index initially
        // right pointer will determine the window size and will be used to traverse and explore each character in our string
        // in each iteration, we will keep adding the characters in the particular window to our hashset and caculate the length
        // if the window violates the condition, as in, if set contains the character then we mover left pointer in wards to slide our window, and remove the character pointed by left from our set and add the character pointer by right
        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right<s.length(); right++){
            while(set.contains(s.charAt(right))){
                // time to slide our window 
                // remove element pointed by left index and add element pointed by right
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
