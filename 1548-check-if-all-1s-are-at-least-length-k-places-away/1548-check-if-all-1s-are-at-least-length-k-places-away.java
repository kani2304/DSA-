class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(prev!=-1&&i-k-1<prev){
                    return false;
                }
                prev=i;
            }
        }
        return true;
    }
}