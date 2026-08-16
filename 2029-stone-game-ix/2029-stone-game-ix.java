class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        // Alice has no way to start with remainder 1 or 2.
        if (count[1] == 0 && count[2] == 0) {
            return false;
        }

        // If number of remainder-0 stones is even
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        // If number of remainder-0 stones is odd
        return Math.abs(count[1] - count[2]) > 2;

    
    }
}