package ipProblem;
import java.io.*;
/**
 * @Author liguo
 * @Description
 */
public class IpTransfer {




    public static void Change1(String str) {
        String[] data1 = str.split("\\.");

        data1[0] = Integer.toBinaryString(Integer.parseInt(data1[0]));
        data1[1] = Integer.toBinaryString(Integer.parseInt(data1[1]));
        data1[2] = Integer.toBinaryString(Integer.parseInt(data1[2]));
        data1[3] = Integer.toBinaryString(Integer.parseInt(data1[3]));

        while(data1[0].length()<8) data1[0] = "0"+data1[0];
        while(data1[1].length()<8) data1[1] = "0"+data1[1];
        while(data1[2].length()<8) data1[2] = "0"+data1[2];
        while(data1[3].length()<8) data1[3] = "0"+data1[3];


        long sum = 0;
        for(int i=0;i<data1.length;i++) {
            for(int j=0;j<data1[0].length();j++) {
                sum = sum*2+(data1[i].charAt(j)-'0');
            }
        }
        System.out.println(sum);

    }
    public static void Change2(String str) {
        long data2 = Long.parseLong(str);
        String bindata2 = Long.toBinaryString(data2);
        String[] data = new String[4];
        data[0] = bindata2.substring(0,bindata2.length()-3*8);
        data[1] = bindata2.substring(data[0].length(),data[0].length()+8);
        data[2] = bindata2.substring(data[0].length()+data[1].length(),data[0].length()+data[1].length()+8);
        data[3] = bindata2.substring(bindata2.length()-8,bindata2.length());

        System.out.print(Integer.valueOf(data[0],2)+".");
        System.out.print(Integer.valueOf(data[1],2)+".");
        System.out.print(Integer.valueOf(data[2],2)+".");
        System.out.println(Integer.valueOf(data[3],2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while((str=br.readLine())!=null) {
            Change1(str);
            str=br.readLine();
            Change2(str);
        }
    }
}