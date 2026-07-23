class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        int n = candyType.length/2;
        for(int candy: candyType){
            set.add(candy);
        }
        return Math.min(n, set.size());
    }
}