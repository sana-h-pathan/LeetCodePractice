class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int a : asteroids) {
            // Handle collision only when stack top is moving right and current moves left
            while (!stk.isEmpty() && stk.peek() > 0 && a < 0) {
                int top = stk.peek();
                if (Math.abs(top) < Math.abs(a)) {
                    stk.pop();      // top explodes, keep checking
                    continue;
                } 
                else if (Math.abs(top) == Math.abs(a)) {
                    stk.pop();      // both explode
                }
                // In both cases, current asteroid is destroyed
                a = 0;
                break;
            }

            if (a != 0) {
                stk.push(a);
            }
        }

        // Convert stack to array
        int[] result = new int[stk.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stk.pop();
        }
        return result;
    }
}
