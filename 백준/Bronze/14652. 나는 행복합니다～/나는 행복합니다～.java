import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    class Node{
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Node checkSheat(int K) {
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(index == K) return new Node(i, j);
                index++;
            }
        }
        return new Node(0,0);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node node = checkSheat(K);
        System.out.println(node.x + " " + node.y);


    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

