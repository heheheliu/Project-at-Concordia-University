import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
//  https://blog.csdn.net/NGUP_LEE/article/details/104760264  //
public class Prgram {
    public static int[] dx = {1,0,0,-1};
    public static int[] dy = {0,1,-1,0};

    public static int[][] floodFill_BFS(int[][] image,int sr, int sc, int newColor){
        int c = image[0].length;
        int r = image.length;
        int initialColor = image[sr][sc];


        if (initialColor == newColor)
            return image;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for(int i = 0; i < 4; i++){
                int rowX = x + dx[i], columnY = y + dy[i];
                if(rowX >= 0 && rowX < r && columnY >= 0 && columnY < c && image[rowX][columnY] == initialColor){
                    queue.offer(new int[]{rowX,columnY});
                    image[rowX][columnY] = newColor;

                }
            }

        }
        return image;
    }
    public static int[][] floodFill_DFS(int[][] image,int sr, int sc, int newColor){
        int c = image[0].length;
        int r = image.length;
        int initialColor = image[sr][sc];


        if (initialColor == newColor)
            return image;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{sr,sc});
        image[sr][sc] = newColor;
        while (!stack.isEmpty()){
            int[] cell = stack.pop();
            int x = cell[0], y = cell[1];
            for(int i = 0; i < 4; i++){
                int rowX = x + dx[i], columnY = y + dy[i];
                if(rowX >= 0 && rowX < r && columnY >= 0 && columnY < c && image[rowX][columnY] == initialColor){
                    stack.push(new int[]{rowX,columnY});
                    image[rowX][columnY] = newColor;

                }
            }

        }
        return image;
    }
    public static int[][] floodFill_DFS_recursion(int[][] image,int sr, int sc, int newColor){
        int inital = image[sr][sc];
        if(inital != newColor){
            dfs(image,sr,sc,inital,newColor);

        }
        return image;
    }
    public static void dfs(int[][] image,int sr, int sc, int inital, int newColor){
        if(image[sr][sc] == inital){
            image[sr][sc] = newColor;
            for (int i=0;i<4;i++){
                int rowX = sr + dx[i], columnY = sc + dy[i];
                if(rowX >= 0 && rowX < image.length && columnY >= 0 && columnY < image[0].length){
                    dfs(image,rowX,columnY,inital,newColor);
                }
            }
        }

    }

    public static void printMatrix(int[][] result){
        for(int i = 0; i< result.length;i++){
            System.out.print("[");
            for(int j = 0; j<result[0].length;j++){

                if(j == result[0].length-1){
                    System.out.println(result[i][j]+"]");
                }else {
                    System.out.print(result[i][j]+" ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] images = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc =1, newColor =2;
        int[][] result = floodFill_BFS(images,sr,sc,newColor);
        printMatrix(result);
        int[][] result2 = floodFill_DFS(images,sr,sc,newColor);
        printMatrix(result2);
        int[][] result3 = floodFill_DFS_recursion(images,sr,sc,newColor);
        printMatrix(result3);
    }
}
