public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0 ;
        for(int i=0; i < 32; i++){
            //shift result to left so that we can keep on adding numbers to right
            result = result << 1;
            //get rightmost digit
            int right = n &1;
            result  = result | right;
            //remove rightmost digiit from n
            n = n >> 1;
        }
        
        return result;
    }
}