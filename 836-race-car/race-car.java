class Solution {
    public int racecar(int target) {
        Queue<Integer[]> q = new LinkedList<>();
        HashSet<Integer[]> seen = new HashSet<>();
        q.offer(new Integer[]{0,1,0});//pos,speed,moves

        while(!q.isEmpty()){
            Integer[] curr = q.poll();
            int pos = curr[0];
            int speed = curr[1];
            int moves = curr[2];
            if(pos==target){
                return moves;
            }
            if(seen.contains(curr)){
                continue;
            }
            seen.add(curr);
            q.offer(new Integer[]{pos+speed,speed*2,moves+1});
            if((pos+speed > target && speed>0) || (pos+speed < target && speed<0)){
                int newSpeed = speed>0 ? -1 : 1;
                q.offer(new Integer[]{pos,newSpeed,moves+1});
            }
        }

        return -1;
    }
}