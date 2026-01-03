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
        int idx = s.indexOf("/");
        String wordLenString = s.substring(0, idx-1);
        String words = s.substring(idx+1);
        String[] wordLength = wordLenString.split("#");
        int old =0;
        for(String wl: wordLength){
            int wordLen = Integer.parseInt(wl);
            result.add(words.substring(old, old+wordLen));
            old= old+wordLen;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));