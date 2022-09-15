import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Area implements Comparable<Area> {
        int x, y;
        int bamboo;

        public Area(int x, int y, int bamboo) {
            this.x = x;
            this.y = y;
            this.bamboo = bamboo;
        }

        @Override
        public int compareTo(Area o) {
            return Integer.compare(this.bamboo, o.bamboo);
        }
    }

    static int N;
    static int[][] map;
    static long[][] dp;
    static PriorityQueue<Area> areas;

    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dp = new long[N][N];
            areas = new PriorityQueue<>();

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = 1;

                    areas.offer(new Area(j, i, map[i][j]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static long getMaxBamboo(Area area) {
        long maxBamboo = 1;

        for (int i = 0; i < 4; i++) {
            int nx = area.x + move[i][0];
            int ny = area.y + move[i][1];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (map[ny][nx] < map[area.y][area.x]) {
                    maxBamboo = Math.max(maxBamboo, dp[ny][nx] + 1);
                }
            }
        }

        return maxBamboo;
    }

    static void solve() {
        long answer = 0;

        while (!areas.isEmpty()) {
            Area area = areas.poll();

            dp[area.y][area.x] = getMaxBamboo(area);

            answer = Math.max(dp[area.y][area.x], answer);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}


