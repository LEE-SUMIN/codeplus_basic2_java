package bf14;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] answer;
	static ArrayList<Integer> num = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			answer = new int[M + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num.add(Integer.parseInt(st.nextToken()));
			}
			num.sort(null);
			answer[0] = -1;
			calc(1);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void calc(int idx) {
		if(idx == M + 1) {
			for(int i = 1; i < M + 1; i++) {
				sb.append(answer[i]).append(' ');
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append('\n');
			return;
		}
		for(int i = 0; i < N; i++) {
			answer[idx] = num.get(i);
			calc(idx + 1);
		}
	}

}
