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

    private int R;
    private int C;

    private int wolfCount = 0;
    private int sheepCount = 0;

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

        int nowSheep = 0;
        int nowWolf = 0;
        while(!que.isEmpty()){
            Node nowNode = que.poll();
            if(map[nowNode.x][nowNode.y] == 2) nowSheep++;
            else if(map[nowNode.x][nowNode.y] == 3) nowWolf++;
            for(int i=0; i<4; i++){
                int nowX = nowNode.x + dirX[i];
                int nowY = nowNode.y + dirY[i];
                if(rangeCheck(nowX, nowY) && !visited[nowX][nowY] && map[nowX][nowY] != 1){
                    que.add(new Node(nowX, nowY));
                    visited[nowX][nowY] = true;
                }
            }
        }
        if(nowSheep > nowWolf) sheepCount += nowSheep;
        else wolfCount += nowWolf;
    }

    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<R && y>=0 && y<C);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];
        map = new int[R][C];
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                if(str.charAt(j) == '.') map[i][j] = 0;
                else if(str.charAt(j) == '#') map[i][j] = 1;
                else if(str.charAt(j) == 'o') map[i][j] = 2;
                else if(str.charAt(j) == 'v') map[i][j] = 3;
            }
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && map[i][j] != 1) bfs(new Node(i, j));
            }
        }
        sb.append(sheepCount + " " + wolfCount + "\n");
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}