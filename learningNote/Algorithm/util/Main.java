import java.util.Scanner;

/**
 * @Author liguo
 * @Description
 */
public class Main {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            long  n = in.nextInt();
            long m= in.nextInt() ;
            long answer= 0;
            if(n==0&&m==0)        answer = 0;

            else if(n>=m)        answer =1 ;
            else if (m >n)        answer =m%n+1;
            System.out.println(answer);
    }
}