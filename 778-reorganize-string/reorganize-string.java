class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int maxFreq=0;
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxFreq=map.get(ch);
        }
        if(maxFreq>(s.length()+1)/2)
            return "";
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char ch: map.keySet())
            pq.add(ch);
        StringBuilder sb=new StringBuilder();
        while(pq.size()>1){
            char fChar=pq.poll();
            char sChar=pq.poll();
            sb.append(fChar).append(sChar);
            map.put(fChar, map.getOrDefault(fChar, 0)-1);
            if(map.get(fChar)<=0)
                map.remove(fChar);
            else
                pq.add(fChar);
            map.put(sChar, map.getOrDefault(sChar, 0)-1);
            if(map.get(sChar)<=0)
                map.remove(sChar);
            else
                pq.add(sChar);
        }
        while(pq.size()>0){
            char ch=pq.poll();
            if(map.get(ch)>1)
                return "";
            sb.append(ch);
        }
        return sb.toString();
    }

}