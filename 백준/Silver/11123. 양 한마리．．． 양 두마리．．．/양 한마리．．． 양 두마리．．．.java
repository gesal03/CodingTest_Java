import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private boolean [][] visited;
    private int [][] map;
    private int [] dirX = {1, -1, 0, 0};
    private int [] dirY = {0, 0, -1, 1};

    private int M;
    private int N;

    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x= x;
            this.y = y;
        }
    }

    private void bfs(Node node){
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        visited[node.x][node.y] = true;

        while(!que.isEmpty()){
            Node nowNode = que.poll();
            for(int i=0; i<4; i++){
                int nowX = nowNode.x + dirX[i];
                int nowY = nowNode.y + dirY[i];
                if(rangeCheck(nowX, nowY) && !visited[nowX][nowY] && map[nowX][nowY] == 0){
                    que.add(new Node(nowX, nowY));
                    visited[nowX][nowY] = true;
                }
            }
        }
    }

    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<M && y>=0 && y<N);
    }

    public void run() throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for(int k=0; k<testCase; k++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];
            int count = 0;

            for(int i=0; i<M; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    if(str.charAt(j) == '#') map[i][j] = 0;
                    else map[i][j] = 1;
                }
            }
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && map[i][j] == 0){
                        bfs(new Node(i, j));
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}