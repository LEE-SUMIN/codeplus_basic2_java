package bf30;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[] arr;
	static int[] min;
	static int[] max;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			arr = new char[N];
			min = new int[N + 1];
			max = new int[N + 1];
			int[] answer = new int[N + 1];
			boolean[] check = new boolean[10];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = st.nextToken().charAt(0);
			}
			
			calc(check, answer);
			
			print(max);
			sb.append('\n');
			print(min);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void calc(boolean[] check, int[] answer) {
		for(int i = 0; i < N + 1; i++) {
			min[i] = 10;
			max[i] = -1;
		}
		for(int i = 0; i < 10; i++) {
			check[i] = true;
			answer[0] = i;
			go(1, check, answer);
			check[i] = false;
		}
	}
	
	public static void go(int idx, boolean[] check, int[] answer) {
		if(idx == N + 1) {
			if(find_min(answer)) {
				deepcopy(min, answer);
			}
			else if(find_max(answer)) {
				deepcopy(max, answer);
			}
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(check[i]) {
				continue;
			}
			if(arr[idx - 1] == '<') {
				if(answer[idx - 1] < i) {
					check[i] = true;
					answer[idx] = i;
					go(idx + 1, check, answer);
					check[i] = false;
				}
			}
			else if(arr[idx - 1] == '>'){
				if(answer[idx - 1] > i) {
					check[i] = true;
					answer[idx] = i;
					go(idx + 1, check, answer);
					check[i] = false;
				}
			}
		}
	}
	
	public static boolean find_min(int[] answer) {
		for(int i = 0; i < N + 1; i++) {
			if(min[i] > answer[i]) {
				return true;
			}
			else if(min[i] < answer[i]) {
				return false;
			}
		}
		return false;
	}
	
	public static boolean find_max(int[] answer) {
		for(int i = 0; i < N + 1; i++) {
			if(max[i] < answer[i]) {
				return true;
			}
			else if(max[i] > answer[i]) {
				return false;
			}
		}
		return false;
	}
	
	public static void deepcopy(int[] a, int[] answer) {
		for(int i = 0; i < N + 1; i++) {
			a[i] = answer[i];
		}
	}
	
	public static void print(int[] a) {
		for(int i = 0; i < a.length; i++) {
			sb.append(a[i]);
		}
	}
}