
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(tk.nextToken());
		int l = Integer.parseInt(tk.nextToken());
		int[] cnt = new int[10001];
		int min = 987654321;
		int max = 0;
		tk = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(tk.nextToken());
			cnt[num] ++;
			if(num > max) max = num;
			if(num < min) min = num;
		}
		for(int i=min; i<=max; i++) {
			if(i>l) break;
			l += cnt[i];
		}
		System.out.print(l);
	}

}
