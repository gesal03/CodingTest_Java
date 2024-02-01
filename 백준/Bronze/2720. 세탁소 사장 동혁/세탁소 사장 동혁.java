import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> it;
    private long sum = 0;

    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        list.add(25);list.add(10);list.add(5);list.add(1);
        for(int i=0; i<count;i++){
            int n = Integer.parseInt(br.readLine());
            it = list.iterator();
//            System.out.println(n);
            while(it.hasNext()){
                int coin = it.next();
                int size = n / coin;
                System.out.print(size + " ");
                n -= size*coin;
            }
            System.out.println();
        }
//        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}