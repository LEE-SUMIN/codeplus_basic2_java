package bf31;
import java.io.*;
public class Main {
	static int N;
	static char[][] sign;
	static boolean once;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			N = Integer.parseInt(br.readLine());
			sign = new char[N][N];
			int[] answer = new int[N];
			String input = br.readLine();
			int index = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(j < i) {
						sign[i][j] = '*';
					}
					else {
						sign[i][j] = input.charAt(index++);
					}
				}
			}
			
			calc(0, answer);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void calc(int idx, int[] answer) {
		if(once)
			return;
		if(!condition(idx, answer)) {
			return;
		}
		if(idx == N) {
			for(int i = 0; i < N; i++) {
				sb.append(answer[i]).append(' ');
				once = true;
			}
			return;
		}
		for(int i = -10; i <= 10; i++) {
			answer[idx] = i;
			calc(idx + 1, answer);
		}
	}
	
	public static boolean condition(int idx, int[] answer) {
		for(int i = 0; i < idx; i++) {
			int sum = 0;
			for(int j = i; j < idx; j++) {
				sum += answer[j];
				if(sign[i][j] == '0') {
					if(sum != 0) return false;
				}
				else if(sign[i][j] == '+') {
					if(sum <= 0) return false;
				}
				else if(sign[i][j] == '-') {
					if(sum >= 0) return false;
				}
			}
		}
		return true;
	}

}
