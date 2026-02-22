public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs==null || strs.size()==0){
            return "";
        }
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
        List<String> result = new ArrayList<>();
        if(s==null || s.length()==0){
            return result;
        }
        int idx = s.indexOf("/");
        String wordLenStr = s.substring(0, idx-1);
        String words = s.substring(idx+1);
        int prev = 0;
        String[] wordLen = wordLenStr.split("#");
        for(String len: wordLen){
            int wl = Integer.parseInt(len);
            result.add(words.substring(prev, prev+wl));
            prev = prev+wl;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));