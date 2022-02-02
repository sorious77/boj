import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static String[] students;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            students = new String[N];

            for (int i = 0; i < N; i++) {
                students[i] = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        long goodFriends = 0;
        int lastIndex = 0;
        int[] countLength = new int[21];

        for (int i = 1; i <= K; i++) {
            int curStudent = students[i].length();

            countLength[curStudent] += 1;
        }
        lastIndex = K;

        for (int i = 0; i < N - 1; i++) {
            int curStudent = students[i].length();

            if(i > 0)
                countLength[curStudent] -= 1;

            goodFriends += countLength[curStudent];

            if (lastIndex + 1 < N) {
                lastIndex += 1;

                int nextStudent = students[lastIndex].length();
                countLength[nextStudent] += 1;
            }
        }

        System.out.println(goodFriends);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
