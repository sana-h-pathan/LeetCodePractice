class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtracking(answer, new StringBuilder(), 0, 0, n);
        return answer;
    }

    private void backtracking(List<String> answer, StringBuilder curString, int open, int close,int n) {
        if (curString.length() == 2 * n) {
            answer.add(curString.toString());
            return;
        }
        if (open < n) {
            curString.append("(");
            backtracking(answer, curString, open + 1, close, n);
            curString.setLength(curString.length() - 1);
        }
        if (open > close) {
            curString.append(")");
            backtracking(answer, curString, open, close + 1, n);
            curString.setLength(curString.length() - 1);
        }
    }
}