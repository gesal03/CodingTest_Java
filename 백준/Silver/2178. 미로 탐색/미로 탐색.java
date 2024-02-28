import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.sql.Array;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private StringBuilder sb = new StringBuilder();

    private int N; // 세로의 길이
    private int M; // 가로의 길이
    private int [][] map;
    private boolean [][] visited;
    int [] dirX = {0,0,-1,1};
    int [] dirY = {-1,1,0,0};
    class Node{
        int x;
        int y;
        int count;
        Node(int x, int y, int count) {
            this.x=x;
            this.y=y;
            this.count=count;
        }

        @Override
        public String toString() {
            return "Current Node X: " + x + ", Y:  " + y + ", count: " +count;
        }
    }

    private int bfs(int x, int y, int count){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x,y, count));
        visited[x][y] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.x == N-1 && node.y==M-1)
                return node.count;
            for(int i=0; i<4; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX, nowY) && visited[nowX][nowY]==false && map[nowX][nowY] == 1){
                    que.add(new Node(nowX, nowY, node.count + 1));
                    visited[nowX][nowY] = true;
                }
            }
        }
        return 0;
    }

    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<N && y>=0 && y<M);
    }

    public  void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로의 길이
        M = Integer.parseInt(st.nextToken()); // 가로의 길이
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                visited[i][j] = false;
            }
        }
        sb.append(bfs(0,0,1));
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}