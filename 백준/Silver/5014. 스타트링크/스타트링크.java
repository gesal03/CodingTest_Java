import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private boolean [] visited;
    private int F;
    class Node{
        int index;
        int count;
        public Node(int index, int count){
            this.index = index;
            this.count = count;
        }
    }
    private int bfs(int S, int G, int U, int D){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(S, 0));
        visited[S] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.index == G) return node.count;
            int upNode = node.index + U;
            int downNode = node.index - D;
            if(rangeCheck(upNode) && !visited[upNode]){
                que.add(new Node(upNode, node.count+1));
                visited[upNode] = true;
            }
            if(rangeCheck(downNode) && !visited[downNode]){
                que.add(new Node(downNode, node.count+1));
                visited[downNode]  =true;
            }
        }
        return -1;
    }
    private boolean rangeCheck(int index){
        return (index > 0 && index <= F);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        visited = new boolean[F+1];
        int result = bfs(S, G, U, D);
        if(result == -1) sb.append("use the stairs");
        else sb.append(result);
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}