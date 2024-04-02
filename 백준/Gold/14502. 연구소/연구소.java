import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    private int[] dirX = {-1, 1, 0, 0};
    private int[] dirY = {0, 0, -1, 1};
    private int[][] map;
    private boolean[][] visited;
    private ArrayList<Node> virus = new ArrayList<>();
    private int maxCount = 0;

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void spreadVirus() {
        Queue<Node> que = new LinkedList<>();
        Iterator<Node> it = virus.iterator();
        while (it.hasNext()) {
            Node node = it.next();
            que.add(node);
            visited[node.x][node.y] = true;
        }
        while (!que.isEmpty()) {
            Node node = que.poll();
            for(int i=0; i<4; i++){
                int nowX = node.x + dirX[i];
                int nowY = node.y+dirY[i];
                if(rangeCheck(nowX,nowY) && !visited[nowX][nowY] && map[nowX][nowY] == 0){
                    que.add(new Node(nowX, nowY));
                    visited[nowX][nowY] = true;
                }
            }
        }
    }
    private void checkSafeZone(){
        int count =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && map[i][j] == 0) count++;
            }
        }
        if(maxCount < count) maxCount = count;

    }

    private void makeWall(int count) {
        if (count == 3) {
            visited = new boolean[N][M];
            spreadVirus();
            checkSafeZone();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new Node(i, j));
            }
        }
        makeWall(0);
        System.out.println(maxCount);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}