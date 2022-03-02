import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            graph = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                Arrays.fill(graph[i], 999999);
                graph[i][i] = 0;
            }

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x == -1 && y == -1) {
                    break;
                }

                graph[x][y] = 1;
                graph[y][x] = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int[] score = new int[N + 1];
        int answer = 99999;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                score[i] = Math.max(score[i], graph[i][j]);
            }
            answer = Math.min(answer, score[i]);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(int i = 1; i <= N; i++){
            if(score[i] == answer) {
                count += 1;
                sb.append(i).append(" ");
            }
        }

        sb.substring(0, sb.length() - 1);

        System.out.println(answer + " " + count);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}