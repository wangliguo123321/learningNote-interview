package ipProblem;

import java.util.Scanner;

/**
 * @Author liguo
 * @Description
 */
public class IpCheck {
    /*
     * 功能: 判断两台计算机IP地址是同一子网络。
     * 输入参数：    String Mask: 子网掩码，格式：“255.255.255.0”；
     *               String ip1: 计算机1的IP地址，格式：“192.168.0.254”；
     *               String ip2: 计算机2的IP地址，格式：“192.168.0.1”；
     *

     * 返回值：      0：IP1与IP2属于同一子网络；     1：IP地址或子网掩码格式非法；    2：IP1与IP2不属于同一子网络
     */
//    public int checkNetSegment(String mask, String ip1, String ip2)
//    {
//        /*在这里实现功能*/
//        return 0;
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String mask = scan.next();
            String ip1 = scan.next();
            String ip2 = scan.next();
            System.out.println(checkNetSegment(mask, ip1, ip2));
        }
        //System.out.println(checkNetSegment(scan.nextLine(), scan.nextLine(), scan.nextLine()));
        //System.out.println(checkNetSegment("255.255.255.0", "192.168.224.256", "192.168.10.4"));
        scan.close();
    }
    public static int checkNetSegment(String mask, String ip1, String ip2) {
        int m = parse(mask);
        int i1 = parse(ip1);
        int i2 = parse(ip2);
        if(m == 0 || i1 == 0 || i2 == 0 || !isLegalMask(m)) {
            return 1;
        }
        if((i1 | m) == (i2 | m)) {
            return 0;
        }
        return 2;
    }
    public static int parse(String str) {
        String[] sa = str.split("\\.");  // String[] sa = str.split("[.]");
        int[] ia = new int[4];
        for(int i = 0; i < 4; i++) {
            if(i < sa.length) {
                ia[i] = Integer.parseInt(sa[i]);
                if(ia[i] > 255)
                    return 0;
            }
            else ia[i] = 0;
        }
        return ia[0] * 256 * 256 * 256 + ia[1] * 256 * 256 + ia[2] * 256 + ia[3];
    }
    public static boolean isLegalMask(int m) {
        String tmp = Integer.toBinaryString(~m + 1);
        boolean find = false;
        for(int i = 0, len = tmp.length(); i < len; i++) {
            if(tmp.charAt(i) == '1') {
                if(find == true)
                    return false;
                else find = true;
            }
        }
        return true;
    }
}