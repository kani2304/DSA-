class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int count_A=0,count_B=0;
        for(int i=0;i<n;i++) {
            if(s.charAt(i) == 'a') count_A++;
        }
        int ans = count_A;
        for(int i=0;i<n;i++) {
            if(s.charAt(i) == 'a') count_A--;
            else if(s.charAt(i) == 'b') count_B++;
            ans = Math.min(ans, count_A + count_B);
        }
        return ans;
    }
}