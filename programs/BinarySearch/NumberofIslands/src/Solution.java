import java.util.Stack;

public class Solution {
    int[] dy = new int[]{1,0,0,-1};
    int[] dx = new int[]{0,1,-1,0};
    //DFS 迭代
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int numOfisland = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == '1'){
                    numOfisland++;
                    grid[i][j] = 0;
                    stack.push(new int[]{i,j});
                    while(!stack.isEmpty()){
                        int[] cell = stack.pop();
                        int rowX = cell[0];
                        int columnY = cell[1];
                        for(int k =0; k<4; k++){
                            int mx = rowX + dx[k], my = columnY + dy[k];
                            if(mx >=0 && mx < r && my >= 0 && my < c && grid[mx][my] == '1'){
                                stack.push(new int[]{mx,my});
                                grid[mx][my] = '0';
                            }

                        }
                    }

                }
            }
        }
        return numOfisland;
    }

    public void dfs(int x,int y, char[][] gride){
        int grideRow = gride.length;
        int grideColumn = gride[0].length;
        if(x <0 || x>=grideRow || y <0 || y>=grideColumn||gride[x][y] == '0'){
            return;
        }
        gride[x][y] = '0';
        dfs(x+1,y,gride);
        dfs(x-1,y,gride);
        dfs(x,y+1,gride);
        dfs(x,y-1,gride);
    }

    public int numIslands_DFS_recursion(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int nums = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<column; j++){
                if(grid[i][j] == '1'){
                    nums++;
                    dfs(i,j,grid);
                }
            }
        }
        return nums;
    }

}
