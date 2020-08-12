
public class Test3 {
	public static void main(String[] args) {
		double total = 100000000, win = 80;
		double per = win / total * 100;
		int cnt = 0;
		if (per >= 99) {
			System.out.println("X");
		} else {
			while (total < 100000000) {
				total++;
				win++;
				cnt++;
				double now = win / total * 100;
				
				if (getPer(per) + 1 == getPer(now)) {
					System.out.println(cnt);
					break;
				}
			}
			
			if (total >= 100000000) {
				System.out.println("X");
			}
		}
	}
	
	public static int getPer(double num) {
		String str = Double.toString(num);
		int dot = str.indexOf(".");
		
		return Integer.parseInt(str.substring(0, dot));
	}
}
