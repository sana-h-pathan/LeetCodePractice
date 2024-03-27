class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxFreq=0;
        int n=s.length();
        for(char ch: s.toCharArray()){
            map.put(ch-'a', map.getOrDefault(ch-'a', 0)+1);
            maxFreq=Integer.max(maxFreq, map.get(ch-'a'));
        }
        for(int key: map.keySet()){
            pq.offer(new int[]{key,map.get(key)});
        }
        if (maxFreq > (n+1)/2)
            return "";
        StringBuilder sb=new StringBuilder();
        while(pq.size()>=2){
            int[] first=pq.poll();
            int[] second=pq.poll();
            sb.append((char) (first[0] + 'a'));
            first[1]--;
            sb.append((char) (second[0] + 'a'));
            second[1]--;
            if(first[1]!=0)
                pq.add(first);
            if(second[1]!=0)
                pq.add(second);
            
        }
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            if(curr[1]>1)
                return "";
            sb.append((char) (curr[0] + 'a'));
        }
        return sb.toString();
       
    }
}