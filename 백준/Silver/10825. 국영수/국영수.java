import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();

    private static class Student implements Comparable<Student>{
        private String name;
        private int korean;
        private int english;
        private int math;
        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
        @Override
        public int compareTo(Student o) {
            if(o.korean == this.korean){
                if (o.english == this.english) {
                    if (o.math == this.math) {
                        return this.name.compareTo(o.name);
                    }
                    return o.math - this.math;
                }
                return this.english - o.english;
            }
            return o.korean - this.korean;
        }

        @Override
        public String toString() {
            return "name = " + name + " korean = " + korean + " english = " + english + " math = " + math;
        }

        public String getName() {
            return name;
        }
    }

    public void run() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        Student[] students = new Student[testCase];
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(students);
        for (Student student :students) System.out.println(student.getName());
        

    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}