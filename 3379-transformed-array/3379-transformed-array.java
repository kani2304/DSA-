class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(nums[i] > 0){
                arr[i] = nums[(i+nums[i])%nums.length];
            }else if(nums[i] < 0){
                arr[i] = nums[(nums.length + (i+nums[i])%nums.length)%nums.length];
            }else{
                arr[i]=nums[i];
            }
        }
        return arr;
    }
}