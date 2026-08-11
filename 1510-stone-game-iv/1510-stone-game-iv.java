class Solution {
    public boolean winner(int dp[][],int n,boolean turn){
        if(n==0) return !turn;

        boolean ans=false;
        if(turn){
            if(dp[n][0]!=-1) return dp[n][0]==1?true:false;
            for(int i=1;i*i<=n;i++){
                ans|=winner(dp,n-(i*i),!turn);
            }
            dp[n][0]=ans?1:0;
            return ans;
        }
        else{
            if(dp[n][1]!=-1) return dp[n][1]==1?true:false;
            ans=true;
            for(int i=1;i*i<=n;i++){
                ans&=winner(dp,n-(i*i),!turn);
            }
            dp[n][1]=ans?1:0;
            return ans;
        }
    }
    public boolean winnerSquareGame(int n) {
        int dp[][]=new int[n+1][2];
        for(int i=0;i<=n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return winner(dp,n,true);
    }
}