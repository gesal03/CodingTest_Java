import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();


    public void run() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String str = br.readLine();
            if(str.length() >=6 && str.length() <= 9) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);


    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}