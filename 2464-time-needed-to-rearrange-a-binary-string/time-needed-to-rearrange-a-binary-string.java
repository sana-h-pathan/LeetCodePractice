class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int zeroCnt = 0;
        int time = 0;
        for(char ch: s.toCharArray()){
            if(ch=='0'){
                zeroCnt++;
            } else {
                if(zeroCnt>0){
                    time = Math.max(time+1, zeroCnt);
                }
            }
        }
        return time;
    }
}