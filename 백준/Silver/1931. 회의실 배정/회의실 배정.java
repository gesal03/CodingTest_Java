import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> it;

    private HashMap<Integer, Integer> map = new HashMap<>();
    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        int [][] arr = new int[count][2];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        int sum = 0;
        int preEndTime = 0;

        for(int i=0; i<count; i++){
            if(preEndTime <= arr[i][0]){
                preEndTime = arr[i][1];
                sum++;
            }
        }


        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}