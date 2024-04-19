import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    public void run() throws Exception {
        int size = Integer.parseInt(br.readLine());
        int[] numbers = new int[size];
        int[] sortedNumbers = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
            sortedNumbers[i] = numbers[i];
        }
        Arrays.sort(sortedNumbers);
        Map<Integer, Integer> numberMap = new HashMap<>();

        int rank = 0;
        for (int i = 0; i < size; i++) {
            if(!numberMap.containsKey(sortedNumbers[i])){
                numberMap.put(sortedNumbers[i], rank);
                rank++;
            }
        }
        for (int i = 0; i < size; i++) {
            sb.append(numberMap.get(numbers[i])).append(" ");
        }
        System.out.println(sb);



    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}