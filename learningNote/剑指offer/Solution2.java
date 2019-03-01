/**
 * @Author liguo
 * @Description 替换空格
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * @思路  转化为字符串数组，循环遍历；
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        String replace = "%20";
        StringBuffer answer = new StringBuffer(  );
        String string = str.toString();
        char[]array = string.toCharArray();
//        for (int i = 0; i < array.length; i++) {
//            if (array[i]==' ')
//                answer.append( replace );
//            else
//                answer.append( array[i] );
//        }
        //利用foreach遍历更加的简单
        for (char i :array) {
            if (i == ' ') answer.append( replace );
            else 
                answer.append( i );
            
        }
        return answer.toString();
    }

}