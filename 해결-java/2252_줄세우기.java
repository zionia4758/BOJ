
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DK_B2252 {
	static StringBuilder sb = new StringBuilder();
	static int[][] child;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		
		int[] numCnt = new int[n+1];
		List<Integer>[] parents = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			parents[i] = new ArrayList<>(4);
		}
		for(int i=0; i<m; i++) {
			tk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b= Integer.parseInt(tk.nextToken());
			numCnt[b]++;
			parents[a].add(b);
		}
		
		Queue<Integer> queue = new ArrayDeque<>(n);
		for(int i=1; i<=n; i++) {
			if(numCnt[i]==0)
				queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node).append(' ');
			for(int p:parents[node]) {
				numCnt[p] --;
				if(numCnt[p]==0)
					queue.offer(p);
			}
		}

		System.out.println(sb);
	}

}

