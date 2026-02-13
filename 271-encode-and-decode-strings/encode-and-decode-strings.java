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
        List<String> result = new ArrayList<>();
        if(s==null || s.length()==0){
            return result;
        }
        int idx = s.indexOf("/");
        String wordLength = s.substring(0, idx-1);
        String words = s.substring(idx+1);
        String[] wordLen = wordLength.split("#");
        int prev =0;
        for(String wl: wordLen){
            int length = Integer.parseInt(wl);
            result.add(words.substring(prev, prev+length));
            prev = prev+length;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));