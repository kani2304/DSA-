class Solution {
    public class Segment{
        int n;
        int k;
        Node []seg;
        public Segment(int n,int k,int []nums){
           this.n=nums.length;
           this.k=k;
           seg=new Node[4*n+1];
            build(0,n-1,nums,0);
        }
        public class Node{
            int[]cnt;
            long product;
            Node(){
                this.cnt=new int[5];
                this.product=1;
            }
        }
        public void build(int l,int r,int []nums,int i){
            if(l==r){
                Node nn=new Node();
                int val=nums[l]%k;
                nn.cnt[val]=1;
                nn.product=val;
                seg[i]=nn;
                return ;
            }
            int mid=l+(r-l)/2;
            build(l,mid,nums,2*i+1);
            build(mid+1,r,nums,2*i+2);
            seg[i]=merge(seg[2*i+1],seg[2*i+2]);
        }
        public void update(int idx,int val){
            update(0,n-1, idx, val,0);
        }
        private void update(int l,int r,int idx,int val,int i){
            if(l==r){
                Node nn=new Node();
                val%=k;
                nn.product=val;
                nn.cnt[val]=1;
                seg[i]=nn;
                return;
            }
            int mid=l+(r-l)/2;
            if(idx<=mid)
            update(l,mid,idx,val,2*i+1);
            else
            update(mid+1,r,idx,val,2*i+2);
            seg[i]=merge(seg[2*i+1],seg[2*i+2]);
        }
        public Node query(int l,int r,int s,int e,int i){
            if(e<l||r<s){
                return null;
            }
            if(s<=l&&r<=e){
                return seg[i];
            }
            int mid=l+(r-l)/2;
            Node left=query(l,mid,s,e,2*i+1);
            Node right=query(mid+1,r,s,e,2*i+2);
            return merge(left,right);
        }
        public Node merge(Node left,Node right){
            if(left==null){
                return right;
            }
            if(right==null){
                return left;
            }
            Node ans=new Node();
            for(int i=0;i<k;i++){
                ans.cnt[i]+=left.cnt[i];
            }
            for(int i=0;i<k;i++){
                int nr=(int)((left.product*i)%k);
                ans.cnt[nr]+=right.cnt[i];
            }
            ans.product=(left.product*right.product)%k;
            return ans;
        }
    }
    public int[] resultArray(int[] nums, int k, int[][] queries) {
           int n = nums.length;

        Segment st = new Segment(n, k, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];
             st.update(index, value);
             Segment.Node res = st.query(0, n - 1, start, n - 1, 0);

            ans[q] = res.cnt[x];
            
    }
    return ans;
}
}