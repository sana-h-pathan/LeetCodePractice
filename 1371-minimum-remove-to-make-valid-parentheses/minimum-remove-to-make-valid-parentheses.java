class Solution {
    public String minRemoveToMakeValid(String s) {
        
        HashSet<Integer> validIndexSet = new HashSet<>();
        int balance = 0;
        int openSeen =0;
        Stack<Integer> st = new Stack<>();
         StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch =='('){
          
                balance++;
                openSeen++;
            }else if(ch == ')'){
                //if close come when there was no open, we will remove it
                if(balance ==0)
                    continue ;
               balance--;
            }
            //so sb will remove all invalid close brackets in this iteration
            sb.append(ch);
            
        }
        StringBuilder res = new StringBuilder();
        int openToKeep = openSeen - balance;
        // we should add only openToKeep number of opens to final res.
        //use sb created in previous iteration
         for(int i = 0; i < sb.length(); i++){
              char ch = sb.charAt(i);
             if(ch =='('){
                 openToKeep--;
                 if(openToKeep <0)
                     continue;
             }
             res.append(ch);
         }
        
        return res.toString();
    }
}