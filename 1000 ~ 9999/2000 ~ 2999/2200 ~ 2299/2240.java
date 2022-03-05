import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, W;
    static int[] plum;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            T = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            plum = new int[T + 1];

            for (int i = 1; i <= T; i++) {
                plum[i] = Integer.parseInt(br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int[][] dp = new int[T + 1][W + 1];

        int answer = -1;

        for (int i = 1; i <= T; i++) {
            dp[i][0] = dp[i - 1][0] + (plum[i] == 1 ? 1 : 0);
            answer = Math.max(answer, dp[i][0]);

            // j가 짝수 -> 현재 1번 나무, j가 홀수 -> 현재 2번 나무
            for (int j = 1; j <= W; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);

                if ((j % 2 == 0 && plum[i] == 1) || (j % 2 == 1 && plum[i] == 2)) {
                    dp[i][j] += 1;
                }

                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

