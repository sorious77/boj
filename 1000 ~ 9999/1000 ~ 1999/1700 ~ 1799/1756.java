import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int D, N;

    static int[] oven;
    static int[] pizza;

    static int[] canCover;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            oven = new int[D + 1];
            canCover = new int[D + 1];
            int max = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= D; i++) {
                oven[i] = Integer.parseInt(st.nextToken());

                canCover[i] = Math.min(max, oven[i]);
                max = canCover[i];
            }

            pizza = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pizza[i] = Integer.parseInt(st.nextToken());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        int bottom = D;
        boolean isFilled;

        for (int i = 0; i < N; i++) {
            isFilled = false;

            for(int j = bottom; j >= 1; j--) {
                if(pizza[i] <= canCover[j]) {
                    isFilled = true;
                    bottom = j - 1;
                    break;
                }
            }

            if(!isFilled) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(bottom + 1);
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
