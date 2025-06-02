import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);

        int rob = root.val;
        if (root.left != null) {
            rob += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            rob += rob(root.right.left) + rob(root.right.right);
        }

        int notRob = rob(root.left) + rob(root.right);

        int result = Math.max(rob, notRob);
        memo.put(root, result); 
        return result;
    }
}
