class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        List<int[]> temp = new ArrayList<>();
        for(int[] p: people){
            temp.add(p[1], p);
        }
        int[][] result = new int[temp.size()][2];
        for(int i=0;i<result.length;i++){
            result[i] = temp.get(i);
        }
        return result;
    }
}