import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();

    private int [][] map;
    private boolean [][] visited;
    int w;
    int h;
    private int count =0;

    private int [] dirX = {-1, 1, 0, 0, -1, -1, 1, 1};
    private int [] dirY = {0, 0, -1, 1, 1, -1, 1, -1};

    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private int bfs(Node node) {
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        visited[node.x][node.y] = true;
        while(!que.isEmpty()){
            node = que.poll();
            for(int i=0; i<8; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX,nowY) && !visited[nowX][nowY] && map[nowX][nowY]==1){
                    que.add(new Node(nowX, nowY));
                    visited[nowX][nowY] = true;
                }
            }

        }
        return 0;
    }

    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<w && y>=0 && y<h);
    }

    public void run() throws Exception {
        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0)
                break;

            map = new int[w][h];
            visited = new boolean[w][h];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[j][i] == 1 && !visited[j][i]){
                        bfs(new Node(j, i));
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