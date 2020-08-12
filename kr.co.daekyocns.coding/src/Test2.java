
public class Test2 {
	public static void main(String[] args) {
		int m = 108;
		int n = 80;
		int answer = 0;
		
		if (m > n) {
			answer = gcd(m, n);
		} else if (n > m) {
			answer = gcd(n, m);
		}
		
		System.out.println(answer);
	}
	
	public static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		} else if (m % n == 0) {
			return n;
		}
		
		return gcd(n, m % n);
	}
}
