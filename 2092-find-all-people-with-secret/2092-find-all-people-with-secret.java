class Solution {
    public List<Integer> findAllPeople(int n, int[][] arr, int fp) {        
        int has[]=new int[n];
        Arrays.fill(has, Integer.MAX_VALUE);
        has[0]=0;
        has[fp]=0;
        List<Integer> ans= new ArrayList<>();
        List<List<int[]>> adj= new ArrayList<>();
        for( int i=0;i<n;i++)
          adj.add(new ArrayList<>());
        
        for(int u[]: arr )
        {
          adj.get(u[0]).add(new int[] {u[1], u[2]});
          adj.get(u[1]).add(new int[] {u[0], u[2]});
        }
        for(List<int[]> tmp: adj )
          Collections.sort(tmp, (a,b)->(a[1]-b[1]));
        
        Queue<Integer> q= new LinkedList<>();
        q.offer(fp);
        q.offer(0);
        while(!q.isEmpty())
        {
          int curr=q.poll();
          for(int tmp[]: adj.get(curr))
          {
            int nb= tmp[0];
            int time= tmp[1];
            if(has[nb]> time && has[curr]<=time)
            {
              has[nb]=time;
              q.offer(nb);
            }   
          }
        }
        for( int i=0;i<n;i++)
            if( has[i]!=Integer.MAX_VALUE)
                ans.add(i);

        return ans;       
    }
}