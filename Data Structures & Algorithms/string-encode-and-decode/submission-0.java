class Solution {
    // encode a list of strings into a string
    // how are we encoding it?
    // the encoded string thats being sent over the network, will have the lengths of each string separated by commas
    // then once the lengths are added, we will put a # as a differentiator
    // and then we will start appending all our strings after the hashmark
    // we will get the lengths of each string
    // then we will make a list that contains the lengths of all our strings
    // we will also have a stringbuilder object, here we are building our encoded string
    // we will then put all our lengths into the sb object separated by commas
    // then we will put a # symbol
    // then put all our strings into sb object
    // finally we return the string version of sb object
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for(String s: strs){
            sizes.add(s.length());
        }
        for(int size: sizes){
            res.append(size).append(',');
        }
        res.append('#');
        for(String s: strs){
            res.append(s);
        }
        return res.toString();
        
    }
    // encoded string is then sent over a network and decoded back to the original list of strings 
    public List<String> decode(String str) {
        // if we were given an empty list, then return an empty list
        if(str.length() == 0){
            return new ArrayList<>();
        }
        // the below is our list which will contain our result of list of strings
        List<String> res = new ArrayList<>();
        // the below list will contain all the sizes of our strings
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for (int sz : sizes) {
            // if we want to access the words that are associated with each length, then the below logic works
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;

    }
}
