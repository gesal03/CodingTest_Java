import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    private Iterator<String> it;
    private StringBuilder sb = new StringBuilder();
    private int sum = 0;


    public  void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int index = 1;

        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            int n = Integer.parseInt(br.readLine());
            while(true){
                if(n >= index && n < (index+M)) break;
                else if(n < index){
                    sum++;
                    index--;
                }
                else if(n >= (index + M)){
                    sum++;
                    index++;
                }
            }
        }
        System.out.println(sum);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}