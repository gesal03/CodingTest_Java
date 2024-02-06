import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
//    private ArrayList<Integer> list;
    private Iterator<Integer> it;
    private int sum = 0;


    public  void run() throws Exception {
        int n = Integer.parseInt(br.readLine());
        while(true){
            if(n == 1){
                sum = -1;
                break;
            }
            if(n % 5 == 0){
                sum+=n/5;
                break;
            }
            else{
                n -= 2;
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}