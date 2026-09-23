class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int target = totalSum - x;
        if(target < 0){
            return -1;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLen = -1;
        while(right < nums.length){
            sum = sum + nums[right];
            while(sum>target && left<=right){
                sum = sum - nums[left];
                left++;
            }
            if(sum == target){
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
        }
        if(maxLen == -1){
            return -1;
        }
        return nums.length-maxLen;
    }
}