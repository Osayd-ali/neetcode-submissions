// Input: We are given a list of strings
// The algorithm is supposed to convert this list of strings into one string and we are sending this string over a netword to the decode server
// The decode server will take in this string and then return the original list of strings
class Solution {
    public String encode(List<String> strs) {
        // Algorithm to convert the given list of strings into one string
        // So the global encoded string would be the length of each string separated by commas, then we will have a delimeter like a special character and after that we will list all the strings in the list in a concatenated form.
        // eg: {"Hello", "World"}
        // encoded string = {"5,5#helloworld"}
        // we will use an instance of string builder to keep building our encoded string
        StringBuilder sb = new StringBuilder();
        // Compute the length of each string 
        for(String str: strs){
            int length = str.length();
            // add it into our string builder object
            sb.append(length).append(',');
        }
        // Add a delimeter into our sb object
        sb.append('#');
        // compute our concatenated string
        for(String str: strs){
            sb.append(str);
        }
        String encoded_str = sb.toString();
        return encoded_str;
    }
    public List<String> decode(String str){
        if(str.length() == 0){
            return new ArrayList<>();
        }
        // Now we need to decode the encoded string
        // Algorithm to do it
        // first get the length of each string and store it into an array, skip commas
        List<String> res = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();
        int i=0;
        // Also go only until the delimeter part of the string
        while(str.charAt(i) != '#'){
            // Use a stringbuilder object to keep building the lengths which are currently as chars data type 
            StringBuilder curr = new StringBuilder();
            while(str.charAt(i) != ','){
                curr.append(str.charAt(i));
                i++;
            }
            lengths.add(Integer.parseInt(curr.toString()));
            i++;
        }
        i++;
        // Now we have built our lengths for each string in a list
        for(int sz: lengths){
            res.add(str.substring(i, i+sz));
            i = i + sz;
        }
        return res;
    }
}
