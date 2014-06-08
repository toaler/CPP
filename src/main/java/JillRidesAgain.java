import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Solution to 507 - Jill Rides Again, see {@linktourl http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=448} 
 * for full details
 */
public class JillRidesAgain {

	public static int[] maxRangeSumQuery(int[] stops) {
		int[] range = new int[2];
		range[0] = range[1] = Integer.MIN_VALUE;
		
		int sum = 0;
		int max = 0;
		for (int i = 0; i < stops.length; i++) {
			if (range[0] == Integer.MIN_VALUE) {
				range[0] = i + 1;
			}

			sum += stops[i];
			
			if (sum < 0) {
				sum = 0;
				range[0] = Integer.MIN_VALUE;
			} else {
				if (max < max + stops[i]) {
					max += stops[i];
				    range[1] = i + 2;
				}
			}
		}
		
		if (range[1] == Integer.MIN_VALUE) {
			return null;
		}
		
		return range;
	}
	
	public static void main(String[] args) throws Exception {
		mainWork(System.in, System.out);
	}

	public static void mainWork(InputStream is, PrintStream os)
			throws IOException {

		Scanner s = new Scanner(is);

		StringBuilder sb = new StringBuilder();
		try {
			s.hasNext();
			int routes = s.nextInt();
			for (int route = 1; route <= routes; route++, s.hasNext()) {
				int init = s.nextInt();
				int[] rating = new int[init - 1];

				for (int j = 0 ; j < rating.length; j++) {
					s.nextLine();
					rating[j] = s.nextInt();
				}
				
				int[] range = maxRangeSumQuery(rating);
				
				if (range != null) {
					sb.append("The nicest part of route ").append(route).append(" is between stops ").append(range[0]).append(" and ").append(range[1]).append("\n");
				} else {
					sb.append("Route ").append(route).append(" has no nice parts\n");
				}
			}
			
			os.append(sb);
		} finally {
			s.close();
		}
	}


}
