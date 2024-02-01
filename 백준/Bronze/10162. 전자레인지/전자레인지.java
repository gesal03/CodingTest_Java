import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> it;
//    private int sum = 0;

    public  void run() throws Exception {
        list.add(300);list.add(60);list.add(10);
        int n = Integer.parseInt(br.readLine());
        it = list.iterator();
        String sum = "";
        while(it.hasNext()) {
            int time = it.next();
            int size = n / time;
//            System.out.println("size " + size);
//            System.out.print(size + " ");
            sum += size + " ";
            if (size != 0) {
                n -= size * time;
            }
        }
        if(n != 0)
            sum = "-1";
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}