
/**
 * @Author liguo
 * @Description 翻转单词顺序列
 * @问题： 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @思路：
 * 1：首先将string 转化为字符串数组；利用函数split（“ ”）
 * 2：直接通过转化后，新建StringBuder,从后往前连接各个字符串
 * @Data 2018-08-18 10:21
 */
public class Solution17 {
    public String ReverseSentence(String str) {
        if(str == null){ return null;}
        if(str.trim().equals("")){
            return str;
        }
        String string = str;
        String[] strings = string.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = strings.length-1 ; i>=0;i--) {
            if(i == 0){
                sBuilder.append(strings[i]);
            }else {
                sBuilder.append(strings[i]);
                sBuilder.append(" ");
            }
        }
        String string2 = sBuilder.toString();
        return string2;
    }
}