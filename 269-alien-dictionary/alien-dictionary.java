class Solution {
    public String alienOrder(String[] words) {
        int n=26;
        HashMap<Character, HashSet<Character>> adjMap=new HashMap<>();
        HashMap<Character,Integer> indegree=new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
            }
        }
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            int w1=0;
            int w2=0;
            while(w1<word1.length() && w2<word2.length()){
                char char1=word1.charAt(w1++);
                char char2=word2.charAt(w2++);
                if(char1!=char2){
                    if(!adjMap.containsKey(char1)){
                        adjMap.put(char1, new HashSet<>());
                    }
                    if(adjMap.get(char1).add(char2)){
                        indegree.put(char2,indegree.getOrDefault(char2,0)+1);
                    }
                    break;
                } 
            }
        }
        Queue<Character> bfsQue=new LinkedList<>();
        for(Character ch: indegree.keySet()){
            if(indegree.get(ch)==0){
                bfsQue.add(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!bfsQue.isEmpty()){
            char curr=bfsQue.poll();
            sb.append(curr);
            //HashSet<Character> set=adjMap.get(curr);
            if(adjMap.containsKey(curr)){
                for(Character ch: adjMap.get(curr)){
                    indegree.put(ch,indegree.getOrDefault(ch,0)-1);
                    if(indegree.get(ch)==0)
                        bfsQue.add(ch);
                }
            }
        }
        if (sb.toString().length() != indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}