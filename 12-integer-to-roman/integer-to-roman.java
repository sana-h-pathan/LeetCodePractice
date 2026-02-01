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
        for(int i=symbols.length-1;i>=0;i--){
            String[] sym = symbols[i];
            int currNum = Integer.parseInt(sym[1]);
            String currSym = sym[0];
            int count = num/currNum;
            while(count>0){
                sb.append(currSym);
                count--;
            }
            num = num%currNum;
        }
        return sb.toString();
    }
}