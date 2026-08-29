import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        // Store value and original index
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;

        while (i < n) {
            int j = i;

            // Find a group where consecutive values differ <= limit
            while (j + 1 < n && arr[j + 1][0] - arr[j][0] <= limit) {
                j++;
            }

            List<Integer> indices = new ArrayList<>();

            for (int k = i; k <= j; k++) {
                indices.add(arr[k][1]);
            }

            // Sort original indices
            Collections.sort(indices);

            // Put smallest values at smallest indices
            for (int k = 0; k < indices.size(); k++) {
                nums[indices.get(k)] = arr[i + k][0];
            }

            i = j + 1;
        }

        return nums;
    }
}