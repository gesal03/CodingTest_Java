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
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<count; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int min = 0;
        for(int i=0; i<count-2; i++){
            for(int j=i+1; j<count-1; j++){
                for(int k=j+1; k<count; k++){
                    int sum = list.get(i) + list.get(j) + list.get(k);
                    if( (n-min) > (n-sum) && (n-sum) >= 0) min = sum;
                }
            }
        }
        System.out.println(min);


    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}