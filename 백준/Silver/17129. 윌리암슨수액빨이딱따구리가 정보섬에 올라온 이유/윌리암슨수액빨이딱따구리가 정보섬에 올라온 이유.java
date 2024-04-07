import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    private int[] dirX = {-1, 1, 0, 0};
    private int[] dirY = {0, 0, -1, 1};
    private int[][] map;
    private boolean[][] visited;
    private int result;

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

    private boolean bfs(Node startNode) {
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode.x][startNode.y] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if(rangeCheck(nowX, nowY) && !visited[nowX][nowY] && map[nowX][nowY] != 1){
                    if(map[nowX][nowY] != 0 ) {
                        result = node.distance+1;
                        return true;
                    }
                    que.add(new Node(nowX, nowY, node.distance+1));
                    visited[nowX][nowY] = true;
                }
            }
        }

        return false;
    }

    private boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        Node startNode = new Node(0, 0, 0);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                if (map[i][j] == 2) startNode = new Node(i, j, 0);
            }
        }
        if(bfs(startNode)) sb.append("TAK\n").append(result);
        else sb.append("NIE");

        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}