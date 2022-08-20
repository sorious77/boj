import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, length;
    static int[] trains, sum;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            trains = new int[N + 1];
            sum = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                trains[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + trains[i];
            }

            length = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int[][] dp = new int[4][N + 1];

        for (int i = 1; i <= 3; i++) {
            for (int j = i * length; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - length] + (sum[j] - sum[j - length]));
            }
        }

        System.out.println(dp[3][N]);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

