import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private int N;
    private int M;
    private final int[] dirX = {-1, 1, 0, 0};
    private final int[] dirY = {0, 0, -1, 1};
    private int[][] map;
    private boolean[][] visited;
    private int[] result = {0, 0};
    private static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(Node startNode) {
        int target = map[startNode.x][startNode.y];
        int count = 1;
        Queue<Node> que = new LinkedList<>();
        que.add(startNode);
        visited[startNode.x][startNode.y] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int nowX = node.x + dirX[i];
                int nowY = node.y + dirY[i];
                if (rangeCheck(nowX, nowY) && !visited[nowX][nowY] && map[nowX][nowY] == target) {
                    que.add(new Node(nowX, nowY));
                    visited[nowX][nowY] =true;
                    count++;
                }
            }
        }
//        System.out.print("target = " + target);
//        System.out.println(", count = " + count);
        result[target] += count*count;
    }

    private boolean rangeCheck(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == 'W') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]) bfs(new Node(i, j));
            }
        }

        for (int value : result) sb.append(value).append(" ");
        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}