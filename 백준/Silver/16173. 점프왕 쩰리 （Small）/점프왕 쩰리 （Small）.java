import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb = new StringBuilder();
    private int N;
    private int[][] map;
    private boolean[][] visited;
    private int[] dirX = {1, 0};
    private int[] dirY = {0, 1};

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ") -> " + map[this.x][this.y];
        }
    }

    private boolean bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        visited[0][0] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            int distance = map[node.x][node.y];
            for (int i = 0; i <= distance; i++) {
                for (int j = 0; j < 2; j++) {
                    int nowX = node.x + dirX[j] * distance;
                    int nowY = node.y + dirY[j] * distance;
                    if(rangeCheck(nowX,nowY) && !visited[nowX][nowY]){
                        que.add(new Node(nowX, nowY));
                        visited[nowX][nowY] = true;
                        if(map[nowX][nowY] == -1) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public void run() throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (bfs()) sb.append("HaruHaru");
        else sb.append("Hing");
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}