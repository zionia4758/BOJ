
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DK_B1260 {

	static boolean[] visited;
	static List<Integer>[] childs;
	static ArrayDeque<Integer> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		int v = Integer.parseInt(tk.nextToken());
		queue = new ArrayDeque<>();
		childs = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			childs[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			tk = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			childs[p].add(c);
			childs[c].add(p);
		}
		for(int i=1; i<=n; i++) {
			Collections.sort(childs[i]);
		}
		List<Integer> dfsA = new ArrayList<>(n);
		List<Integer> bfsA = new ArrayList<>(n);
		visited = new boolean[n+1];
		visited[v] = true;
		dfs(v,dfsA);
		visited = new boolean[n+1];
		visited[v] = true;
		bfs(v,bfsA);
		StringBuilder sb = new StringBuilder();
		for(int num: dfsA)
			sb.append(num).append(' ');
		sb.append('\n');
		for(int num:bfsA){
			sb.append(num).append(' ');
		}
		System.out.println(sb);
	}
	static void dfs(int node,List answer) {
		answer.add(node);
		for(int child: childs[node]) {
			if(!visited[child]) {
				visited[child] = true;
				dfs(child,answer);
			}
		}
	}
	static void bfs(int node,List answer) {
		queue.offer(node);
		while(!queue.isEmpty()) {
			int i = queue.pollFirst();
			answer.add(i);
			for(int child: childs[i]) {
				if(!visited[child]) {
					queue.offerLast(child);
					visited[child] = true;
				}
			}
		}
		
		
	}

}
