class Solution {
    public int lengthOfLongestSubstring(String s) {
        // trying to find out longest substring without repeating characters
        // O(n^2), which is bad in terms of running time complexity 
        // find the length of the longest substring with all unique characters
        // input would be a string
        // initially we will have a tracker which will contain the length of our resultant substring, initially we will assign it as 0
        // one way to find out unique characters is, once we have a substring, we will add the characters of those in a hashset as it only stores unique characters
        // if we find a duplicate, then the substring is not unique now and we will change our search window, by moving our i index to the next pointer
        // int length = 0;
        // char[] chstr = s.toCharArray();
        // for(int i=0; i<chstr.length; i++){ // this is for deciding the starting point of our substring
        //     Set<Character> charSet = new HashSet<>();
        //     for(int j=i; j<chstr.length; j++){ //this loop is actually where insertion of elements into the set happens
        //         if(charSet.contains(chstr[j])){
        //             break;
        //         }
        //         charSet.add(chstr[j]);
        //         // update our length counter in each iteration
        //         length = Math.max(length, charSet.size());
        //     }
        // }
        // return length; 
        // reduce the time complexity from O(n^2) to O(n)
        // for the optimal approach we can use a sliding window two pointer approach.
        // since this problem asks for longest sequence, we cannot have our search space constant
        // we would need to maintain a dynamic search space, as in, increasing or decreasing our window size based on the conditions being met
        // here, if we want to increase our window size,if we come across any duplicate characters while adding in our hashset
        // then simply increment our left pointer and shift our window to a different search space within the array
        // Convert the given string into an array
        char[] chstr = s.toCharArray();
        // logic remains the same,create a hashset which will contain the sequence of unique characters
        // maintain two pointers that will signify our window of searching for unique characters
        // left pointer will point to 0th index at first
        // right pointer will start from 0th index, right pointer signifies the last index of our specific search window
        int length = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right<chstr.length; right++){
            while(set.contains(chstr[right])){ // duplicate exists, as long as duplicate character is found run this while loop
                // we will remove that particular character from the set
                set.remove(chstr[left]);
                // we increment our left pointer to go to the next index
                left++;
            }
            // for each character visited, keep adding to our hashset
            set.add(chstr[right]);
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}
