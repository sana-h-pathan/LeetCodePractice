class Solution {
    public String reorganizeString(String s) {
        HashMap<Integer, Integer> map=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int maxFrequency=0;
        int n=s.length();
        for(char ch: s.toCharArray()){
            int temp=ch-'a';
            map.put(temp, map.getOrDefault(temp, 0)+1);
            maxFrequency=Math.max(maxFrequency,map.get(temp));
        }
        if(maxFrequency>(n+1)/2)
            return "";
        for(int key: map.keySet()){
            pq.offer(new int[]{key, map.get(key)});
        }
        StringBuilder sb=new StringBuilder();
        while(pq.size()>=2){
            int[] first=pq.poll();
            int[] second=pq.poll();
            sb.append((char) (first[0] + 'a'));
            sb.append((char) (second[0] + 'a'));
            first[1]--;
            if(first[1]>0)
                pq.add(first);
            second[1]--;
            if(second[1]>0)
                pq.add(second);
        }
        while(!pq.isEmpty()){
            int [] curr=pq.poll();
            if(curr[1]>1)
                return "";
            sb.append((char) (curr[0] + 'a'));
        }
        return sb.toString();
        
    }
}