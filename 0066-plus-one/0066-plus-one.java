class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int val=carry+digits[i];
            carry=val/10;
            digits[i]=val%10;
            if(carry==0)return digits;
        }
        //if all digits were 9 then
        int[]arr=new int[digits.length+1];
        arr[0]=1;
        return arr;
    }
}