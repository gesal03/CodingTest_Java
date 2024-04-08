import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    private final int[] dirX = {-2, -2, -1, -1, 1, 1, 2, 2};
    private final int[] dirY = {-1, 1, -2, 2, -2, 2, -1, 1};
    private int[][] map;
    private boolean[][] visited;
    private int[] result;

    private static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private void bfs(Node startNode) {
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode.x][startNode.y] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 8; i++) {
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if (rangeCheck(nowX, nowY) && !visited[nowX][nowY]) {
                    if (map[nowX][nowY] != 0) {
                        result[map[nowX][nowY] - 1] = node.distance + 1;
//                        System.out.println(map[nowX][nowY]-1 + ": " + node.distance+1);
                    }
                    que.add(new Node(nowX, nowY, node.distance + 1));
                    visited[nowX][nowY] = true;
                }
            }
        }
    }

    private boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        result = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) map[i][j] = 0;
        }

        st = new StringTokenizer(br.readLine());
        Node startNode = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = i + 1;
        }
        bfs(startNode);
        for (int value : result) sb.append(value).append(" ");

        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}