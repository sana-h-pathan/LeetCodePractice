public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder wordLength = new StringBuilder();
        StringBuilder words = new StringBuilder();
        for(String str: strs){
            int wl = str.length();
            wordLength.append(wl).append("#");
            words.append(str);
        }
        wordLength.append("/").append(words);
        return wordLength.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        //5#5#/HelloWorld
        List<String> result = new ArrayList<>();
        int idx = s.indexOf("/");
        String wl = s.substring(0, idx);
        String words = s.substring(idx+1);
        String[] wordLength = wl.split("#");
        int oldLength = 0;
        for(String wLen: wordLength){
            int len = Integer.parseInt(wLen);
            if(len==0){
                result.add("");
            }else {
                result.add(words.substring(oldLength, oldLength+len));
                oldLength = oldLength+len;
            }
            
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));