class Solution {
    public int smallestRepunitDivByK(int k) {
        

        // base condition
        if(k%2==0 || k%5==0)
            return -1;
        
        int rem = 1%k, count = 1;

        while(rem!=0) {
            rem = (rem*10+1)%k;
            count++;
        }

        return count;
    }
}