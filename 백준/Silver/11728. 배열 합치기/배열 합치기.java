import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        size += Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements()) list.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements()) list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);
        for (Integer integer : list) sb.append(integer).append(" ");

        System.out.println(sb);





    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}