class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stk = new Stack<>();
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                while(!stk.isEmpty() && ch<stk.peek() && map.get(stk.peek())>i){
                    set.remove(stk.pop());
                }
                set.add(ch);
                stk.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: stk){
            sb.append(ch);
        }
        return sb.toString();
    }
}