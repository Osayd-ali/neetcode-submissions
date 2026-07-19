class Solution {
    public String longestPalindrome(String s) {
        // input which is a string s
        // output: return the longest substring of s that is a palindrome
        // this problem might be a combination of longest subset
        // and palindrome
        // intuition: we will utilize a two pointer approach where we will keep track of our search window where we are trying to find if that search window is a palindrome
        // the outer loop i will signify the starting point of our subset
        // through our inner loop, j will signify the ending point of our subset
        // now use two pointers to check if the characters at either points of our subset is equal
        String palindrome = "";
        int palindromelen = 0;

        // outerloop i signifies the starting point of our subset
        for(int i = 0; i<s.length(); i++){
            //innerloop j signifies the ending point of our subset
            for(int j=i; j<s.length(); j++){
                // now use two pointers logic to know if this subset is a palindrome
                int left = i;
                int right = j;
                while(left<right && s.charAt(left) == s.charAt(right)){
                    left++;
                    right--;
                }// keep running this loop as long as starting index of our subset is less than the ending index of our subset
                // and also, keep running as long as the values at either index are equal this ensures our subset string is being a palindrome
                if(left >= right && palindromelen < (j - i +1)){
                    // as soon as left pointer becomes equal to right pointer
                    // that means our convergent two pointers has become successful
                    // and all characters in our subset has been compared and proved to be equal
                    // now this code will run
                    palindrome = s.substring(i, j+1);
                    palindromelen = j-i+1;
                }
            }
        }

        return palindrome;
    }
}
