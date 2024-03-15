import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int H; // 높이
    private int M; // 열
    private int N; // 행

    private int [][][] map;
    private boolean [][][] visited;

    private Queue<Node> que = new LinkedList<>();

    private int [] dirX = {-1, 1, 0, 0, 0, 0};
    private int [] dirY = {0, 0, -1, 1, 0, 0};
    private int [] dirZ = {0, 0, 0, 0, -1, 1};
    class Node{
        int x;
        int y;
        int z;
        int day;
        public Node(int x, int y, int z, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
    private int bfs(){
        int count = 0;
        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i=0; i<6; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                int nowZ = node.z + dirZ[i];
                if(rangeCheck(nowX, nowY, nowZ) && !visited[nowZ][nowX][nowY] && map[nowZ][nowX][nowY] == 0){
                    if(node.day+1 > count) count = node.day+1;
                    que.add(new Node(nowX, nowY, nowZ, node.day+1));
                    visited[nowZ][nowX][nowY] = true;
                }
            }
        }
        return count;
    }

    private boolean rangeCheck(int x, int y, int z){
        return (x>=0 && x<N && y>=0 && y<M && z>=0 && z<H);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<H; k++){
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if(map[k][i][j] == 1) que.add(new Node(i,j,k,0));
                }
            }
        }
        int result = bfs();
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(!visited[i][j][k] && map[i][j][k] == 0) result = -1;
                }
            }
        }
        System.out.println(result);


    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}