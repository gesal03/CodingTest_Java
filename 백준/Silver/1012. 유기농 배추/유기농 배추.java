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

    int [][] map;
    boolean [][] visited;

    int [] dirX = {0, 0, -1, 1};
    int [] dirY = {-1, 1, 0, 0};

    int M; int N;

    class Point{
        int x;
        int y;
        Point(int x, int y){this.x=x; this.y=y;}
    }

    private void bfs(int x, int y){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x,y));
        visited[y][x] = true;
        while(!que.isEmpty()){
            Point node = que.poll();
            for(int i=0; i<4; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX, nowY) && visited[nowY][nowX] ==false && map[nowY][nowX] == 1){
                    que.add(new Point(nowX, nowY));
                    visited[nowY][nowX]=true;
                }
            }
        }
    }

    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<M && y>=0 && y<N);
    }
    public  void run() throws Exception {
        int T = Integer.parseInt(br.readLine());

        for(int k=0; k<T; k++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로의 길이
            N = Integer.parseInt(st.nextToken()); // 세로의 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0; i<K; i++){
                st  = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            int count=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 1 && visited[i][j] ==false){
                        count++;
                        bfs(j, i);
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