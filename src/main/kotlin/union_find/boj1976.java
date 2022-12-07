package union_find;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1976 {
    static int N, M;
    static int[][] map;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    if (find(i) != find(j)) {
                        union(i, j);
                    }

                }
            }
        }

        int[] plan = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        int p = find(plan[0]);
        boolean flag = true;
        for(int i = 1; i < M; i++){
            if(p != find(plan[i])){
                flag = false;
                break;
            }
        }

        if(!flag){
            System.out.println("NO");
        }else{
            System.out.println("YES");

        }

    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            if (x > y) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
        }
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

}
