class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) q.offer(i);
        int ans[] = new int[deck.length];
        for(int i = 0;i < n; i++){
            ans[q.poll()] = deck[i];
            q.offer(q.poll());
        }
        return ans;
    }
}