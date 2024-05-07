import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private int count = 0;

    private void isRight(String str) {
        if(str.length() % 2 != 0) return;
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == str.charAt(i)) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }
        if(stack.isEmpty()) count++;
    }

    public void run() throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();
            isRight(str);
        }
        System.out.println(count);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
