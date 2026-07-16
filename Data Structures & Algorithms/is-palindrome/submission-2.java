class Solution {
    public boolean isPalindrome(String s) {
        // Input: A String s
        // Output: return true if a string is a plaindrom
        // Palindrome means the string will read the same forwards and backwards if spaces are ignore
        // palindrome is case insensitive and ignore non alphanumeric characters
        // Clean the string and remove all white spaces and only take alphanumeric characters from it
        // once we have processed our string, convert it into a char array and implement convergent two pointers
        // keep checking for equality of left index value and right index value, if characters are equal in each iteration
        // then increment left and decrement right
        // if at any point, characters are not equal return false and break the loop as string cannot be a palindrome.
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        char[] cleanedstr = sb.toString().toCharArray();
        // start our two pointer algorithm here to process our cleaned char array
        int left = 0;
        int right = cleanedstr.length-1;

        while(left<=right){
            if(cleanedstr[left] != cleanedstr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
