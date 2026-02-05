class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int curNum = 0;
        int defaultVal = Integer.MAX_VALUE;
        char lastSign = '+';
        int result = 0;

        s = s.trim();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + c - '0';
                // handle last number
                if (i == s.length() - 1) {
                    if (lastSign == '+') {
                        st.push(curNum);
                    } else if (lastSign == '-') {
                        st.push(-curNum);
                    }
                }
            } else if (c == '(') {
                if (lastSign == '+') {
                    st.push(1);
                } else if (lastSign == '-') {
                    st.push(-1);
                }
                st.push(defaultVal); // marker for '('
                lastSign = '+';
                curNum = 0;
            } else if (c == ')') {
                if (lastSign == '+') {
                    st.push(curNum);
                } else if (lastSign == '-') {
                    st.push(-curNum);
                }
                int temp = 0;
                while (st.peek() != defaultVal) {
                    temp += st.pop();
                }
                st.pop();              // remove '(' marker
                st.push(temp * st.pop()); // apply +1 / -1 sign
                lastSign = ' ';
                curNum = 0;
            } else if (c == '+' || c == '-') {
                if (lastSign == '+') {
                    st.push(curNum);
                } else if (lastSign == '-') {
                    st.push(-curNum);
                }
                lastSign = c;
                curNum = 0;
            }
        }
        while (!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}
