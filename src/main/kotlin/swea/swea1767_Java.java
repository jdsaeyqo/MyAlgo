package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class swea1767_Java {

    static int N, M , TC;
    static int[][] map;
    static ArrayList<int[]> coreList;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int minLen;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TC = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= TC; t++){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            coreList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i >= 1 && i < N-1 && j >= 1 && j < N-1) {
                        if(map[i][j] == 1) {
                            coreList.add(new int[] {i,j});
                        }
                    }
                }
            }
            M = coreList.size();
            minLen = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            dfs(0,0,0);

            System.out.println("#"+t+" "+minLen);
        }

    }

    static void dfs(int cur,int c ,int min) {

        if (cur == M) {
            if(c > max){
                max = c;
                minLen = min;
            }else if(c == max){
                if(minLen > min){
                    minLen = min;
                }
            }
            return;
        }

        int[] core = coreList.get(cur);
        int x = core[0];
        int y = core[1];

        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            int nx = x;
            int ny = y;

            while(true){
                nx += dx[i];
                ny += dy[i];

                if(!(nx >= 0 && nx < N && ny >= 0 && ny < N)) {
                    break;
                }

                if(map[nx][ny] == 1 || map[nx][ny] == 2) {
                    cnt = 0;
                    break;
                }
                cnt++;
            }

            int xx = x;
            int yy = y;
            for(int j = 0; j < cnt; j++){
                map[xx+dx[i]][yy+dy[i]] = 2;
                xx += dx[i];
                yy += dy[i];
            }

            if(cnt == 0){
                dfs(cur+1,c,min);
            }else{
                dfs(cur+1,c+1,min+cnt);
                xx= x;
                yy= y;
                for(int j = 0; j < cnt; j++){
                    map[xx+dx[i]][yy+dy[i]] = 0;
                    xx += dx[i];
                    yy += dy[i];
                }
            }

        }

    }
}
