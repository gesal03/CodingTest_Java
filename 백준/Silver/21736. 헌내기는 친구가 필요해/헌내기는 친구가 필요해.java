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
    private final int P = 2;
    private final int X = 1;
    private int N;
    private int M;
    private int [][] map;
    private boolean [][] visited;
    private int [] dirX = {-1,1,0,0};
    private int [] dirY = {0,0,-1,1};
    private Queue<Node> que = new LinkedList<>();
    private class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    private int bfs(){
        int count = 0;
        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i=0; i<4; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX,nowY) && !visited[nowX][nowY] && map[nowX][nowY] != X){
                    que.add(new Node(nowX, nowY));
                    visited[nowX][nowY] = true;
                    if(map[nowX][nowY] == P) count++;
                }
            }
        }
        return count;
    }
    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<N && y>=0 && y<M);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'O') map[i][j] = 0;
                else if(str.charAt(j) == 'X') map[i][j] = 1;
                else if(str.charAt(j) == 'P') map[i][j] = 2;
                else{
                    map[i][j] = 3;
                    que.add(new Node(i, j));
                }
            }
        }
        int answer = bfs();
        if(answer == 0) sb.append("TT");
        else sb.append(answer);
        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}