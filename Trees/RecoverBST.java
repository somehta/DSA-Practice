/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

 class BSTExchange{
     TreeNode prev;
     TreeNode n1;
     TreeNode n2;
 }
public class Solution {
    BSTExchange exchangeObject = new BSTExchange();
    public int[] recoverTree(TreeNode A) {
        findViolation(A);

        int[] result = new int[2];

        result[0] = exchangeObject.n1.val;
        result[1] = exchangeObject.n2.val;
        Arrays.sort(result);
        return result;
        
    }

    void findViolation(TreeNode root){
        if(root == null){
            return;
        }

        findViolation(root.left);

        if(exchangeObject.prev != null){
            if(exchangeObject.prev.val > root.val){
                if(exchangeObject.n1 == null){
                    exchangeObject.n1 = exchangeObject.prev;
                    exchangeObject.n2 = root;
                }else{
                    exchangeObject.n2 = root;
                }
            }
        }

        exchangeObject.prev = root;

        findViolation(root.right);
    }
}
