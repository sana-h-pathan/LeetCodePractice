public class Codec {

    public String encode(List<String> strs) {
        StringBuilder str=new StringBuilder();
        StringBuilder strLen=new StringBuilder();
        int wl=0;
        for(String s: strs){
            System.out.println(s);
            wl=s.length();
            strLen.append(wl).append("#");
            str.append(s);
        }
        strLen.append("/").append(str);
        return strLen.toString();
    }

    public List<String> decode(String str) {
        List<String> result=new ArrayList<>();
        int idx = str.indexOf('/');
        String lenStr=str.substring(0,idx);
        String textStr=str.substring(idx+1,str.length());
        String[] strArr=lenStr.split("#");
        int old=0;
        for(String sl:strArr){
            int size=old+Integer.parseInt(sl);
             if(size==0)
                result.add("");
            else{
                result.add(textStr.substring(old,size));
                old=size;
            }
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));