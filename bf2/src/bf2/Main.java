package bf2;
import java.io.*;

public class Main {
	static int N;
	static char[][] table;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			N = Integer.parseInt(br.readLine());
			table = new char[N][N];
			for(int i = 0; i < N; i ++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					table[i][j] = input.charAt(j);
				}
			}
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int count = 0;
					if(j != N - 1) {
						swap(i, j, i, j + 1);
						count = Math.max(find_row(i), Math.max(find_col(j), find_col(j + 1)));
						if(max < count) max = count;
						swap(i, j, i, j + 1);
					}
					if(i != N - 1) {
						swap(i, j, i + 1, j);
						count = Math.max(find_col(j), Math.max(find_row(i), find_row(i + 1)));
						if(max < count) max = count;
						swap(i, j, i + 1, j);
					}
				}
			}
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void swap(int i1, int j1, int i2, int j2) {
		char temp = table[i1][j1];
		table[i1][j1] = table[i2][j2];
		table[i2][j2] = temp;
	}
	
	public static int find_row(int idx) {
		int count = 1;
		int max = 1;
		for(int i = 1; i < N; i++) {
			if(table[idx][i - 1] == table[idx][i]) {
				count++;
				if(count > max) {
					max = count;
				}
			}
			else {
				count = 1;
			}
		}
		return max;
	}
	
	public static int find_col(int idx) {
		int count = 1;
		int max = 1;
		for(int i = 1; i < N; i++) {
			if(table[i - 1][idx] == table[i][idx]) {
				count++;
				if(count > max) {
					max = count;
				}
			}
			else {
				count = 1;
			}
		}
		return max;
	}

}
