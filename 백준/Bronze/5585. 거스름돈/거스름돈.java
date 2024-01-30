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
        int price = 1000 - Integer.parseInt(br.readLine());
        coinList.add(500);coinList.add(100);coinList.add(50);coinList.add(10);coinList.add(5);coinList.add(1);
        int i=0;
        while(price > 0){
            int n = coinList.get(i);
            int coinCount = price / n;
            sum += coinCount;
            price -= n*coinCount;
            i++;
        }
        System.out.println(sum);
    }


    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}