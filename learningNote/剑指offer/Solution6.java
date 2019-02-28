import sun.applet.Main;

import java.util.Scanner;

/**
 * @Author liguo
 * @Description 旋转数组的最小数字
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution6 {

    public static void answer( ){
        Scanner in =  new Scanner( System.in);
//        System.out.println("------");
        int  answer;
        Double x = in.nextDouble();
        Double f = in.nextDouble();
        Double d = in.nextDouble();
        Double p = in.nextDouble();
        if(d/x<1) answer = 0;   //d<x
        if(d/x==1) answer = 1;   //d=x
        if (d/x<=f)  answer= (int )Math.floor(d/x); // d>x ,不买水果
        else
            answer=(int) Math.floor( (d+f*p)/(p+x) );
        System.out.println(answer);

    }

    public static void main(String[] args) {
            Solution6 a = new Solution6();
            a.answer();
    }

}