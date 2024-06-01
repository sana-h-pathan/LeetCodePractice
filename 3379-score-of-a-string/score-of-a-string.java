class Solution {
    public int scoreOfString(String s) {
        char[] charArr=s.toCharArray();
        int result=0;
        for(int i=1;i<charArr.length;i++){
            result+=Math.abs((int) charArr[i-1]-(int) charArr[i]);
        }
        return result;
    }
}