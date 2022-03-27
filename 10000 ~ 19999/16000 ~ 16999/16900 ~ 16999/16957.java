import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static int[][] board;
    static Pair[][] dp;

    static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {1, 1}, {-1, -1}, {-1, 1}};

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            board = new int[R][C];
            dp = new Pair[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < C; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean canMove(int x, int y) {
        return (0 <= x) && (x < C) && (0 <= y) && (y < R);
    }

    static Pair nextMove(Pair pair) {
        Pair smallest = null;

        int x = pair.x;
        int y = pair.y;

        for (int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (canMove(nx, ny)) {
                if (board[ny][nx] < board[y][x]) {
                    if (smallest == null || board[smallest.y][smallest.x] > board[ny][nx]) {
                        smallest = new Pair(nx, ny);
                    }
                }
            }
        }

        if (smallest != null && dp[smallest.y][smallest.x] != null) {
            return dp[smallest.y][smallest.x];
        }

        return smallest;
    }

    static void traversal(int x, int y) {
        List<Pair> path = new ArrayList<>();

        Pair cur = new Pair(x, y);
        path.add(cur);

        while (true) {
            Pair next = nextMove(cur);

            if (next != null) {
                cur = next;

                if (dp[next.y][next.x] != null) {
                    break;
                }

                path.add(next);
            } else {
                break;
            }
        }

        for (Pair p : path) {
            dp[p.y][p.x] = cur;
        }
    }

    static void solve() {
        int[][] answer = new int[R][C];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (dp[i][j] == null) {
                    traversal(j, i);
                }

                int x = dp[i][j].x;
                int y = dp[i][j].y;

                answer[y][x] += 1;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(String.format("%d ", answer[i][j]));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}


