import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private int L;
    private int N;
    private int M;
    private int [][][] map;
    private boolean [][][] visited;
    private int [] dirX = {0,0,-1,1,0,0};
    private int [] dirY = {-1,1,0,0,0,0};
    private int [] dirZ = {0,0,0,0,-1,1};

    private Queue<Node> que;

    class Node{
        int x;
        int y;
        int z;
        int time;
        public Node(int x, int y, int z, int time){
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }
    private int bfs(){
        while(!que.isEmpty()){
            Node node = que.poll();
            if(map[node.z][node.x][node.y] == 3) return node.time;
            for(int i=0; i<6; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                int nowZ = node.z + dirZ[i];
                if(rangeCheck(nowX, nowY, nowZ) && !visited[nowZ][nowX][nowY] && map[nowZ][nowX][nowY] != 1){
                    que.add(new Node(nowX, nowY, nowZ, node.time+1));
                    visited[nowZ][nowX][nowY] = true;
                }
            }
        }
        return 0;
    }

    private boolean rangeCheck(int x, int y, int z){
        return (x>=0 && x<N && y>=0 && y<M && z>=0 && z<L);
    }

    public void run() throws Exception {
        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(L==0 && N==0 && M==0) break;
            que = new LinkedList<>();
            map = new int[L][N][M];
            visited = new boolean[L][N][M];

            for(int i=0; i<L; i++){
                for(int j=0; j<N; j++){
                    String str = br.readLine();
                    for(int k=0; k<M; k++){
                        if(str.charAt(k) == '.') map[i][j][k] = 0;
                        else if(str.charAt(k) == '#') map[i][j][k] = 1;
                        else if(str.charAt(k) == 'S') {
                            map[i][j][k] = 2;
                            que.add(new Node(j, k, i, 0));
                            visited[i][j][k] = true;
                        }
                        else map[i][j][k] = 3;
                    }
                }
                br.readLine();
            }
            int result = bfs();
            if(result == 0) sb.append("Trapped!\n");
            else sb.append("Escaped in " + result + " minute(s).\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}