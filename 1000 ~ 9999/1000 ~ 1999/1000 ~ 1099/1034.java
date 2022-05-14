import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] table;
    static int K;
    static int answer = 0;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            table = new int[N][M];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();

                for (int j = 0; j < M; j++) {
                    table[i][j] = s.charAt(j) - '0';
                }
            }

            K = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            int countZero = 0;
            int countLight = 1;

            for (int j = 0; j < M; j++) {
                if (table[i][j] == 0) {
                    countZero += 1;
                }
            }

            if (countZero > K || (countZero % 2 != K % 2)) {
                continue;
            }

            for(int j = i + 1; j < N; j++) {
                boolean isSame = true;

                for(int k = 0; k < M; k++) {
                    if(table[i][k] != table[j][k]) {
                        isSame = false;
                        break;
                    }
                }

                if(isSame) {
                    countLight += 1;
                }
            }

            answer = Math.max(countLight, answer);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
