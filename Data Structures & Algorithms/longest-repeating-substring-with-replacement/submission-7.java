// Input: Given a string s consisting of only uppercase characters and an integer k
// Choose upto k characters of the string and replace them with any other uppercase english character
// After performing at most k replacements, return the length of the longest substring which contains only one disitinct character.
// Essentially, we are supposed to create a longest substring which consists of same characters, but before creation, there might be multiple characters but we can make k replacements to make the substring consist of only one distinct character
// Such substring can be made, when we have absolute clear idea about each character and their number of occurrences
// So what we will do is, for the given current substring, we will build a frequency map of each character and their number of occurrences
// We will choose the character with the most frequency, and replace k characters in the current substring with the character with most frequency
// In a typical brute force approach, we will make a substring with each character of the string as the starting character of our substring. 
// Outer loop selects the starting character, inner loop will be used to build our subset
// A hashmap will be initialized, inside the outer loop which will be used to build frequency maps for each substring
// we will have a global variable to track the longest length of such substring with just one distinct character
// Replacements needed = substringLength - maxFrequency
// if replacements needed <= k
// then replace elements, then check if all chars are same, and count its length

class Solution {
    public int characterReplacement(String s, int k) {
        // int maxLength = 0;
        
        // for(int i=0; i<s.length(); i++){
        //     Map<Character, Integer> map = new HashMap<>();
        //     int maxFrequency = 0;
        //     for(int j=i; j<s.length(); j++){
        //         char c = s.charAt(j);
        //         map.put(c, map.getOrDefault(c, 0) + 1);
        //         // now tracking the highest frequency in this substring
        //         maxFrequency = Math.max(maxFrequency, map.get(c));
        //         // get the substring length
        //         int substringLength = j - i + 1;
        //         int replacementsNeeded = substringLength - maxFrequency;

        //         // Now check if the replacements needed for this substring is less than or equal to k
        //         if(replacementsNeeded <= k){
        //             maxLength = Math.max(maxLength, substringLength);
        //         } else {
        //             break;
        //         }
        //     }
        // }

        // return maxLength;
        // Too slow as string traversal takes O(n^2) at worst
        // We can use a dynamic sliding window approach where left pointer is initially set to 0
        // Right pointer will be used to explore and traverse throughout the string
        // left pointer will point to the starting element of our substring and right to last
        // Instead of rebuilding frequency maps for overlapping substrings 
        // We can just start with one substring initially through a window and keep modifying it
        int maxLength = 0;
        int window_size = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxFrequency = 0;
        for(int right = 0; right<s.length(); right++){
            // keep building frequency map
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));
            while((right-left+1) - maxFrequency > k){
                // slide our window
                // remove the element and decrement its count that was pointed by left pointer
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, (right-left+1));
        }
        return maxLength;
    }
}
