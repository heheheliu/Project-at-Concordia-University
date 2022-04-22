import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
//given a two dimensional array of potentially unequal height and width containing only 0s and 1s. 
//each 0 represents land
//each 1 represents part of a river.
//a river consists of any number of 1s that are either horizontally or vertically adjacent(but not diagonally adjacent).
//the number of adjacent 1s forming a river determine its size.
//a function that returns an array of the sizes of all rivers represented in the input matrix. the sizes do not need to be in any particular order
public class SizeRiver {
    public static List<Integer> riversize(int[][] matrix){
        List<Integer> sizeArr = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i =0; i< matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (visited[i][j]){
                    continue;
                }
                traverse_node(i,j,matrix,visited,sizeArr);
            }
        }
        return sizeArr;
    }

    public static void traverse_node(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizeArr){
        int current_River_Size = 0;
        Stack<Integer[]> nodeToExplore = new Stack<>();
        nodeToExplore.push(new Integer[] {i,j});
        while (!nodeToExplore.empty()){
            Integer[] currentNode = nodeToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];
            if (visited[i][j]){
                continue;
            }
            if (matrix[i][j] == 0){
                continue;
            }
            visited[i][j] = true;
            current_River_Size++;
            List<Integer[]> currentNodeUnvisitedNeighbour = getUnvisitedNeighbour(i,j,matrix,visited);
            for (Integer[] neighbour: currentNodeUnvisitedNeighbour) {
                nodeToExplore.push(neighbour);

            }
        }
        if(current_River_Size>0){
            sizeArr.add(current_River_Size);
        }
    }
    public static List<Integer[]> getUnvisitedNeighbour(int i, int j, int[][] matrix, boolean[][] visited){
        List<Integer[]> unvisitedNeighbours = new ArrayList<>();

        if (i>0 && !visited[i-1][j]){
            unvisitedNeighbours.add(new Integer[] {i-1, j});
        }
        if (i<matrix.length-1 && !visited[i+1][j]){
            unvisitedNeighbours.add(new Integer[] {i+1,j});
        }
        if (j>0 && !visited[i][j-1]){
            unvisitedNeighbours.add(new Integer[] {i,j-1});
        }
        if (j<matrix[0].length-1 && !visited[i][j+1]){
            unvisitedNeighbours.add(new Integer[] {i,j+1});
        }
        return unvisitedNeighbours;
    }
    // public static void main(String[] args) {
    //     int[][] input = {
    //             {1, 0, 0, 1, 0},
    //             {1, 0, 1, 0, 0},
    //             {0, 0, 1, 0, 1},
    //             {1, 0, 1, 0, 1},
    //             {1, 0, 1, 0, 1},
    //     };

    //     List<Integer> riverSizesList = riversize(input);
    //     Collections.sort(riverSizesList);
    //     for(Integer x : riverSizesList){
    //         System.out.print( x + ",");
    //     }


    // }

}
