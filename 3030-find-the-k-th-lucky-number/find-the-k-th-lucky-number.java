public class Solution {

    public String kthLuckyNumber(int k) {
        k = k + 1;
        StringBuilder sb = new StringBuilder();
        while (k > 1) {
            sb.insert(0, ((k & 1) == 1 ? "7" : "4"));
            k >>= 1;
        }
        return sb.toString();
    }
}