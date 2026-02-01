class Solution {
    public String intToRoman(int num) {
        String[][] symbols = new String[][]{
            {"I","1"},
            {"IV","4"},
            {"V","5"},
            {"IX","9"},
            {"X","10"},
            {"XL","40"},
            {"L","50"},
            {"XC","90"},
            {"C","100"},
            {"CD","400"},
            {"D","500"},
            {"CM","900"},
            {"M","1000"}
        };
        StringBuilder sb = new StringBuilder();
        for (int i = symbols.length - 1; i >= 0; i--) {
            int currNum = Integer.parseInt(symbols[i][1]);
            String currSym = symbols[i][0];
            while (num >= currNum) {
                sb.append(currSym);
                num -= currNum;
            }
        }
        return sb.toString();
    }
}