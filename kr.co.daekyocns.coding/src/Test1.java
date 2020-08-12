import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		
		String now = "24:00";
		int sh = Integer.parseInt(now.substring(0, 2));
		int sm = Integer.parseInt(now.substring(3));
		
		String bus = "05:14 00:55 06:14 07:35 22:45";
		
		String[] temp = bus.split(" ");
		
		Arrays.sort(temp, String.CASE_INSENSITIVE_ORDER);
		
		int lest = 0;
		
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].compareToIgnoreCase(now) == 1) {
				String[] time = temp[i].split(":");
				
				int h = Integer.parseInt(time[0]) - sh;
				int m = Integer.parseInt(time[1]) - sm;
				
				lest = h * 60 + m;
				
				break;
			}
			
			if (i == 4) {
				String[] time = temp[0].split(":");
				
				int h = Integer.parseInt(time[0]) + (24 - sh);
				int m = Integer.parseInt(time[1]) - sm;
				
				lest = h * 60 + m;
			}
		}
		
		System.out.println(lest);
	}
}
