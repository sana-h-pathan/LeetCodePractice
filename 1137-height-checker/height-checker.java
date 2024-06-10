class Solution {
    public int heightChecker(int[] h) {
        int[] temp = new int[h.length];
        for(int i=0;i<h.length;i++){
            temp[i]=h[i];
        }
        Arrays.sort(temp);
        
        int res = 0;
        int i=0;
        int j=0;
        while(i<h.length && j<temp.length){
            if(h[i]!=temp[j])
                res++;
            i++;
            j++;
        }
        return res;
    }
}