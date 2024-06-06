class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        Map<Integer, Integer> count = new HashMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        for (int card : hand) {
            if (!count.containsKey(card)) 
                continue;
            for (int i = 0; i < groupSize; i++) {
                int nextCard = card + i;
                if (!count.containsKey(nextCard)) 
                    return false;
                
                int frequency = count.get(nextCard) - 1;
                if (frequency == 0) 
                    count.remove(nextCard);
                else
                    count.put(nextCard, frequency);
            }
        }
        return true;
    }
}