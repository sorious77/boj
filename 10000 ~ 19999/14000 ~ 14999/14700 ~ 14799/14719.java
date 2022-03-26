import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[] blocks;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            blocks = new int[W];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < W; i++) {
                blocks[i] = Integer.parseInt(st.nextToken());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int[] left = new int[W];
        int[] right = new int[W];

        int answer = 0;

        left[0] = blocks[0];
        right[W - 1] = blocks[W - 1];
        for (int i = 1; i < W - 1; i++) {
            left[i] = Math.max(left[i - 1], blocks[i]);
            right[W - i - 1] = Math.max(right[W - i], blocks[W - i - 1]);
        }

        for (int i = 1; i < W - 1; i++) {
            answer += Math.min(left[i], right[i]) - blocks[i];
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

