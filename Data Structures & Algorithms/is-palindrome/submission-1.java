class Solution {
    public boolean isPalindrome(String s) {
        // First filter the given string and remove all white spaces
        // Use string builder
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        // now we will have a string with all lower case characters and numbers without any spaces
        // now convert this into a char array and use convergent two pointers approach
        char[] cleanedstr = sb.toString().toCharArray();
        int left = 0;// point our left pointer to 0th index of char array
        int right = cleanedstr.length - 1; //point our right most pointer to the last index of the array
        // now use convergent two pointer. 
        // start comparing left most value with right most value
        // the loop will keep running until left and right pointers become equal, this means each left character was equal to each right character for every iteration
        // this means the string is indeed a palindrome so return true
        while(left <= right){
            // if the characters are not equal then return false
            if(cleanedstr[left] != cleanedstr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
