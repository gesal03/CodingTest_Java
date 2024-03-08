import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    boolean [] visited;

    class Node{
        int position;
        int time;

        public Node(int position, int time){
            this.position = position;
            this.time = time;
        }
    }

    public int bfs(int start, int end){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start, 0));
        visited[start] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.position == end) return node.time;

            if((node.position-1) >=0 && (node.position-1) < visited.length &&!visited[node.position-1]){
                visited[node.position-1] = true;
                que.add(new Node(node.position-1, node.time+1));
//                System.out.print("add Node: " + (node.position-1) + ", time: " + (node.time+1));
            }
            if((node.position+1) < visited.length &&!visited[node.position+1]){
                visited[node.position+1] = true;
                que.add(new Node(node.position+1, node.time+1));
//                System.out.print("add Node: " + (node.position+1) + ", time: " + (node.time+1));
            }
            if((node.position*2) < visited.length &&!visited[node.position*2]){
                visited[node.position*2] = true;
                que.add(new Node(node.position*2, node.time+1));
//                System.out.print("add Node: " + (node.position*2) + ", time: " + (node.time+1));
            }

        }


        return 0;
    }


    public  void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int length = (start > end)?start:end;

        visited = new boolean[length+2];

        System.out.println(bfs(start, end));


    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}