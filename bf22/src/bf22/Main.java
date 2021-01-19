package bf22;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			for(int i = 0; i < N; i++) {
				num[i] = i + 1;
			}
			
			Permutation p = new Permutation(num, N);
			
			sb.append(p.print());
			while(p.find_next()) {
				sb.append(p.print());
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();		
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Permutation {
	int[] num;
	int N;
	
	Permutation(int[] num, int N){
		this.num = num;
		this.N = N;
	}
	
	public int find_left() {
		int left = N - 1;
		if(left == 0) {
			return -1;
		}
		while(num[left] < num[left - 1]) {
			left--;
			if(left == 0) {
				return -1;
			}
		}
		return left;
	}
	
	public void swap(int left) {
		int right = N - 1;
		int min = 10000;
		for(int i = left; i < N; i++) {
			if(num[left - 1] < num[i] && min > num[i]) {
				right = i;
				min = num[i];
			}
		}
		
		int temp = num[left - 1];
		num[left - 1] = num[right];
		num[right] = temp;
	}
	
	public void reverse(int left) {
		int start = left;
		int end = N - 1;
		for(int i = start; i < (end + start + 1) / 2; i++) {
			int temp = num[i];
			num[i] = num[end + start - i];
			num[end + start - i] = temp;
		}
	}
	
	public boolean find_next() {
		int left = find_left();
		if(left == -1) {
			return false;
		}
		swap(left);
		reverse(left);
		return true;
	}
	
	public StringBuilder print() {
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb2.append(num[i]).append(' ');
		}
		sb2.append('\n');
		return sb2;
	}
	
}
