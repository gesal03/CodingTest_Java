import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        int i=0;
        int j = N-1;

        while (i < j) {
            if (arr[i] + arr[j] < M) {
                i++;
            } else if (arr[i] + arr[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

