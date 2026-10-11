// Input: Given an input string s
// return true if its is a palindrome otherwise return false
// A palindrome means the string spells the same either forward or backwards
// It is also case insensitive, that mean A and a will be treated as same
// We have an edge case here of, the language not treating capital and small letters as same but palindrome considers it as same, to address this we must convert all the given characters of the string into either upper case or lower case
// Also palindrome ignores all non alphanumeric characters
// So the character class exposes a method which only take is letters or digits from a given char array we could utilise that
// So step 1, address all the edge cases and build the cleaned version of the input string without any non alphanumeric characters and all characters following lower case 
// Once we have that we can start building the algorithm for actually finding out if the given cleaned version of a string is palindrome or not
// Logic is simple, use a convergent two pointer approach
// left pointer will start at 0th index and right pointer will start at end index
// Keep converging both pointers left incrementally and right decrementally, as long as the characters pointer by left and right pointers are equal 
// If at any point during our two pointers converging, we come across the characters pointer by left and right pointer not being equal, immediately return false as it cant be a palindrome anymore
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        // start visiting each character in the string
        for(int i=0; i<s.length(); i++){
            char c = Character.toLowerCase(s.charAt(i));
            if(!Character.isLetterOrDigit(c)){
                continue;
            }
            sb.append(c);
        }
        String cleanedstr = sb.toString();

        int left = 0;
        int right = cleanedstr.length() - 1;
        while(left < right){
            if(cleanedstr.charAt(left) != cleanedstr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
