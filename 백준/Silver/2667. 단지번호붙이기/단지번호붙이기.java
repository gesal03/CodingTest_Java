import javax.swing.text.html.ListView;
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

    int N;
    int [][] map;
    boolean [][] visited;

    int [] dirX = {0,0,-1,1};
    int [] dirY = {-1,1,0,0};

    private class Node{
        int x;
        int y;
        Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    private void bfs(int x, int y){
        int count = 0;
        if(map[x][y] == 1) count++;

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x,y));
        visited[x][y] = true;

        while(!que.isEmpty()){
            Node node = que.poll();
            for(int i=0; i<4; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX, nowY)) {
                    if (visited[nowX][nowY] == false && map[nowX][nowY] == 1) {
                        que.add(new Node(nowX, nowY));
                        count++;
                    }
                    visited[nowX][nowY] = true;
                }
            }
        }
        if(count != 0) list.add(count);
    }
    private boolean rangeCheck(int x, int y){
        return (x>=0 && x<N && y>=0 && y<N);
    }

    public  void run() throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                visited[i][j] = false;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] == false && map[i][j] == 1) {
//                    System.out.println("Node X: " + i + ", Y: " + j + " 시작");
                    bfs(i, j);
                }
            }
        }
        sb.append(list.size() + "\n");
        Collections.sort(list);
        Iterator it = list.iterator();
        while(it.hasNext()){
            sb.append(it.next() + "\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        new Main().run();
    }
}