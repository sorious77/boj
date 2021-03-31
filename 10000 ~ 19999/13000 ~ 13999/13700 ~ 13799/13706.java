import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		BigInteger input = new BigInteger(br.readLine());
		
		BigInteger left = new BigInteger("1");
		BigInteger right = input, mid;
		
		while(left.compareTo(right) <= 0) {
			mid = left.add(right).divide(new BigInteger("2"));
			
			BigInteger multi = mid.multiply(mid);
			
			if(multi.compareTo(input) == 0) {
				System.out.println(mid);
				break;
			}
			else if(multi.compareTo(input) == 1) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
	}
}