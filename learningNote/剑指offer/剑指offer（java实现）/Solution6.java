
/**
 * @Author liguo
 * @Description 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
1、首先设置标志位result = false，因为一旦匹配成功result就设为true，
剩下的代码不会执行，如果匹配不成功，默认返回false
2、递归思想，如果根节点相同则递归调用baoHan（），
如果根节点不相同，则判断tree1的左子树和tree2是否相同，
再判断右子树和tree2是否相同
3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
baoHan中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功，
tree1为空有两种情况（1）如果tree1为空&&tree2不为空说明不匹配，
（2）如果tree1为空，tree2为空，说明匹配。
 * @Data 2018-08-14 10:47
 */
public class Solution6 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;                                             //定义初始值
        if(root1!=null&&root2!=null){                                       //非空的时候开始判断
            if(root1.val==root2.val)      result = baoHan(root1,root2);      //相等则接着递归
            if(!result)                   result= HasSubtree(root1.left,root2);//左子树递归
            if(!result)                   result= HasSubtree(root1.right,root2);//右子树递归
        }
        return result;
    }
    public static boolean baoHan(TreeNode root1,TreeNode root2){
        if(root2==null)             return true;    //右边先递归完，是子树
        if(root1==null)             return false;
        if(root1.val!=root2.val)    return false;   //不相等，则不是子树
        boolean answer = baoHan(root1.left,root2.left)&&baoHan(root1.right,root2.right);
        return answer;              //继续判断两个树的左子树和右子树；
    }
}