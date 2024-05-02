import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    private boolean isBalance(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='(' || ch=='[') stack.push(ch);
            else if (ch == ')') {
                if (stack.empty() || stack.peek() != '(') return false;
                else stack.pop();
            } else if (ch == ']') {
                if(stack.empty() || stack.peek() != '[') return false;
                else stack.pop();
            }
        }
        return stack.empty();
    }

    public void run() throws Exception {
        while (true) {
            String str = br.readLine();
            if(str.equals(".")) break;
            if (isBalance(str)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
