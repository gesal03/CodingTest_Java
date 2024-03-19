import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int N;
    private int [][] map;
    private boolean [][] visited;
    private int [] dirX = {-1,1,0,0};
    private int [] dirY = {0,0,-1,1};
    private Queue<Node> que;

    class Node implements Comparable<Node>{
        int x;
        int y;
        int index;
        int count;
        public Node(int x, int y, int index, int count){
            this.x=x;
            this.y=y;
            this.index= index;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if(this.count == o.count) return (this.index > o.index ? 1 : -1);
            else return (this.count > o.count ? 1 : -1);
        }
    }
    private void bfs(Node node){
        for(int i=0; i<4; i++){
            int nowX = node.x + dirX[i];
            int nowY = node.y + dirY[i];
            if(rangeCheck(nowX,nowY) && !visited[nowX][nowY] && map[nowX][nowY] == 0){
                que.add(new Node(nowX, nowY, node.index, node.count+1));
                map[nowX][nowY] = node.index;
                visited[nowX][nowY] = true;
            }
        }
    }

    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<N && y>=0 && y<N);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        que = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) que.add(new Node(i, j, map[i][j], 0));
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        for(int i=0; i<S; i++){
            int size = que.size();
            for(int j=0; j<size; j++){
                Node node = que.poll();
                if(node.count == i) bfs(node);
            }
        }
        sb.append(map[targetX-1][targetY-1] + "\n");
        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}