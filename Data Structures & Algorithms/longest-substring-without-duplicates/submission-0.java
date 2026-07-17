class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Input a string s, find the length of the longest substring without duplicate characters
        // for brute force approach, we will have a nested loop. 
        // we start with 0th index for our outer loop and start building subsets starting from ith index.
        // the rest of the elements after i will be visited through our inner loop
        // we keep adding all the elements from ith index into a hashset as it stores only unique elements
        // we keep a check that, if the character at current index j exists in the set then we break the loop entirely and start our new substring from the next index as we found a duplicate
        // or if there is no duplicate, then we add it into our set.
        // once the set for that particular current i is built, we update our res. and start looking for a new substring in the next iteration
        // a tracker which stores the length of our substring with unique characters.
        // we keep updating this tracker when we find a longer substring with unique characters
        int res = 0;
        // once we start with our subset, how do we look for unique characters in it?
        // one way would be, to include our characters of that particular subset into a hashset and check if any duplicates exist
        // if they do not, then update our result with the substring length
        // if duplicates exist, then break the loop and then start the substring from next i until the end.
        for(int i=0; i< s.length(); i++){
            Set<Character> charSet = new HashSet<>();
            for(int j=i; j<s.length(); j++){
                if(charSet.contains(s.charAt(j))){ // duplicate exists
                    break;
                }
                charSet.add(s.charAt(j));
            }
            res = Math.max(res, charSet.size());
        }
        return res;
        // use sliding window
        // Instead of restarting at every index like brute force, we can keep one window that always has unique characters.
        //We expand the window by moving the right pointer.
        // If we ever see a repeated character, we shrink the window from the left until the duplicate is removed.
        // l = left edge of the window
        // r = right edge that moves through the string
        // HashSet<Character> charSet = new HashSet<>();
        // int l = 0;
        // int res = 0;

        // for (int r = 0; r < s.length(); r++) {
        //     while (charSet.contains(s.charAt(r))) {
        //         charSet.remove(s.charAt(l));
        //         l++;
        //     }
        //     charSet.add(s.charAt(r));
        //     res = Math.max(res, r - l + 1);
        // }
        // return res;
    }
}
