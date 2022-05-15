import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] heights;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            heights = new int[N + 1][N + 1];

            for (int i = 0; i <= N; i++) {
                Arrays.fill(heights[i], 9999999);
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int small = Integer.parseInt(st.nextToken());
                int big = Integer.parseInt(st.nextToken());

                heights[small][big] = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (heights[i][j] > heights[i][k] + heights[k][j]) {
                        heights[i][j] = 1;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int count = 0;

            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }

                if (heights[i][j] == 1 || heights[j][i] == 1) {
                    count += 1;
                }
            }

            if(count == N - 1) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

