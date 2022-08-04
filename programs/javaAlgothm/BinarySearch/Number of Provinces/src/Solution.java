import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[len];
        for(int i = 0; i < len; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }
    public void dfs(int[][] isConnected, boolean[] visited, int i){
        for(int j = 0; j < isConnected.length; j++){
            if(!visited[j] && isConnected[i][j] == 1){
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }

    public int findCircleNum_2(int[][] isConnected){
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int provinces = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<len; i++){
            if(!visited[i]){
                queue.offer(i);
                while(!queue.isEmpty()){
                    int j = queue.poll();
                    visited[j] = true;
                    for(int k = 0; k<len; k++){
                        if(isConnected[j][k] == 1 && !visited[k]){
                           queue.offer(k);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }


}
