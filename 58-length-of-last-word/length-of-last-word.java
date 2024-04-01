class Solution {
    public int lengthOfLastWord(String s) {
        String[] str=s.split(" ");
        int strSize=str.length;
        return str[strSize-1].length();
    }
}