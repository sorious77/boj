import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int answer = 0;

		int[] sushi = new int[N];
		int[] count = new int[d + 1];

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int left = 0, right = k - 1;
		for (int i = 0; i < k; i++) {
			if (count[sushi[i]] == 0) {
				answer++;
			}
			count[sushi[i]]++;
		}

		int temp = answer;

		do {
			int coupon = count[c] == 0 ? temp + 1 : temp;
			answer = answer > coupon ? answer : coupon;
			
			count[sushi[left]]--;
			if(count[sushi[left]] == 0)
				temp--;
			
			left = (left + 1) % N;
			right = (right + 1) % N;
									
			if(count[sushi[right]] == 0) {
				temp++;
			}
			count[sushi[right]]++;
		} while (left != 0);

		System.out.println(answer);
	}
}
