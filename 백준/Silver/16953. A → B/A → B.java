import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> iterator;
    private int sum = 0;

    public  void run() throws Exception{
        st = new StringTokenizer(br.readLine());
        int base = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        while(true){
            if(target == base){
                sum++;
                break;
            }
            else if(target < base){
                sum = -1;
                break;
            }
            if((target % 10) == 1){
                target /= 10;
                sum++;
            }
            else if(target % 2 == 0){
                target /= 2;
                sum++;
            }
            else{
                sum=-1;
                break;
            }
        }
        System.out.println(sum);
    }


    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}