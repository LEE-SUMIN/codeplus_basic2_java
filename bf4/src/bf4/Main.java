package bf4;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] buttons;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int channel = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			buttons = new boolean[10];
			boolean only_vol = true;
			if(N != 0) {
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < N; i++) {
					buttons[Integer.parseInt(st.nextToken())] = true;
				}
			}
			//��� ��ư�� �� ���峭 ��� only_vol = true
			for(int i = 0; i < 10; i++) {
				if(!buttons[i]) {
					only_vol = false;
					break;
				}
			}
			//������ư������ ä�� �̵��ϴµ� ������ Ƚ��
			int count = Math.abs(channel - 100);
			
			if(!only_vol) { //��� ��ư�� �� ���峭�� �ƴ϶��
				count = Math.min(count, calc(channel));
			}
			else if(!buttons[0]) { //0�� �ȴٸ�
				count = Math.min(count, 1 + channel); 
			}
			 
			System.out.println(count);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int isValid(int channel) { //���� ��ư������ �̵� �����Ѱ�?
		int len = 0;
		if(channel == 0) {
			if(buttons[0]) return 0;
			else return 1;
		}
		while(channel > 0) {
			if(buttons[channel % 10]) {
				return 0;
			}
			channel /= 10;
			len++;
		}
		return len;
	}
	
	public static int calc(int channel) {
		int count = 0;
		int down = channel;
		int up = channel;
		while(true) {
			if(down > -1) {
				count = isValid(down);
				if(count > 0 && down > -1) {
					count += Math.abs(channel - down);
					break;
				}
				down--;
			}
			
			if(up < 1000000) {
				count = isValid(up);
				if(count > 0) {
					count += Math.abs(channel - up);
					break;
				}
				up++;
			}
		}
		return count;
	}

}
