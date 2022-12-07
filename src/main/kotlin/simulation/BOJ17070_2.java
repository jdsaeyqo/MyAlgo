package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ17070_2 {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    static int cnt = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (map[N][N] == 1) {
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(cnt);
    }

    static void bfs() {

        Queue<Pipe> q = new LinkedList<>();

        q.add(new Pipe(1, 2, 0));

        while (!q.isEmpty()) {
            Pipe cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            if (r == N && c == N) {
                cnt++;
                continue;
            }
            switch (cur.dir) {

                case 0:
                    if (checkIdx(r + dx[0], c + dy[0])) {
                        q.add(new Pipe(r + dx[0], c + dy[0], 0));
                    }
                    if (checkIdx(r + dx[2], c + dy[2]) && checkCross(r + dx[2], c + dy[2])) {
                        q.add(new Pipe(r + dx[2], c + dy[2], 2));
                    }
                    break;

                case 1:
                    if (checkIdx(r + dx[1], c + dy[1])) {
                        q.add(new Pipe(r + dx[1], c + dy[1], 1));
                    }
                    if (checkIdx(r + dx[2], c + dy[2]) && checkCross(r + dx[2], c + dy[2])) {
                        q.add(new Pipe(r + dx[2], c + dy[2], 2));
                    }
                    break;
                case 2:
                    if (checkIdx(r + dx[0], c + dy[0])) {
                        q.add(new Pipe(r + dx[0], c + dy[0], 0));
                    }
                    if (checkIdx(r + dx[1], c + dy[1])) {
                        q.add(new Pipe(r + dx[1], c + dy[1], 1));
                    }
                    if (checkIdx(r + dx[2], c + dy[2]) && checkCross(r + dx[2], c + dy[2])) {
                        q.add(new Pipe(r + dx[2], c + dy[2], 2));
                    }
                    break;

            }

        }

    }

    static boolean checkIdx(int r, int c) { // 인덱스 체크
        if (r < 1 || r > N || c < 1 || c > N || map[r][c] == 1) {
            return false;
        }
        return true;
    }

    static boolean checkCross(int r, int c) { // 대각 체크
        if (map[r - 1][c] == 1 || map[r][c - 1] == 1) {
            return false;
        }
        return true;
    }


}

class Pipe {
    int r, c;
    int dir;

    Pipe(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }

}