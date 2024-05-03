import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();


    /*
    *add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다.
    * */
    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            int number = 0;
            if (st.hasMoreElements()) number = Integer.parseInt(st.nextToken());

            if (method.equals("add")) {
                set.add(number);
            } else if (method.equals("remove")) {
                set.remove(number);
            } else if (method.equals("check")) {
                if (set.contains(number)) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else if (method.equals("toggle")) {
                if(set.contains(number)) set.remove(number);
                else set.add(number);
            } else if (method.equals("all")) {
                set.clear();
                for (int i = 1; i <= 20; i++) set.add(i);
            } else {
                set.clear();
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
