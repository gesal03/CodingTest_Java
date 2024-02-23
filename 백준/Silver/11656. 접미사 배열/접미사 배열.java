import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> it;

    private StringBuilder sb = new StringBuilder();
    public  void run() throws Exception {
        String str = br.readLine();
        int [][] arr = new int[str.length()][2];
        for(int i=0; i<str.length(); i++){
            arr[i][0] = str.charAt(i);
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    if(str.substring(o1[1]).compareTo(str.substring(o2[1])) < 0) return -1;
                    else return 1;
                }
                return o1[0] - o2[0];
            }
        });

        for(int i=0; i<str.length(); i++){
            sb.append(str.substring(arr[i][1]) + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}