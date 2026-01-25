class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for(String query: queries){
            helper(query, pattern, result);
        }
        return result;
    }
    private void helper(String word, String pattern, List<Boolean> result){
        int i=0;
        int j=0;
        while(i<word.length()){
            char ch = word.charAt(i);
            if(j<pattern.length() && ch==pattern.charAt(j)){
                i++;
                j++;
            } else if(Character.isUpperCase(ch)){
                result.add(false);
                return;
            } else {
                i++;
            }
        }
        if(i==word.length() && j==pattern.length())
            result.add(true);
        else
            result.add(false);
    }
}