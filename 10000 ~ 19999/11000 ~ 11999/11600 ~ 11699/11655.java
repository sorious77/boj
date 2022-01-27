import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String s;

    static void input() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            s = br.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        char []answer = s.toCharArray();

        int length = answer.length;

        for(int i = 0; i < length; i++) {
            char c = answer[i];

            if (Character.isUpperCase(c)) {
                answer[i] = (char)(c + 13 > 'Z' ? c - 13 : c + 13);
            } else if(Character.isLowerCase(c)) {
                answer[i] = (char)(c + 13 > 'z' ? c - 13 : c + 13);
            }
        }

        System.out.println(String.valueOf(answer));
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}
