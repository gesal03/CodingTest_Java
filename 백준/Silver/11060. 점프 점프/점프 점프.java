import java.io.BufferedReader;
import java.io.IOError;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Struct;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int N;
    private int count;
    private int [] map;
    private boolean [] visited;
    private class Node{
        int x;
        int count;
        public Node(int x, int count){
            this.x=x;
            this.count=count;
        }

        @Override
        public String toString() {
            return this.x + ": " + this.count;
        }
    }
    private void bfs(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        visited[0] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.x == N-1 && node.count < count ) count = node.count;
            int jump = map[node.x];
            for(int i=1; i<=jump; i++){
                int nowX = node.x + i;
                if(nowX<N && !visited[nowX]){
                    Node nowNode = new Node(nowX, node.count+1);
                    que.add(nowNode);
                    visited[nowX]=true;
                }
            }
        }
    }


    public void run() throws Exception {
        N = Integer.parseInt(br.readLine());
        count = N+1;
        map = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) map[i] = Integer.parseInt(st.nextToken());

        bfs();
        if(count < N+1) sb.append(count);
        else sb.append("-1");
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}