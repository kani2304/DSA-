class Solution {
    public int missingMultiple(int[] nums, int k) {
        int[] arr = new int[101];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k==0){
                arr[nums[i]]=1;
            }
        }
        int i=0;
        while(k*(i+1)<=100){
            if(arr[k*(i+1)]==0)
                return k*(i+1);
            i++;
        }
        return k*(i+1);
    }
}