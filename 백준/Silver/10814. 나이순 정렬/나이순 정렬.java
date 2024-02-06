import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Iterator<Integer> it;
    private int sum = 0;

    class Person{
        int age;
        String name;

        Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }


    public  void run() throws Exception {
        int count = Integer.parseInt(br.readLine());
        Person [] p = new Person[count];
        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        for(int i=0; i<p.length; i++) System.out.print(p[i]);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}