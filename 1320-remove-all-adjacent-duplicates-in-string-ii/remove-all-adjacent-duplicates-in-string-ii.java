class Solution {
    public String removeDuplicates(String s, int k) {
        char[] sChar = s.toCharArray();
        Stack<Integer> freqStack = new Stack<>();

        int j = 0; // index where we j the final string

        for (int i = 0; i < sChar.length; i++) {
            sChar[j] = sChar[i];

            // Case 1: new character starts
            if (j == 0 || sChar[j] != sChar[j - 1]) {
                freqStack.push(1);
                j++;
            } 
            // Case 2: same as previous character
            else {
                int count = freqStack.pop() + 1;

                if (count == k) {
                    // remove last k characters
                    j -= (k - 1);
                } else {
                    freqStack.push(count);
                    j++;
                }
            }
        }

        return new String(sChar, 0, j);
    }

}