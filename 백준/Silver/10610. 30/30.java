import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> it;
    private int sum = 0;


    public  void run() throws Exception {
        String num = br.readLine();
        for(int i=0; i<num.length(); i++){
            int n = Integer.parseInt(String.valueOf(num.charAt(i)));
            sum+=n;
            list.add(n);
        }
        Collections.sort(list);
        if(list.contains(0) && sum % 3 == 0){
            for(int i=list.size()-1; i>=0; i--)
                System.out.print(list.get(i));
        }
        else
            System.out.print("-1");
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}