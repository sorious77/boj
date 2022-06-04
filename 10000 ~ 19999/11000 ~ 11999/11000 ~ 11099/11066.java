import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[][] chapters;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            T = Integer.parseInt(br.readLine());

            chapters = new int[T][];
            for (int t = 0; t < T; t++) {
                int K = Integer.parseInt(br.readLine());

                StringTokenizer st = new StringTokenizer(br.readLine());
                chapters[t] = new int[K + 1];
                for (int k = 1; k <= K; k++) {
                    chapters[t][k] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int K = chapters[t].length - 1;

            int[] sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];

            sum[1] = chapters[t][1];
            for (int i = 2; i <= K; i++) {
                sum[i] = sum[i - 1] + chapters[t][i];
            }

            for (int i = 1; i < K; i++) {
                for (int j = 1; j + i <= K; j++) {
                    int k = j + i;
                    dp[j][k] = 99999999;

                    for (int mid = j; mid < k; ++mid) {
                        dp[j][k] = Math.min(dp[j][k], dp[j][mid] + dp[mid + 1][k] + sum[k] - sum[j - 1]);
                    }
                }
            }

            sb.append(dp[1][K]).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

