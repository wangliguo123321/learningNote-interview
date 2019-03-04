
/**
 @Author liguo
 @Description 重建二叉树
 @问题： 题目描述
 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 @思路：
一: 采用尾递归了，根据函数左子树，右子树来进行计算；
        1：判断极端情况，前序中序长度不同，或者都为零
        2：构造根节点的二叉树，找到根节点的i值，然后再根据根节点找到中序遍历的i值
        3：构建数组 ，分别储存相应的值；
        int[] preLeft   int[] inLeft =      int[] preRight      int[] inRight
        4:对构造的数组分别进行赋值，位于根节点i左边的赋值pre加一赋值给PreLeft，根节点右边的赋值。
二: 采用类似尾递的方法，通过直接尾递归的方法，更加的简洁,但是尾递归中startPre，endPre,startIn,endIn.bu容易理解；　
 * @Data 2018-09-23 21:29
 */

public class Solution23 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int i = 0;
        if (pre.length != in.length || pre.length == 0 | in.length == 0)
            return null;
        TreeNode root = new TreeNode( pre[0] );
        while (in[i] != root.val)
            i++;
        int[] preLeft = new int[i];
        int[] inLeft = new int[i];
        int[] preRight = new int[pre.length - i - 1];
        int[] inRight = new int[in.length - i - 1];
        for (int j = 0; j < in.length; j++) {
            if (j < i) {
                preLeft[j] = pre[j + 1];
                inLeft[j] = in[j];
            } else if (j > i) {
                preRight[j - i - 1] = pre[j];
                inRight[j - i - 1] = in[j];
            }
        }
        root.left = reConstructBinaryTree( preLeft, inLeft );
        root.right = reConstructBinaryTree( preRight, inRight );
        return root;
    }
}

/**
 @Author liguo
 @Description 重建二叉树
 @问题： 题目描述
 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 @思路：
 一: 采用尾递归了，根据函数左子树，右子树来进行计算；
 1：判断极端情况，前序中序长度不同，或者都为零
 2：构造根节点的二叉树，找到根节点的i值，然后再根据根节点找到中序遍历的i值
 3：构建数组 ，分别储存相应的值；
 int[] preLeft   int[] inLeft =      int[] preRight      int[] inRight
 4:对构造的数组分别进行赋值，位于根节点i左边的赋值pre加一赋值给PreLeft，根节点右边的赋值。
 二: 采用类似尾递的方法，通过直接尾递归的方法，更加的简洁,但是尾递归中startPre，endPre,startIn,endIn.bu容易理解；　
  * @Data 2018-09-23 21:29
 */

 class Solution２４{
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }
}
