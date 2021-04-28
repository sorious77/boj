import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int findGCD(int a, int b) {
		if(b == 0) {
			return a;
		}
				
		return findGCD(b, a % b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		int gcd = findGCD(y1, y2);
		int lcm = y1 * y2 / gcd;
		
		int resX = x1 * (lcm / y1) + x2 * (lcm / y2);
		int resY = lcm;
		
		while(true) {
			gcd = findGCD(resX, resY);
			
			if(gcd == 1)
				break;
			
			resX /= gcd;
			resY /= gcd;
		}
		
		System.out.println(resX + " " + resY);
	}
}
