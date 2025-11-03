class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0;
        int maxx = neededTime[0];
        int sum = neededTime[0];
        for(int i=1;i<colors.length();i++) {
            if(colors.charAt(i) == colors.charAt(i-1)) {
                sum += neededTime[i];
                maxx = Math.max(maxx,neededTime[i]);
            } else {
                ans += (sum - maxx);
                sum = neededTime[i];
                maxx = neededTime[i];
            }
        }
        ans += (sum - maxx);
        return ans;
    }
}