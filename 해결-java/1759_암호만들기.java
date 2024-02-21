
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DK_B1759 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static char[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		m = Integer.parseInt(tk.nextToken());
		n = Integer.parseInt(tk.nextToken());
		arr = new char[n];
		tk = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = tk.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		combination(0,0,new boolean[n]);
		System.out.println(sb);
	}
	static void combination(int start, int cnt, boolean[]selected) {
//		System.out.println(Arrays.toString(selected));
		if(start+(m-cnt) > n) return;
		if(cnt == m) {
//			System.out.println(Arrays.toString(selected));
			StringBuilder newSb = new StringBuilder();
			int j=0;
			int m=0;
			for(int i=0; i<n; i++) {
				if(selected[i]) {
					newSb.append(arr[i]);
					if(arr[i]=='a' || arr[i]=='o' || arr[i]=='u' || arr[i]=='i' || arr[i]=='e') {
						m++;
					}
					else {
						j++;
					}
				}
			}
			if(m!=0 && j >=2) {
				sb.append(newSb);
				sb.append("\n");
			}
			return;
		}
		
		selected[start] = true;
		combination(start+1, cnt+1, selected);
		selected[start] = false;
		combination(start+1, cnt, selected);

		
	}
}
