import java.io.BufferedReader;
import java.io.IOError;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    private class Student implements Comparable<Student>{
        private String name;
        private int year;
        private int month;
        private int day;

        public Student(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student o) {
            if(this.year == o.year) return this.month - o.month;
            else if(this.month == o.month) return this.day - o.day;
            return this.year - o.year;
        }
    }

    public void run() throws Exception {
        int N = Integer.parseInt(br.readLine());
        LinkedList<Student> students = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            Student student = new Student(name, year, month, day);
            students.add(student);
        }
        Collections.sort(students);
        sb.append(students.getLast().getName()).append("\n");
        sb.append(students.getFirst().getName()).append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
