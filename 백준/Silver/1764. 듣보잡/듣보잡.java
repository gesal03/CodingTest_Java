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

        Map<String, Integer> mp = new HashMap<>();
        // 들어보지 못한 놈
        for(int i=0; i<N; i++) mp.put(br.readLine(), 1);

        for(int i=0; i<M; i++){
            String input = br.readLine();
            if(mp.keySet().contains(input)) mp.put(input, 2);
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : mp.entrySet()){
            if(entry.getValue() == 2) ans.add(entry.getKey());
        }
        sb.append(ans.size() + "\n");
        Collections.sort(ans);
        it = ans.iterator();
        while(it.hasNext()) sb.append(it.next() + "\n");

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}