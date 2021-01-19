package bf25;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] num;
	static int N;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		String input;
		try {
			input = br.readLine();
			while(!input.equals("0")) {
				st = new StringTokenizer(input);
				N = Integer.parseInt(st.nextToken());
				num = new int[N];
				for(int i = 0; i < N; i++) {
					num[i] = Integer.parseInt(st.nextToken());
				}
				boolean[] check = new boolean[N];
				choose_six(check, 0, 0);
				sb.append('\n');
				input = br.readLine();
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static void choose_six(boolean[] check, int idx, int cur) {
		if(idx == 6) {
			for(int i = 0; i < N; i++) {
				if(check[i]) {
					sb.append(num[i]).append(' ');
				}
			}
			sb.append('\n');
			return;
		}
		
		for(int i = cur; i < N; i++) {
			if(!check[i]) {
				check[i] = true;
				choose_six(check, idx + 1, i);
				check[i] = false;
			}
		}
	}

}
