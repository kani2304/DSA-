class Solution {
    public boolean sumGame(String nums) {
        int n = nums.length();

        int leftsum = 0, rightsum = 0;
        int leftcount = 0, rightcount = 0;

        for (int i = 0; i < n; i++) {
            if (nums.charAt(i) == '?') {
                if (i < n / 2) {
                    leftcount++;
                } else {
                    rightcount++;
                }
            } else {
                if (i < n / 2) {
                    leftsum += nums.charAt(i) - '0';
                } else {
                    rightsum += nums.charAt(i) - '0';
                }
            }
        }

        if ((rightcount + leftcount) % 2 == 1)
            return true;

        rightsum = 2 * rightsum + rightcount * 9;
        leftsum = 2 * leftsum + leftcount * 9;

        return rightsum != leftsum;
    }
}
