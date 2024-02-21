
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DK_B13023 {
	static boolean[] visited;
	static List<Integer>[] graph ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tk.nextToken());
		int m = Integer.parseInt(tk.nextToken());
		//a->b->c->d->e 의 관계가 있는가?
		//플로이드 워셜로 4가 되는 거리가 있는가? n이 너무큼
		graph = new List[n];
		visited = new boolean[n];
		for(int i=0; i<n;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			tk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b= Integer.parseInt(tk.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		int result = 0;

		for(int i=0; i<n; i++) {
			if(dfs(i,0)) {
				result = 1;
				break;
			}
		}
		
		System.out.println(result);
	}
	static boolean dfs(int idx, int num) {
		if(num == 4) {
			return true;
		}
		visited[idx] = true;
		for(int next:graph[idx]) {
			if(visited[next]) continue;
			if(dfs(next, num+1))
				return true;
		}
		visited[idx] = false;
		return false;
	}

}
