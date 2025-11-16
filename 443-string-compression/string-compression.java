class Solution {
    public int compress(char[] chars) {
        List<String> temp=new ArrayList<>();
        if(chars.length==1)
            return 1;
        int slow=0;
        int fast=0;
        int i=0;
        int n= chars.length;
        while(fast<n){
            char c=chars[fast];
            while(fast<n && chars[fast]==chars[slow]){
                fast++;
            }
            chars[i++]=c;
            int count = fast - slow;
            if (count > 1) {
                String cntStr = String.valueOf(count);
                for (char digit : cntStr.toCharArray()) {
                    chars[i++] = digit;
                }
            }
            slow=fast;
        }
        return i;
        
    }
}