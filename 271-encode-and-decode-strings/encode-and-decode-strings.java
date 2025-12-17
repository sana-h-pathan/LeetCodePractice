public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder wordLength = new StringBuilder();
        StringBuilder str = new StringBuilder();
        for(String word: strs){
            str.append(word);
            wordLength.append(word.length()).append("#");
        }
        wordLength.append("/").append(str);

        return wordLength.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int idx = s.indexOf("/");
        String wordLength = s.substring(0, idx);
        String str = s.substring(idx+1);
        String[] splitLength = wordLength.split("#");
        int old =0;
        for(String wl: splitLength){
            int len = old+Integer.parseInt(wl);
            if(len==0){
                result.add("");
            } else {
                 result.add(str.substring(old, len));
            }
            old = len;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));