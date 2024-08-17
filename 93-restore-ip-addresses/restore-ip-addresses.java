class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<>();
         if(s.length()>12)
            return result;
        backtrack(s,0,0,result,new StringBuilder());
        return result;
    }

    private void backtrack(String s, int idx, int dots, List<String> result, StringBuilder currStr){
        if(dots==4 && idx==s.length()){
            result.add(currStr.toString().replaceAll(".$", ""));
            return;
        }
        if(dots>4)
            return;
        for(int i=idx;i<idx+3 && i<s.length();i++){
            String str=s.substring(idx,i+1);
            if((Integer.parseInt(str)<256)&&(i==idx || s.charAt(idx)!='0')){
                currStr.append(str).append(".");
                backtrack(s, i+1, dots+1, result, currStr);
                currStr.setLength(currStr.length()-str.length()-1);
            }
        }
    }
}