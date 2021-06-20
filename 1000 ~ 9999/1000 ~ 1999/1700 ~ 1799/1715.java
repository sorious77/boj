import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			minHeap.offer(num);
		}
		
		int answer = 0;

		while (!minHeap.isEmpty()) {
			if(minHeap.size() == 1) {
				break;
			}
			
			int a = minHeap.poll();
			int b = minHeap.poll();
						
			answer += a + b;
			minHeap.offer(a + b);
		}
		
		System.out.println(answer);
	}
}
