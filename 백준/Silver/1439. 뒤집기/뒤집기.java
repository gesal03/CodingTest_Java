import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> it;
    private int sum = 0;
    private int odd = 0;
    private int even = 0;
    private boolean isFirst = true;

    private int current;

    public  void run() throws Exception {
        String num = br.readLine();
        current = Integer.parseInt(String.valueOf(num.charAt(0)));
        for(int i=0; i<num.length(); i++) {
            int n = Integer.parseInt(String.valueOf(num.charAt(i)));
            if (current != n) {
                isFirst = true;
                current = n;
            }
            if (n == 0 && isFirst == true) {
                isFirst = false;
                even++;
            } else if (n == 1 && isFirst == true) {
                isFirst = false;
                odd++;
            }
        }
        sum = (even > odd) ? odd:even;
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}