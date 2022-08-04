import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    int num;
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        visited = new boolean[size];
        num = 0;
        dfs(rooms,0);
        return num == size;


    }
    public void dfs(List<List<Integer>> rooms, int d){
        visited[d] = true;
        num++;
        for(int key: rooms.get(d)){
            if(!visited[key]){
                dfs(rooms, key);
            }
        }
    }
    public boolean canVisitAllRooms_2(List<List<Integer>> rooms) {
        int num = 0;
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int door = queue.poll();
            num++;
            for(int key : rooms.get(door)){
                if(!visited[key]){
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }

        return num == size;
    }

}
