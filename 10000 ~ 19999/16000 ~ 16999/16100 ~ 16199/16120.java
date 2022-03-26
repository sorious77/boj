import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static String ppap;

    static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            ppap = br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        Stack<Character> st = new Stack<>();

        boolean isPPAP = true;
        boolean isExistA = false;

        for (char c : ppap.toCharArray()) {
            if (isExistA) {
                if (c == 'A' || st.size() < 3) {
                    isPPAP = false;
                    break;
                }

                char c3 = st.pop();
                char c2 = st.pop();
                char c1 = st.pop();

                if (c1 == 'P' && c2 == 'P' && c3 == 'A') {
                    st.push('P');
                }

                isExistA = false;
            } else {
                if (c == 'A') {
                    isExistA = true;
                }

                st.push(c);
            }
        }

        if(st.size() >= 2 || st.size() == 0 || (st.pop() == 'A')) {
            isPPAP = false;
        }

        System.out.println(isPPAP ? "PPAP" : "NP");
    }

    public static void main(String[] args) {
        input();

        solve();
    }
}

