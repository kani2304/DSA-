class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,prod=1,x=n;
        while(n>0) {
            int digit=n%10;
            n/=10;
            sum+=digit;
            prod*=digit;
        }
        return x%(sum+prod)==0;
    }
}