import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class remove_island {


    public static int[][] remove_Island(int[][] matrix){
        int[][] borderIsland = new int[matrix.length][matrix[0].length];
        for(int i =0; i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (is_border(i,j,matrix) && matrix[i][j]==1){
                    traverse_node(i,j,matrix,borderIsland);
                }
            }
        }

        return borderIsland;
    }
    public static void traverse_node(int i, int j, int[][] matrix, int[][] borderIsland){
        Stack<Integer[]> nodeToExplore = new Stack<>();
        nodeToExplore.add(new Integer[] {i,j});
        while(!nodeToExplore.empty()){
            Integer[] currentNode = nodeToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];
            if(borderIsland[i][j]==1){
                continue;
            }
            if(matrix[i][j]==0){
                continue;
            }
            borderIsland[i][j] = 1;
            List<Integer[]> currentNodeNeighbour = getUnvisitedNeigbours(i,j,matrix,borderIsland);
            for (Integer[] neighbour: currentNodeNeighbour){
                nodeToExplore.add(neighbour);
            }

        }


    }

    public static List<Integer[]> getUnvisitedNeigbours(int i, int j, int[][] matrix, int[][] borderIsland){
        List<Integer[]> unvisitedNeighbours = new ArrayList<>();

        if (i>0 && borderIsland[i-1][j]!=1){
            unvisitedNeighbours.add(new Integer[] {i-1, j});
        }
        if (i<matrix.length-1 && borderIsland[i+1][j]!=1){
            unvisitedNeighbours.add(new Integer[] {i+1,j});
        }
        if (j>0 && borderIsland[i][j-1]!=1){
            unvisitedNeighbours.add(new Integer[] {i,j-1});
        }
        if (j<matrix[0].length-1 && borderIsland[i][j+1]!=1){
            unvisitedNeighbours.add(new Integer[] {i,j+1});
        }
        return unvisitedNeighbours;
    }



    public static boolean is_border(int i, int j, int[][] matrix){
        if (i ==0 || j==0 || i==matrix.length-1||j==matrix[0].length-1){
            return true;
        }
        return false;
    }

    // public static void main(String[] args) {
    //     int[][] input = {
    //             {1, 0, 0, 0, 0, 0},
    //             {0, 1, 0, 1, 1, 1},
    //             {0, 0, 1, 0, 1, 0},
    //             {1, 1, 0, 0, 1, 0},
    //             {1, 0, 1, 1, 0, 0},
    //             {1, 0, 0, 0, 0, 1},

    //     };
    //     int[][] output = remove_Island(input);
    //     for(int i =0; i<output.length;i++){
    //         for (int j=0;j<output[0].length;j++){
    //             System.out.print(output[i][j]+", ");
    //         }
    //         System.out.println("");
    //     }
    // }








}

