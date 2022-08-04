import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Boolean[][] seen = new Boolean[m][n];
        int[][] distance = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                    distance[i][j] = 0;
                    seen[i][j] = true;
                }else{
                    seen[i][j] = false;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for(int i = 0; i<4; i++){
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < m && my >= 0 && my < n && !seen[mx][my]){
                    queue.offer(new int[]{mx,my});
                    distance[mx][my] = distance[x][y] + 1;
                    seen[mx][my] = true;
                }
            }
        }
        return distance;

    }
}
