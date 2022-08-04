import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};

    public int maxDistance(int[][] grid) {
        final int INF = 1000000;
        int r = grid.length;
        int c = grid[0].length;
        int[][] d = new int[r][c];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < r; i++){
            for(int j =0; j<c; j++){
                if(grid[i][j] == 1){
                    d[i][j] = 0;
                    queue.offer(new int[]{i,j});

                }else{
                    d[i][j] = INF;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for(int i = 0; i<4; i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                if(mx < 0 || my < 0 || mx >= r || my >= c){
                    continue;
                }
                if(d[mx][my] > d[x][y] + 1){
                    d[mx][my] = d[x][y] + 1;
                    queue.offer(new int[]{mx,my});
                }
            }
        }
        int max = -1;
        for(int i = 0; i<r;i++ ){
            for(int j = 0;j<c;j++){
                if(grid[i][j] == 0){
                    max = Math.max(max, d[i][j]);
                }

            }
        }
        return max == INF ? -1 : max;
    }

}
