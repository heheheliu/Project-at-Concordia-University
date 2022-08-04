import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};


    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;

        int mins = 0;
        Boolean has_fresh = false;
        int cnt = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i =0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if( grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }

        while(!queue.isEmpty()){
            has_fresh = false;
            int len = queue.size();
            for(int l = 0; l < len; l++){
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for(int k = 0; k<4; k++){
                    int mx = x + dx[k], my = y + dy[k];
                    if(mx >=0 && my >=0 && mx < r && my < c && grid[mx][my] == 1){
                        grid[mx][my] = 2;
                        cnt--;
                        has_fresh = true;
                        queue.offer(new int[]{mx,my});
                    }
                }

            }
            if(has_fresh){
                mins ++;
            }
        }
        if(cnt > 0){
            return -1;
        }
        return mins;
    }
}
