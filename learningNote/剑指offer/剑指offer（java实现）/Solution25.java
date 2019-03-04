
/**
 * @Author liguo
 * @Description 二叉搜索树的后序遍历序列
 * @问题： 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @思路：
1：判断长度极端情况，为零则直接返回false
2：判断为节点小于等于头节点的极端情况；
3：找到中间根节点，大于尾部节点的时候break；
4：直接根据二叉树后序遍历，右子树都大于根节点，小于则直接返回false；再递归左右子树；
 * @Data 2018-09-23 23:52
 */
public class Solution25 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return IsTreeBST(sequence, 0, sequence.length-1);
    }
    public boolean IsTreeBST(int [] sequence,int start,int end ){
        if(end <= start) return true;
        int i = start;
        //找到比根大的坐标；
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        //从根到尾部都应该比尾部的节点大；
        for (int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, end-1);
    }
}