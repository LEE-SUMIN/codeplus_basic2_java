package bf6;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		try {
			int M = 0, N = 0, x = 0, y = 0;
			int num = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				M = Integer.parseInt(st.nextToken());
				N = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				int cnt = 0;
				for(int year = x; ;year += M) {
					if(cnt > N) {
						sb.append(-1).append('\n');
						break;
					}
					cnt++;
					if((year - 1) % N + 1 == y) {
						sb.append(year).append('\n');
						break;
					}
				}
			}
			bw.write(sb.toString());
			br.close();
			bw.close();
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
