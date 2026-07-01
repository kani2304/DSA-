class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        Queue<int[]>q=new LinkedList<>();
        int[][]mat=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    mat[i][j]=0;
                    q.offer(new int[]{i,j});
                }
                else mat[i][j]=-1;
            }
        }
        int[][]dirs={{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int i=arr[0],j=arr[1];
            for(int[]dir:dirs){
                int r=i + dir[0];
                int c=j + dir[1];
                if(r >= 0 && r < n && c >= 0 && c < n && mat[r][c] == -1){
                    mat[r][c]=mat[i][j]+1;
                    q.offer(new int[]{r,c});
                }
            }
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>(
            (a,b)->Integer.compare(b[0],a[0])
        );
        boolean[][]vis=new boolean[n][n];
        pq.offer(new int[]{mat[0][0],0,0});
        while(!pq.isEmpty()){
            int[]arr=pq.poll();
            int safe=arr[0],i=arr[1],j=arr[2];
            if(i == n-1 && j == n-1) return safe;
            if(vis[i][j]) continue;
            vis[i][j]=true;
            for(int[]dir:dirs){
                int r=i+dir[0],c=j+dir[1];
                if(r >= 0 && r < n && c >= 0 && c < n){
                    int newSafe=Math.min(safe,mat[r][c]);
                    pq.offer(new int[]{newSafe,r,c});
                }
            }
        }
        return -1;
    }
}