import java.util.Stack;

public class Solution {
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};
    public int maxAreaOfIsland(int[][] grid) {
        int maxLen = 0;
        int row = grid.length;
        int column = grid[0].length;
        if(grid == null || row == 0){
            return 0;
        }
        boolean[][] visited = new boolean[row][column];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    stack.push(new int[]{i,j});
                    visited[i][j] = true;
                    int count = 0;
                    while(!stack.isEmpty()){
                        int[] cell = stack.pop();
                        count++;
                        int x = cell[0];
                        int y = cell[1];

                        for(int k =0; k<4; k++){
                            int mx = x + dx[k];
                            int my = y + dy[k];
                            if(mx >= 0 && mx<row && my >=0 && my<column && !visited[mx][my] && grid[mx][my] == 1){
                                stack.push(new int[]{mx,my});
                                visited[mx][my] = true;

                            }
                        }
                    }
                    maxLen = Math.max(maxLen,count);
                }
            }
        }
        return maxLen;
    }

    public int maxAreaOfIsland_2(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if(grid == null || r == 0){
            return 0;
        }
        int maxLen = 0;
        boolean[][] visited = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    maxLen = Math.max(maxLen,dfs(grid,visited,i,j));
                }
            }
        }
        return maxLen;
    }
    public int dfs(int[][] grid, boolean[][] visited, int x, int y){
        int r = grid.length;
        int c = grid[0].length;
        if(x<0 || x>=r || y<0 || y>=c || grid[x][y] == 0 || visited[x][y] ){
            return 0;
        }
        visited[x][y] = true;
        int sum = 1;
        sum += dfs(grid,visited,x-1,y);
        sum += dfs(grid,visited,x+1,y);
        sum += dfs(grid,visited,x,y-1);
        sum += dfs(grid,visited,x,y+1);
        return sum;
    }

}
