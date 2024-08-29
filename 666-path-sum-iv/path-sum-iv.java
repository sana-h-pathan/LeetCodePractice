class Solution {
    public int pathSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int element : nums) {
            int coordinates = element / 10;
            int value = element % 10;
            map.put(coordinates, value);
        }

        Queue<Pair<Integer, Integer>> bfsQue = new LinkedList<>();
        int totalSum = 0;

        int rootCoordinates = nums[0] / 10;
        bfsQue.add(new Pair<Integer, Integer>(rootCoordinates,map.get(rootCoordinates)));

        while (!bfsQue.isEmpty()) {
            Pair<Integer, Integer> current = bfsQue.poll();
            int coordinates = current.getKey();
            int currentSum = current.getValue();
            int level = coordinates / 10;
            int position = coordinates % 10;

            int left = (level + 1) * 10 + position * 2 - 1;
            int right = (level + 1) * 10 + position * 2;

            if (!map.containsKey(left) && !map.containsKey(right)) {
                totalSum += currentSum;
            }

            if (map.containsKey(left)) {
                bfsQue.add(new Pair<Integer, Integer>(left, currentSum + map.get(left)));
            }

            if (map.containsKey(right)) {
                bfsQue.add(new Pair<Integer, Integer>(right,currentSum + map.get(right)));
            }
        }
        return totalSum;
    }
}