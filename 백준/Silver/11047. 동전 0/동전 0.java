import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> coinList = new ArrayList<Integer>();
    private int sum = 0;
    public  void run() throws Exception{
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());

        for (int i=0; i<count; i++){
            int num = Integer.parseInt(br.readLine());
            coinList.add(num);
        }
        Collections.sort(coinList);
        for(int i=coinList.size()-1; i>=0; i--){
            int n = coinList.get(i);
            if(n <= price){
                int coinCount = price / n;
                sum += coinCount;
                price -= coinCount * n;
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}