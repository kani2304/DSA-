/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        List<Integer> l = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root,l);
        return buildBBST(l,0,l.size()-1);
    }
    public void inorder(TreeNode root,List<Integer>l){
        if(root==null)return;

        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
    }

    public TreeNode buildBBST(List<Integer>l,int start, int end){
        if(start>end)return null;

        // mid nikalo 
        int mid = (start+end)/2;
        // mid elem ko root bna do
        // mid index h root mai value dalni h -> .get() method use kro index se value nikalne k liye

        TreeNode root= new TreeNode(l.get(mid));
        // left right se rec chala do
        root.left=buildBBST(l,start,mid-1);// ye root k left mai banayga 
        root.right=buildBBST(l,mid+1,end);// ye root k right mai banayga 
        return root;
    }
}