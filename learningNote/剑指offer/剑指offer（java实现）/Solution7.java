
/**
 * @Author liguo
 * @Description 二叉树的镜像
 * @问题：操作给定的二叉树，将其变换为源二叉树的镜像。
 * @思路：采用递归的方法，
 *  1：空二叉树直接return；定义节点temp；
 * 2：判断节点为非空；借助temp执行根节点左右值的交换；
 * 3: 判断根节点的左右节点非空，对节点进行递归；
 * @Data 2018-08-14 12:40
 */
public class Solution7 {
    public void Mirror(TreeNode root) {
        TreeNode temp;
        if (root == null) return;           //空二叉树直接return；
        if (root != null) {                  //断节点为非空；借助temp执行根节点左右值的交换；
            temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        //判断根节点的左右节点非空，对节点进行递归；
        if (root.left != null) Mirror( root.left );
        if (root.right != null) Mirror( root.right );
    }
}