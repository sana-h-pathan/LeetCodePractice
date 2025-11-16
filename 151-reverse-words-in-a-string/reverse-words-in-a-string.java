class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        String[] sArr=s.split(" ");
        int n=sArr.length;
        for(int i=n-1;i>=0;i--){
            if(sArr[i].length()>0){
                sb.append(sArr[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}