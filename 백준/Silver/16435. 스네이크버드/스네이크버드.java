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
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        sum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++) list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            if(list.get(i) <= sum){
                sum++;
            }
        }
        System.out.println(sum);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}