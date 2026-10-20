//Input: Encode a list of strings to a string
// the encoded string is then sent over the network and is decoded back to the original list of strings
// encoding a string
// We are given a list of strings, find a way to encode this list of strings into ONE string
// so the encoded string will consist of the length of each string separated by commas, then a delimeter then a concatenated string of all strings
class Solution {
    public String encode(List<String> strs) {
        // Find the length of each string and add it to our stringbuilder object, separated by commas
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            int length = s.length();
            sb.append(length).append(",");
        }
        // Add a delimeter
        sb.append("#");
        // Now add the concatenated version of all strings
        for(String s: strs){
            sb.append(s);
        }
        // Now convert it into a String object
        String encodedStr = sb.toString();
        return encodedStr;
    }
    public List<String> decode(String str){
        // We have an encoded string
        // first we need to retrieve the lengths of each string from encoded str
        // We store them into an array list
        // then we access that array's each length; then go to the starting character of each string and store that amount of characters as each string into our result list of strings
        List<Integer> lengths = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int i=0;
        // keep going until we hit the delimeter, to store lengths
        while(str.charAt(i) != '#'){
            // keep going until we come across a comma
            StringBuilder sb = new StringBuilder();
            while(str.charAt(i) != ','){
                sb.append(str.charAt(i));
                i++;
            }
            int length = Integer.parseInt(sb.toString());
            lengths.add(length);
            i++;
        }
        // Go past the delimeter
        i++;
        // now access each length from lengths array list
        for(int sz: lengths){
            // go until the length signified by current iteration and extract that substring and store it into our list
            String s = str.substring(i, i+sz);
            result.add(s);
            // we now move our i to go to the first char of the next string
            i += sz;
        }
        return result;
    }
}
