import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] result;
    static int[] order;
    static int maxScore;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            result = new int[N + 1][10];

            StringTokenizer st;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= 9; j++) {
                    result[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void getScore() {
        boolean[] base = new boolean[3];
        int outCount = 0;
        int hitter = 1;

        int score = 0;

        for (int i = 1; i <= N; i++) {
            base = new boolean[4];
            outCount = 0;

            while (outCount < 3) {
                switch (result[i][order[hitter]]) {
                    case 0:
                        outCount += 1;
                        break;
                    case 1:
                        if (base[3]) {
                            score += 1;
                            base[3] = false;
                        }

                        for (int j = 3; j > 1; j--) {
                            if (base[j - 1]) {
                                base[j] = true;
                                base[j - 1] = false;
                            }
                        }
                        base[1] = true;

                        break;
                    case 2:
                        for (int j = 2; j <= 3; j++) {
                            if (base[j]) {
                                score += 1;
                                base[j] = false;
                            }
                        }

                        if (base[1]) {
i                            base[3] = true;
                            base[1] = false;
                        }

                        base[2] = true;

                        break;
                    case 3:
                        for (int j = 1; j <= 3; j++) {
                            if (base[j]) {
                                score += 1;
                                base[j] = false;
                            }
                        }

                        base[3] = true;

                        break;
                    case 4:
                        for (int j = 1; j < 4; j++) {
                            if (base[j]) {
                                score += 1;
                                base[j] = false;
                            }
                        }
                        score += 1;

                        Arrays.fill(base, false);
                }

                hitter += 1;

                if (hitter > 9) {
                    hitter = 1;
                }
            }
        }

        maxScore = Math.max(maxScore, score);
    }

    static void permutation(int index, boolean[] isOrdered) {
        if (index >= 10) {
            getScore();

            return;
        }

        if (index == 4) {
            isOrdered[1] = true;
            order[4] = 1;
            permutation(index + 1, isOrdered);
        }

        for (int i = 2; i <= 9; i++) {
            if (!isOrdered[i]) {
                isOrdered[i] = true;
                order[index] = i;
                permutation(index + 1, isOrdered);
                isOrdered[i] = false;
            }
        }
    }

    static void solve() {
        maxScore = 0;

        order = new int[10];

        permutation(1, new boolean[10]);

        System.out.println(maxScore);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}

