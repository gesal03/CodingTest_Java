import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    public void run() throws Exception {
        int N = Integer.parseInt(br.readLine());;

        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int number = Integer.parseInt(st.nextToken());
            if(!list.contains(number)) list.add(number);
        }
        Collections.sort(list);
        for (Integer integer : list) sb.append(integer).append(" ");
        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}