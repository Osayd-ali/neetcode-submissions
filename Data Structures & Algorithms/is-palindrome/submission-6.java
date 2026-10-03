class Solution {
    public boolean isPalindrome(String s) {
        //Input: Given a string s
        // Output: Return true if it is a palindrome or else false
        //Palindrome means, the string is spelled the same when its reversed to its original form. basically reverse of string is equal to original string
        // This means, each character at two opposite indexes should be equal
        // Approach: Apply a convergent two pointer approach, and check for equality of characters pointed by both left and right indices in each iteration 
        // We should ignore all non alphanumeric characters\
        // So format the string to only take in alphanumeric characters of the string 
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        String cleanedStr = sb.toString();
        int left = 0; 
        int right = cleanedStr.length() - 1;
        // As long as characters pointed by both indices are equal, keep running the loop and increment left pointer and decrement right pointer, at any point if they are not equal, then the string can never be a palindrome and return false
        while(left < right){
            if(cleanedStr.charAt(left) != cleanedStr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
