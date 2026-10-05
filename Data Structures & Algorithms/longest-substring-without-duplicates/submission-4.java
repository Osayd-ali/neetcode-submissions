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
        // int maxLength = 0;
        // for(int i = 0; i<s.length(); i++){
        //     HashSet<Character> set = new HashSet<>();
        //     for(int j = i; j<s.length(); j++){
        //         if(set.contains(s.charAt(j))){
        //            break; // duplicate found there is no reason to keep building the substring 
        //         }
        //         set.add(s.charAt(j));
        //     }
        //     // Now compare and add which ever is maximum bw set size and max length
        //     maxLength = Math.max(maxLength, set.size());
        // }
        // return maxLength;
        // But the above approach is taking O(n*m).
        // We must use sliding window approach to reduce the time complexity
        // Maintain two pointers that signfies the first and last index of our dynamic window
        // Initially the left pointer will point to the first character
        // the right pointer will point to the same reference as left initially but will be incremented through our loop that we are using for exploring
        // Left reference is always used to track the first character of our substring
        // Right reference will be used to explore all the distinct characters that will be added into our substring or set, if duplicate is detected, then increment left pointer and remove the character pointer by the left pointer from our set and add the right reference character
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int length = 0;
        for(int right = 0; right<s.length(); right++){
            while(set.contains(s.charAt(right))){ // As long as set contains character pointed by right reference, i.e. duplicate element is found
            // we must remove the character initially pointer by left reference as duplicate is found
            set.remove(s.charAt(left));
            left++;
            }
            set.add(s.charAt(right)); // adding char pointed by our right reference
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}
