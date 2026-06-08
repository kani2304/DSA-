class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            int element = nums[i];

            if (element < pivot) {
                res[left++] = element;
            } else if (element > pivot) {
                res[right--] = element;
            }
        }

        // reverse the > pivot portion
        int start = right + 1;
        int end = n - 1;

        while (start < end) {
            int temp = res[start];
            res[start] = res[end];
            res[end] = temp;
            end--;
            start++;
        }

        // fill pivot values
        while (left <= right) {
            res[left++] = pivot;
        }

        return res;
    }
}