import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] hates;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st;
            hates = new int[N + 1][];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                int numOfHate = Integer.parseInt(st.nextToken());
                hates[i] = new int[numOfHate];

                for (int j = 0; j < numOfHate; j++) {
                    hates[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int[] teams = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (teams[i] == 0) {
                teams[i] = 1;

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);

                while (!q.isEmpty()) {
                    int cur = q.poll();
                    int flag = teams[cur];

                    for (int hate : hates[cur]) {
                        if (teams[hate] == 0) {
                            teams[hate] = flag * -1;
                            q.offer(hate);
                        }
                    }
                }
            }
        }

        StringBuilder blueTeam = new StringBuilder();
        StringBuilder whiteTeam = new StringBuilder();

        int numOfBlueTeam = 0;
        int numOfWhiteTeam = 0;
        for (int i = 1; i <= N; i++) {
            if (teams[i] == 1) {
                numOfBlueTeam += 1;
                blueTeam.append(i).append(" ");
            } else {
                numOfWhiteTeam += 1;
                whiteTeam.append(i).append(" ");
            }
        }

        System.out.println(numOfBlueTeam);
        System.out.println(blueTeam);

        System.out.println(numOfWhiteTeam);
        System.out.println(whiteTeam);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
