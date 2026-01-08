public class Day7_1339_Solution {
    private long maxProduct = 0;
    private long totalSum = 0;
    private final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Get total sum in a single pass while also tracking subtree sums
        totalSum = dfs(root);

        // Reset maxProduct and do second pass for calculation
        maxProduct = 0;
        computeMaxProduct(root);

        return (int) (maxProduct % MOD);
    }

    private long dfs(TreeNode node) {
        if (node == null)
            return 0;
        return node.val + dfs(node.left) + dfs(node.right);
    }

    private long computeMaxProduct(TreeNode node) {
        if (node == null)
            return 0;

        long subtreeSum = node.val +
                computeMaxProduct(node.left) +
                computeMaxProduct(node.right);

        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
