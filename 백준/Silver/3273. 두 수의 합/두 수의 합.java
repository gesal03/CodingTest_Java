import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private int[] numbers;
    private int X;
    private int size;
    private int count = 0;

    public void run() throws Exception {
        size = Integer.parseInt(br.readLine());
        numbers = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        X = Integer.parseInt(br.readLine());

        int left = 0, right = size - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == X) {
                count++;
                left++;
                right--;
            } else if (sum < X) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
