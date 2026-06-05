public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs==null || strs.size()==0){
            return "";
        }
        StringBuilder wl = new StringBuilder();
        StringBuilder words = new StringBuilder();
        for(String str: strs){
            int len = str.length();
            wl.append(len).append("#");
            words.append(str);
        }
        wl.append("/").append(words);
        return wl.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        if(s==null || s.length() == 0){
            return result;
        }
        int idx = s.indexOf("/");
        String wordLengths = s.substring(0, idx);
        String words = s.substring(idx+1);
        String[] wordLength = wordLengths.split("#");
        int prev = 0;
        for(String str: wordLength){
            int wl = Integer.parseInt(str);
            result.add(words.substring(prev, prev+wl));
            prev +=wl;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));