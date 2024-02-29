import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private StringBuilder sb = new StringBuilder();

    private int [][] map;
    private boolean [][] visited;

    private int N;
    private int M;

    private int [] dirX = {0, 0, -1, 1};
    private int [] dirY = {-1, 1, 0, 0};

    private Queue<Node> que = new LinkedList<>();

    class Node{
        int x;
        int y;
        int day;
        Node(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    private int bfs(){
        int count = 0;
        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i=0; i<4; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX, nowY) && visited[nowX][nowY] == false && map[nowX][nowY] == 0){
                    int day = node.day + 1;
                    if(day > count) count=day;
                    que.add(new Node(nowX, nowY, day));
                    visited[nowX][nowY] = true;
                }
            }
        }
        return count;
    }
    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<N && y>=0 && y<M);
    }

    public  void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    que.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int result = bfs();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0 && visited[i][j] == false)
                    result = -1;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}