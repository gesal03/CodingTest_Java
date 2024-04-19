import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private static class Number implements Comparable<Number>{
        private int number;
        private int count;

        public Number(int number, int count) {
            this.number = number;
            this.count = count;
        }
        public int getNumber() {
            return number;
        }
        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
        @Override
        public int compareTo(Number o) {
            if(o.count == this.count) return this.number - o.number;
            return o.count - this.count;
        }
    }
    public void run() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        Map<Integer, Number> numberMap = new HashMap<>();
        List<Number> numberList = new ArrayList<>();

        int[] numbers = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            if (!numberMap.containsKey(numbers[i])) {
                Number number = new Number(numbers[i], 1);
                numberMap.put(numbers[i], number);
                numberList.add(number);

            } else {
                Number number = numberMap.get(numbers[i]);
                number.setCount(number.getCount()+1);
            }
        }

        // 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
        // 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
        double sum = 0;
        for (int value : numbers) sum += value;
        sb.append(Math.round(sum / testCase)).append("\n");

        // 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        Arrays.sort(numbers);
        sb.append(numbers[testCase / 2]).append("\n");

        // 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
        // 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
        Collections.sort(numberList);
        int target = numberList.get(0).getCount();
        Number num = numberList.get(0);
        int count = 0;
        for (Number n : numberList) {
            if(n.getCount() == target) count+=1;
            if(count == 2){
                num = n;
                break;
            }
        }
        sb.append(num.getNumber()).append("\n");

        // 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
        sb.append(numbers[numbers.length - 1] - numbers[0]).append("\n");

        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}