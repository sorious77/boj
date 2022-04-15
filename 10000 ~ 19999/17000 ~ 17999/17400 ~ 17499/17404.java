import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] streets;

    static final int MAX_VALUE = 1000001;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            streets = new int[N + 1][3];

            StringTokenizer st;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 3; j++) {
                    streets[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int[][] red = new int[N + 1][3];
        int[][] blue = new int[N + 1][3];
        int[][] green = new int[N + 1][3];

        Arrays.fill(red[1], MAX_VALUE);
        Arrays.fill(blue[1], MAX_VALUE);
        Arrays.fill(green[1], MAX_VALUE);

        red[1][0] = streets[1][0];
        blue[1][1] = streets[1][1];
        green[1][2] = streets[1][2];

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                red[i][j] = Math.min(red[i - 1][(j + 1) % 3], red[i - 1][(j + 2) % 3]) + streets[i][j];
                blue[i][j] = Math.min(blue[i - 1][(j + 1) % 3], blue[i - 1][(j + 2) % 3]) + streets[i][j];
                green[i][j] = Math.min(green[i - 1][(j + 1) % 3], green[i - 1][(j + 2) % 3]) + streets[i][j];
            }
        }

        int answer = MAX_VALUE;

        answer = Math.min(answer, Math.min(red[N][1], red[N][2]));
        answer = Math.min(answer, Math.min(blue[N][0], blue[N][2]));
        answer = Math.min(answer, Math.min(green[N][0], green[N][1]));

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

