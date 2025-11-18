class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
       int i = 0;
       if(n==1){
        return true;
       }
        while(i<=n-1){
            if(bits[i]==0){
                if(i==n-1){
                return true;
               }
                i+=1;
            }
            else{
               i+=2;
               
            }
        }
        return false;
    }
}