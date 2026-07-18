class Solution {
    public boolean isPalindrome(String s) {
       // check if a string is a palindrome or note
       // palindrome means the string must read the same forwards and backwards
       // if its a palindrome then return true or else return false
       // string must not have white spaces, and must only contain alpha numeric characters
       StringBuilder sb = new StringBuilder();
       // access each character in our input string and as long as its a letter or digit keep appending into our sb object
       for(char c: s.toCharArray()){
        if(Character.isLetterOrDigit(c)){
            sb.append(Character.toLowerCase(c));
        }
       }
       // our string preprocessing is done convert our sb object into string object and then into character
       char[] cleanedstr = sb.toString().toCharArray();
       // now start convergent two pointer logic
       int left = 0;
       int right = cleanedstr.length-1;
       while(left<=right){
        if(cleanedstr[left] == cleanedstr[right]){
            left++;
            right--;
        } else {
            return false;
        }
       }
       return true;
       
    }
}
