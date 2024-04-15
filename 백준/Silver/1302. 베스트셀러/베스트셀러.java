import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private static class Book implements Comparable<Book>{
        private String name;
        private int count;

        public Book(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(Book o) {
            if (o.getCount() == this.getCount()) return this.getName().compareTo(o.getName());
            return o.getCount() - this.getCount();
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }


    public void run() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        Map<String, Book> bookMap = new HashMap<>();
        ArrayList<Book> books = new ArrayList<>();

        for (int i = 0; i < testCase; i++) {
            String bookName = br.readLine();
            if (!bookMap.containsKey(bookName)) {
                Book book = new Book(bookName, 1);
                bookMap.put(bookName, book);
                books.add(book);
            }
            else{
                Book book = bookMap.get(bookName);
                book.setCount(book.getCount()+1);
            }
        }

        Collections.sort(books);
        System.out.println(books.get(0).getName());


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}