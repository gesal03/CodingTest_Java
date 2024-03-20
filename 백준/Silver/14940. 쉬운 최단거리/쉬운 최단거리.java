import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int [][] map;
    private boolean [][] visited;
    private Queue<Node> que;
    private int [] dirX = {-1,1,0,0};
    private int [] dirY = {0,0,-1,1};
    private int N;
    private int M;
    class Node{
        int x;
        int y;
        int count;
        public Node(int x, int y, int count){
            this.x= x;
            this.y=y;
            this.count =count;
        }
    }
    private void bfs(){
        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i=0; i<4; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX, nowY) && !visited[nowX][nowY] && map[nowX][nowY] == 1){
                    que.add(new Node(nowX, nowY, node.count+1));
                    visited[nowX][nowY] = true;
                    map[nowX][nowY] = node.count+1;
                }
            }
        }
    }
    private boolean rangeCheck(int x, int y){
        return (x>=0 && x< N && y>=0 && y<M);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        que = new LinkedList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    que.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    map[i][j] = 0;
                }
            }
        }

        bfs();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && map[i][j] == 1) sb.append("-1 ");
                else sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}