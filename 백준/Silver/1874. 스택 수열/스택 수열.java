import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());

        int[] targetArr = new int[T];
        for (int i = 0; i < T; i++)
            targetArr[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int nextPush = 1;

        for (int num : targetArr) {
            while (num >= nextPush) {
                stack.push(nextPush);
                nextPush++;
                sb.append("+").append("\n");
            }
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
