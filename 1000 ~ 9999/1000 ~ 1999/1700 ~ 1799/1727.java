import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] male;
    static int[] female;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            male = new int[N + 1];
            female = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                male[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                female[i] = Integer.parseInt(st.nextToken());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        Arrays.sort(male);
        Arrays.sort(female);

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j - 1] + Math.abs(male[i] - female[j]);

                if (i > j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j]);
                }

                if (j > i) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i][j]);
                }
            }
        }

        System.out.println(dp[N][M]);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
