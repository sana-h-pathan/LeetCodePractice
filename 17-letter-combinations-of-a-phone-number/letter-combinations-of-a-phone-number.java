class Solution {
    HashMap<Character, String> map;
    public List<String> letterCombinations(String digits) {
        this.map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        if(digits==null|| digits.length()==0){
            return result;
        }
        backtrack(digits,result, new StringBuilder(), 0);
        return result;
    }
    private void backtrack(String digits, List<String> result, StringBuilder sb, int idx){
        if(idx==digits.length()){
            result.add(sb.toString());
            return;
        }
        char ch = digits.charAt(idx);
        String src = map.get(ch);
        for(int i=0;i<src.length();i++){
            sb.append(src.charAt(i));
            backtrack(digits, result, sb, idx+1);
            sb.setLength(sb.length()-1);
        }
    }
}