class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int count =0;
        int max =0;
        Arrays.sort(intervals , (a,b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for(int i = 0 ; i<n ; i++){
            if(intervals[i][1] > max ){
                max = intervals[i][1];
                count++;
            }
        }
        return count;
    }
}