class Solution {
    public int minOperations(int[] nums) {
        int countofOnes = 0; 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                countofOnes++;
            }
        }

        if(countofOnes > 0) {
            return nums.length - countofOnes;
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int gcd = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                gcd = findGCD(gcd, nums[j]);
                if(gcd == 1){
                    result = Math.min(result , j - i);
                }
            }
        }
        if(result == Integer.MAX_VALUE){
            return -1;
        }
        return result + nums.length - 1;
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}