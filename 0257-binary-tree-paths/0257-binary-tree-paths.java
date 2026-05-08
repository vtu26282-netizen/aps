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
    public List<String> binaryTreePaths(TreeNode root) {

        List<String>result=new ArrayList<>();

        dfs(root,"",result);

        return result;
        
    }
    public void dfs(TreeNode root,String path,List<String>result){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            result.add(path+root.val);
            return;
        }

        dfs(root.left,path+root.val+"->",result);
        dfs(root.right,path+root.val+"->",result);
    }
}