public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder wordLen = new StringBuilder();
        StringBuilder words = new StringBuilder();
        for(String str: strs){
            int len = str.length();
            wordLen.append(len).append("#");
            words.append(str);
        }
        wordLen.append("/").append(words);
        return wordLen.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()==0){
            return result;
        }
        int idx = s.indexOf("/");
        String wordsLen = s.substring(0, idx-1);
        String words = s.substring(idx+1);
        String[] wl = wordsLen.split("#");
        int prev = 0;
        for(int i=0;i<wl.length;i++){
            int currLen = Integer.parseInt(wl[i]);
            result.add(words.substring(prev, prev+currLen));
            prev = prev+currLen;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));