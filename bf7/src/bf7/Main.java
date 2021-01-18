package bf7;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			int size = 1;
			
			while(Math.pow(10, size) - 1 < N) {
				count += (size * 9 * Math.pow(10,  size - 1));
				size++;	
			}
			count += ((N - Math.pow(10, size - 1) + 1) * size);
			
			System.out.println(count);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
