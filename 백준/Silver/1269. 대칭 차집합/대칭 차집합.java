import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> newA = new HashSet<>();
        Set<Integer> newB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int setASize = Integer.parseInt(st.nextToken());
        int setBSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < setASize; i++) {
            int n = Integer.parseInt(st.nextToken());
            setA.add(n);
            newA.add(n);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < setBSize; i++) {
            int n = Integer.parseInt(st.nextToken());
            setB.add(n);
            newB.add(n);
        }
        setA.removeAll(newB);

        setB.removeAll(newA);

        setA.addAll(setB);
        System.out.println(setA.size());
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
