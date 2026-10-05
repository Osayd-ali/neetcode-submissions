// Input: given an input string s, of only uppercase english characters, and an integer k
// Choose upto k characters of the string and replace them with any other uppercase English character
// After performing at most k replacements, return the length of the longest substring which contains only one distinct character
//So after the modification, look for the longest substring which contains only one distinct character, or look for a contiguous sequence where only one distinct character is appearing
// Select an index, initially first index and record its character, as we may be replacing the next k sequence of characters with the current character
// Maintain a window of size k, and replace k characters
// Or we could build a frequency map for each character and their count, then the character which appears the most times, will become our candidate which is going to replace k characters
// First build a map for each character and their frequency for the string s
// Use a nested loop approach
// The outer loop is used for selecting the starting character of our supposed longest substring of same characters
// Through the inner loop, we actually start visiting each element of our string from the starting element and start building our substring of same characters
// The following is the logic for actually building our substring of same chars
// We will initialize a hashmap, and build a map frequency for each character and record its number of occurrences in our substring
// The question asks us to replace at most k characters of the string so that we can build our longest substring of same chars
// Once a frequency map of each char and its frequency is built, we select the character with the most frequency, then we check if the remaining characters in our substring is less than or equal to k.
// if the remaining chars is less than or equal to k, then we update our length to take in whichever is greater between last recorded length of substring or current length of substring
class Solution {
    public int characterReplacement(String s, int k) {
        // int length = 0; // initially length of our longest substring with one distinct char is 0
        
        // // Starting our outer loop to select a character as starting element of our substring
        // for(int i=0; i<s.length(); i++){
        //     // Initialize a hashmap to build a frequency map for each char and its count for the following substring with current char as starting element
        //     HashMap<Character, Integer> count = new HashMap<>();
        //     // we need a variable to record the char with most frequency as well
        //     int maxf = 0;
        //     for(int j=i; j<s.length(); j++){
        //         count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
        //         maxf = Math.max(maxf, count.get(s.charAt(j))); // the old recorded max frequency of a particular char, or the frequency count of current char, whichever is greater make it our new max frequency char
        //          // Now if the number of remaining characters in our substring excluding the character with most frequency, is less than or equal to k, then we update the final length of our substring with this substring's length
        //         if((j-i+1) - maxf <= k){
        //             length = Math.max(length, (j-i+1));
        //         }
        //     }    
        // }
        // return length;
        // But this is happening in O(n^2)
        // What if, instead of creating a new substring for each element of the string as the starting element of our new substring and starting the whole process for each character
        // What if we were able to maintain a dynamic window, keep removing the disregarded char and at the same time keep adding the newly considered char within the same loop
        // so the left pointer will be used to determine the starting element of our sublist
        // The right pointer will be used to explore each character in the string and will visit each index in the string as long as its inside the string, also right pointer will determine the ending index of the window 
        int length = 0;
        int left = 0;
        // Keep adding each character pointed by right reference into our hashmap 
        // and build character frequency 
        HashMap<Character, Integer> map = new HashMap<>();
        int maxf = 0; // variable to hold the frequency of most frequently appearing character
        for(int right = 0; right<s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);  
            maxf = Math.max(maxf, map.get(s.charAt(right)));
            while((right - left + 1) - maxf > k){ // as long as the remaining elements of our window excluding the char with the most frequency is greater than k, keep running this loop
                // Decrement the count for the character pointed by left reference in the map
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            length = Math.max(length, (right - left + 1));  
        }
        return length;
    }
}
