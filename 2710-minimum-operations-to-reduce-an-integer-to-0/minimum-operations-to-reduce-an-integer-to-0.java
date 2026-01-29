class Solution {
    public int minOperations(int n) {
        long x = n;        // long avoids overflow on x+1
        int ops = 0;

        while (x != 0) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                if (x == 1) {
                    ops++;
                    break;          // x -= 1 -> 0
                }
                // last two bits via mod 4:
                // x % 4 == 1 => ...01 => subtract 1
                // x % 4 == 3 => ...11 => add 1
                if (x % 4 == 1) x -= 1;
                else x += 1;
                ops++;
            }
        }
        return ops;
    }
}
