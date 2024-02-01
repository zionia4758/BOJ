
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2961 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] bitter = new int[n];
		int[] sour = new int[n];
		for(int i=0;i<n;i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			bitter[i] = b;
			sour[i] = s;
		}
		int answer = (1<<31)-1;
		for(int bitmask=1; bitmask!=(1<<n); bitmask++) {
			int bSum = 0;
			int sSum = 1;
			for(int i=0; i<n; i++) {
				if(((1<<i)&bitmask)!=0) {
					bSum += bitter[i];
					sSum *= sour[i];
				}
			}
			if(Math.abs(bSum-sSum) < answer)
				answer = Math.abs(bSum-sSum);
		}

		bw.write(Integer.toString(answer));
		bw.flush();
	}

}
