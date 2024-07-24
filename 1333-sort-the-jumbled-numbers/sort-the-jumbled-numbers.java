class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer[]> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int original = nums[i];
            int mappedNumber = getMappedNumber(mapping, original);
            list.add(new Integer[]{mappedNumber, i});
        }

        list.sort((a, b) -> a[0].compareTo(b[0]));

        int[] result = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = nums[list.get(i)[1]];
        }

        return result;
    }

    private int getMappedNumber(int[] mapping, int num) {
        StringBuilder mappedStr = new StringBuilder();
        String numStr = String.valueOf(num);

        for (char c : numStr.toCharArray()) {
            mappedStr.append(mapping[c - '0']);
        }

        return Integer.parseInt(mappedStr.toString());
    }
}