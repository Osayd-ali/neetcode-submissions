// Algorithm to encode a list of strings {'hello', 'Back', 'okay', 'done'}
// The list of strings should be encoded into ONE string and then should be sent over the network to another receiver
// The receiver, should be able to decode the ONE string into the original list of strings
// Whats the algorithm for encoding the list of strings into ONE string?
// What we can do is, for each string in our list, we calculate each string's length
// So our encoded ONE string for the list of multiple strings is basically length of each string
// The lengths of each string should be then separated by commas, then we add a special character and then we list all the original words together concatenated in a continuous way.
// like 'hello' -> 5, 'Back' -> 5 {'Hello', 'back'}
// encoded string should be encodedStr = '5,5,#helloback'.
// So while decoding, we know how to extract the original words coming after the special character as we already provided the lengths of each string associated with the words before the special character appearing
class Solution {

    public String encode(List<String> strs) {
        // We need to use a StringBuilder object to build our encoded string
        // As String objects are immutable that is unchangeable, everytime we make a change to a String object a new string will be created so a lot of memory wasted. However, StringBuilder objects are mutable i.e. Changeable, so only with one object we can keep modifying the string and building it
        StringBuilder sb = new StringBuilder();
        // Access each string from the list
        for(String s: strs){
            int length = s.length();
            sb.append(length).append(',');
        }
        // Once our lengths followed by commas is added, we add a delimiter (through a special character) to separate the lengths and concatenated string
        sb.append('#');
        // Now we add all of our strings from the list to our sb object
        for(String s: strs){
            sb.append(s);
        }
        // Now convert our string builder object into a string
        String encodedStr = sb.toString();
        return encodedStr;
    }

    public List<String> decode(String str) {
        // Edge case: if the encoded string's length is 0, then just return an empty list
        if(str.length() == 0){
            return new ArrayList<>();
        }
        // Algorithm for decoding the encoded String
        // We need to first access each lengths of the string
        // Then go to the immediate next index coming after the delimeter
        // And extract only that amount of characters the current length signifies
        // Then add the string to our result list.
        List<String> result = new ArrayList<>();
        // Also maintain a list of Integers which will take in each individual string's length
        List<Integer> sizes = new ArrayList<>();
        // Instead of converting the encoding string to a char array to access each of its characters,
        // We will directly access each character in string through string indices
        int i=0;
        // As long as we dont reach the delimeter the "special character" in our encoded string we will keep the loop running
        while(str.charAt(i) != '#'){
            StringBuilder sb = new StringBuilder();
            // As long as we dont reach the comma "," in our encoded string we will keep running the below loop, this way we are retrieving the lengths of each string
            while(str.charAt(i) != ','){
                sb.append(str.charAt(i)); // here we are retrieving the length and adding it into our string object. 
                i++;
            }
            sizes.add(Integer.parseInt(sb.toString()));
            i++;
        }
        // Once we have reached the delimeter, we increment it to go to the immediate next character which is the starting character of our concatenated strings
        i++;
        // access each length from our list of sizes
        for(int sz: sizes){
            result.add(str.substring(i, i+sz)); // providing beginning and ending index for retrieving the original individual string associated with the current length (i.e. sz);
            // Then go to the next index coming after the current length 
            i = i+sz;
        }
        return result;
    }
}
