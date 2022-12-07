package dfs;

import java.util.*;
public class PG43164 {
    int n;
    boolean[] visit;
    ArrayList<String> ansList = new ArrayList<>();
    public String[] solution(String[][] tickets) {

        n = tickets.length;
        visit = new boolean[n];

        dfs(0,"ICN","ICN",tickets);

        Collections.sort(ansList);
        String[] ans = ansList.get(0).split(" ");
        return ans;
    }
    public void dfs(int cur, String city, String path, String[][] tickets){
        if(cur == n){
            ansList.add(path);
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visit[i] && tickets[i][0].equals(city)){
                visit[i] = true;
                dfs(cur+1,tickets[i][1],path+" "+tickets[i][1],tickets);
                visit[i] = false;
            }
        }
    }

}