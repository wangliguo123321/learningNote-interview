/**
 * @Author liguo
 * @Description 平衡二叉树
 * @问题： 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 * @思路： 改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
 * 如果发现子树不是平衡二叉树，则直接停止遍历
 * 1：
 * @Data 2018-08-17 15:53
 */
public class Solution16 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}