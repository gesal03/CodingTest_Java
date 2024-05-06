import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            map.put(name, state);
        }
        List<String> list = new ArrayList<>();
        for (String name : map.keySet()) {
            if(map.get(name).equals("enter")) list.add(name);
        }
        Collections.sort(list, Collections.reverseOrder());
        for (String name : list) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
